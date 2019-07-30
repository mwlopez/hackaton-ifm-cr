using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Web.Hosting;
using System.Web.Http;
using APIProgramathon.Models;
using Npgsql;
using NpgsqlTypes;
using RestSharp;
using Twilio;
using Twilio.Rest.Api.V2010.Account;

namespace APIProgramathon.Controllers
{
    public class PagosController : ApiController
    {
        /// <summary>
        /// Proceso que envia una notificación via Whatsapp
        /// </summary>
        /// <param name="req">Clase contenedora de la notificación. Tiene el número telefónico y el mensaje a enviar, ademas del medio de notificacion</param>
        public void EnviarNotificacion(ReqNotification req)
        {
            // Find your Account Sid and Token at twilio.com/console
            // DANGER! This is insecure. See http://twil.io/secure
            string accountSid = System.Configuration.ConfigurationManager.AppSettings["accountSid"].ToString();
            string authToken = System.Configuration.ConfigurationManager.AppSettings["authToken"].ToString();

            TwilioClient.Init(accountSid, authToken);

            var message = MessageResource.Create(
                from: new Twilio.Types.PhoneNumber(System.Configuration.ConfigurationManager.AppSettings["phone"].ToString()),
                body: req.Message,
                to: new Twilio.Types.PhoneNumber("whatsapp:+506" + req.Phone)
            );
        }

        /// <summary>
        /// Se encarga de realizar una carga de lotes al sistema. Ingresandolo en el flujo de procesamiento para cada lote
        /// </summary>
        /// <param name="req">Información del encabezado y de las transacciones que se componen del lote</param>
        /// <returns></returns>
        public ResCargarPago CargarOrden(ReqCargarPago req)
        {
            ResCargarPago res = new ResCargarPago();

            if (req != null && req.Pagos != null && req.Pagos.Count > 0)
            {

                var connString = System.Configuration.ConfigurationManager.AppSettings["stringConecction"].ToString();

                using (var conn = new NpgsqlConnection(connString))
                {
                    conn.Open();

                    // Insert some data
                    using (var cmd = new NpgsqlCommand())
                    {
                        cmd.Connection = conn;
                        cmd.CommandText = "INSERT INTO lote_pago_encabezado ( entidad, fecha_registro, estado) VALUES (@p, @p1, @p2) returning id_lote;";
                        cmd.Parameters.AddWithValue("p", "IMAS");
                        cmd.Parameters.AddWithValue("p1", DateTime.Now);
                        cmd.Parameters.AddWithValue("p2", "PROCESANDO");

                        Object objres = cmd.ExecuteScalar();
                        res.IdLote = int.Parse(objres.ToString());


                    }


                }
                HostingEnvironment.QueueBackgroundWorkItem(cancellationToken => StartProcessingDetail(res.IdLote, req.Pagos, cancellationToken));


                res.Resultado = true;
                return res;

                

            }
            else
            {
                return new ResCargarPago
                {
                    IdLote = 0,
                    Resultado = false
                };
            }

        }


        /// <summary>
        /// Metodo asincrónico que realiza el ingreso de los detalles y validaciones a las reglas dinámicas
        /// </summary>
        /// <param name="idLote">Número de lote que se debe de procesar</param>
        /// <param name="pagos">Listado de pagos que se van a ingresar en al propuesta</param>
        /// <param name="cancellationToken">Token de cancelación del proceso asincrónico</param>
        public void StartProcessingDetail(long idLote, List<APIProgramathon.Models.Pago> pagos, CancellationToken cancellationToken = default(CancellationToken))
        {
            var connString = System.Configuration.ConfigurationManager.AppSettings["stringConecction"].ToString();

            Dictionary<string, string> ids = new Dictionary<string, string>();
            List<ReqValidador> validaciones = new List<ReqValidador>();


            foreach (APIProgramathon.Models.Pago i in pagos)
            {
                if (ids.ContainsKey(i.Id))
                {

                    ReqValidador val = validaciones.SingleOrDefault(t => t.numdocumento == i.Id);

                    val.programas.Add(new Programa()
                    {
                        monto = (int)i.Value,
                        programa = i.Program
                    });

                }
                else
                {
                    ReqValidador val = new ReqValidador()
                    {
                        cuentabanco = i.IBAN,
                        numdocumento = i.Id,
                        programas = new List<Programa>()
                    };
                    val.programas.Add(new Programa()
                    {
                        monto = (int)i.Value,
                        programa = i.Program
                    });

                    validaciones.Add(val);
                    ids.Add(i.Id, i.Id);


                }

            }


            foreach (ReqValidador val in validaciones)
            {

                string resultado = validarPago(val);
                ids[val.numdocumento] = resultado;
            }


            try
            {
                using (var conn = new NpgsqlConnection(connString))
                {
                    conn.Open();

                    foreach (APIProgramathon.Models.Pago i in pagos)
                    {

                       

                        // Insert some data
                        using (var cmd = new NpgsqlCommand())
                        {
                            string estado = "Rechazado";
                            string motivoError = string.Empty;
                            string estadoVAlidacion = ids[i.Id];
                            if (estadoVAlidacion.Contains("\"ok\""))
                            {
                                estado = "Aceptado";
                            }
                            else {
                                motivoError = estadoVAlidacion.Substring(12, estadoVAlidacion.IndexOf("\"",13) - 12 );
                            }

                            cmd.Connection = conn;
                            cmd.CommandText = "INSERT INTO lote_pago_detalle ( id_lote, first_name, last_name, email, program, date, value, iban, response, identificacion, motivo_error) VALUES (@p, @p1, @p2, @p3, @p4, @p5, @p6, @p7, @p8, @p9, @p10) ";
                            cmd.Parameters.AddWithValue("p", idLote);
                            cmd.Parameters.AddWithValue("p1", i.FirstName);
                            cmd.Parameters.AddWithValue("p2", i.LastName);
                            cmd.Parameters.AddWithValue("p3", i.Email);

                            cmd.Parameters.AddWithValue("p4", i.Program);
                            cmd.Parameters.AddWithValue("p5", i.Date);
                            cmd.Parameters.AddWithValue("p6", i.Value);
                            cmd.Parameters.AddWithValue("p7", i.IBAN);
                            cmd.Parameters.AddWithValue("p8", estado);

                            cmd.Parameters.AddWithValue("p9", i.Id);

                            cmd.Parameters.AddWithValue("p10", motivoError);
                            cmd.ExecuteNonQuery();




                        }

                       
                    }

                    using (var cmd = new NpgsqlCommand())
                    {

                        cmd.Connection = conn;
                        cmd.CommandText = "update  lote_pago_encabezado  set Estado = @p where id_lote = @p1 ";
                        cmd.Parameters.AddWithValue("p", "PENDIENTE ENVIO");
                        cmd.Parameters.AddWithValue("p1", idLote);

                        cmd.ExecuteNonQuery();


                    }
                }




            }
            catch (Exception ex)
            {

            }

        }

        /// <summary>
        /// Realiza una validación de reglas para una transacción en específico. Simultaneamente valida en SINIRUBE y EN SINPE que no exi
        /// exista ningún problema con los datos de la transacción
        /// </summary>
        /// <param name="req"></param>
        /// <returns></returns>
        private string validarPago(ReqValidador req)
        {

            string url = System.Configuration.ConfigurationManager.AppSettings["urlValidacion"].ToString();
            try
            {
                var client = new RestClient(url);
                RestRequest request = new RestRequest();
                request.Method = Method.POST;
                request.RequestFormat = DataFormat.Json;
                request.AddJsonBody(req);

                var response = client.Execute(request);

                return response.Content;
            }
            catch (Exception e)
            {

            }
            return "";
        }




    }

    public class ReqValidador
    {
        public string numdocumento { set; get; }
        public string cuentabanco { set; get; }

        public List<Programa> programas { set; get; }
    }

    public class Programa
    {
        public int monto { set; get; }

        public string programa { set; get; }

    }
}

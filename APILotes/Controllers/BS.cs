using Npgsql;
using RestSharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;

namespace APIProgramathon.Controllers
{
    public class BS
    {
        public void insertDetail(long idLote, List<APIProgramathon.Models.Pago> pagos)
        {
            var connString = "Host=10.14.14.61;Port=5436;Username=postgres;Password=postgres;Database=demoifm";

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


            foreach (ReqValidador val in validaciones) {

                string resultado = validarPago(val);
                ids[val.numdocumento] = resultado;
            }

            //await Task.Run(() =>
            //{
            try
            {
                foreach (APIProgramathon.Models.Pago i in pagos)
                {

                    using (var conn = new NpgsqlConnection(connString))
                    {

                        conn.Open();

                        // Insert some data
                        using (var cmd = new NpgsqlCommand())
                        {

                            cmd.Connection = conn;
                            cmd.CommandText = "INSERT INTO lote_pago_detalle ( id_lote, first_name, last_name, email, program, date, value, iban, response, identificacion) VALUES (@p, @p1, @p2, @p3, @p4, @p5, @p6, @p7, @p8, @p9) ";
                            cmd.Parameters.AddWithValue("p", idLote);
                            cmd.Parameters.AddWithValue("p1", i.FirstName);
                            cmd.Parameters.AddWithValue("p2", i.LastName);
                            cmd.Parameters.AddWithValue("p3", i.Email);

                            cmd.Parameters.AddWithValue("p4", i.Program);
                            cmd.Parameters.AddWithValue("p5", i.Date);
                            cmd.Parameters.AddWithValue("p6", i.Value);
                            cmd.Parameters.AddWithValue("p7", i.IBAN);
                            cmd.Parameters.AddWithValue("p8", ids[i.Id]);

                            cmd.Parameters.AddWithValue("p9", i.Id);
                            cmd.ExecuteNonQuery();




                        }

                        using (var cmd = new NpgsqlCommand())
                        {
                            string estado = "Rechazado";
                            if (ids[i.Id].Contains("\"ok\"")) {
                                estado = "Aceptado";
                            }
                            cmd.Connection = conn;
                            cmd.CommandText = "INSERT INTO beneficiopersona_demo ( nombre, estado, idpersona, monto) VALUES (@p, @p1, @p2, @p3) ";
                            cmd.Parameters.AddWithValue("p", i.Program);
                            cmd.Parameters.AddWithValue("p1", estado);
                            cmd.Parameters.AddWithValue("p2", int.Parse(i.Id));
                            cmd.Parameters.AddWithValue("p3", i.Value);

                            cmd.ExecuteNonQuery();


                        }
                    }
                }
                //Parallel.ForEach(pagos, i =>
                //{
                //    using (var conn = new NpgsqlConnection(connString))
                //    {
                //        conn.Open();

                //        // Insert some data
                //        using (var cmd = new NpgsqlCommand())
                //        {

                //            cmd.Connection = conn;
                //            cmd.CommandText = "INSERT INTO lote_pago_detalle ( id_lote, first_name, last_name, email, program, date, value, iban) VALUES (@p, @p1, @p2, @p3, @p4, @p5, @p6, @p7) ";
                //            cmd.Parameters.AddWithValue("p", idLote);
                //            cmd.Parameters.AddWithValue("p1", i.FirstName);
                //            cmd.Parameters.AddWithValue("p2", i.LastName);
                //            cmd.Parameters.AddWithValue("p3", i.Email);

                //            cmd.Parameters.AddWithValue("p4", i.Program);
                //            cmd.Parameters.AddWithValue("p5", i.Date);
                //            cmd.Parameters.AddWithValue("p6", i.Value);
                //            cmd.Parameters.AddWithValue("p7", i.IBAN);

                //            cmd.ExecuteNonQuery();

                //        }


                //    }
                //});
            }
            catch (Exception ex)
            {

            }
            //});
        }


        public string validarPago(ReqValidador req )
        {

            string url = "http://10.14.14.61:8000/ifm/dev/api/regla/valida";
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
}
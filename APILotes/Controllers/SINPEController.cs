using APIProgramathon.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace APIProgramathon.Controllers
{
    public class SINPEController : ApiController
    {
        public ResValidarCuenta ObtenerInformacionCuenta(ReqValidarCuenta req)
        {

            Random rnd = new Random();
            int value = rnd.Next(1, 100);  // creates a number between 1 and 12

            if (value > 90)
            {
                return new ResValidarCuenta()
                {
                    Cliente = "",
                    CodigoError = 82,
                    Moneda = ""
                };
            }
            else
            {
                return new ResValidarCuenta()
                {
                    Cliente = "JOSE MELENDEZ ALFARO",
                    CodigoError = 0,
                    Moneda = "COLONES"
                };
            }
        }
    }
}

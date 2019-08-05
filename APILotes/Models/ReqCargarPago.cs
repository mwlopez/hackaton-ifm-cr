using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace APIProgramathon.Models
{
    public class ReqCargarPago
    {
        public string CodigoEntidad { set; get; }

        public List<Pago> Pagos { set; get; } 
    }
}
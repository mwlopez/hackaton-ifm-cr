using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace APIProgramathon.Models
{
    public class ReqValidarCuenta
    {
        public string IBAN { set; get; }

        public string Identificacion { set; get; }
    }
}
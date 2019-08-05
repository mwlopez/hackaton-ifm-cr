using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace APIProgramathon.Models
{
    public class Pago
    {
        public string Id { set; get;}
        public string FirstName { set; get; }
        public string LastName { set; get; }

        public string Email { set; get; }
        public string Description { set; get; }
        public string Program { set; get; }

        public DateTime Date { set; get; }


        public Decimal Value { set; get; }

        public string IBAN { set; get; }
    }
}
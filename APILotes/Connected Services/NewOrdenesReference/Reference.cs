﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace APIProgramathon.NewOrdenesReference {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="ReqCargarPago", Namespace="http://tempuri.org/")]
    [System.SerializableAttribute()]
    public partial class ReqCargarPago : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string CodigoEntidadField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private System.Collections.Generic.List<APIProgramathon.NewOrdenesReference.Pago> PagosField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false)]
        public string CodigoEntidad {
            get {
                return this.CodigoEntidadField;
            }
            set {
                if ((object.ReferenceEquals(this.CodigoEntidadField, value) != true)) {
                    this.CodigoEntidadField = value;
                    this.RaisePropertyChanged("CodigoEntidad");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false)]
        public System.Collections.Generic.List<APIProgramathon.NewOrdenesReference.Pago> Pagos {
            get {
                return this.PagosField;
            }
            set {
                if ((object.ReferenceEquals(this.PagosField, value) != true)) {
                    this.PagosField = value;
                    this.RaisePropertyChanged("Pagos");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Pago", Namespace="http://tempuri.org/")]
    [System.SerializableAttribute()]
    public partial class Pago : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string IdField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string FirstNameField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string LastNameField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string EmailField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string DescriptionField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string ProgramField;
        
        private System.DateTime DateField;
        
        private decimal ValueField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string IBANField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false)]
        public string Id {
            get {
                return this.IdField;
            }
            set {
                if ((object.ReferenceEquals(this.IdField, value) != true)) {
                    this.IdField = value;
                    this.RaisePropertyChanged("Id");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=1)]
        public string FirstName {
            get {
                return this.FirstNameField;
            }
            set {
                if ((object.ReferenceEquals(this.FirstNameField, value) != true)) {
                    this.FirstNameField = value;
                    this.RaisePropertyChanged("FirstName");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=2)]
        public string LastName {
            get {
                return this.LastNameField;
            }
            set {
                if ((object.ReferenceEquals(this.LastNameField, value) != true)) {
                    this.LastNameField = value;
                    this.RaisePropertyChanged("LastName");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=3)]
        public string Email {
            get {
                return this.EmailField;
            }
            set {
                if ((object.ReferenceEquals(this.EmailField, value) != true)) {
                    this.EmailField = value;
                    this.RaisePropertyChanged("Email");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=4)]
        public string Description {
            get {
                return this.DescriptionField;
            }
            set {
                if ((object.ReferenceEquals(this.DescriptionField, value) != true)) {
                    this.DescriptionField = value;
                    this.RaisePropertyChanged("Description");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=5)]
        public string Program {
            get {
                return this.ProgramField;
            }
            set {
                if ((object.ReferenceEquals(this.ProgramField, value) != true)) {
                    this.ProgramField = value;
                    this.RaisePropertyChanged("Program");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true, Order=6)]
        public System.DateTime Date {
            get {
                return this.DateField;
            }
            set {
                if ((this.DateField.Equals(value) != true)) {
                    this.DateField = value;
                    this.RaisePropertyChanged("Date");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true, Order=7)]
        public decimal Value {
            get {
                return this.ValueField;
            }
            set {
                if ((this.ValueField.Equals(value) != true)) {
                    this.ValueField = value;
                    this.RaisePropertyChanged("Value");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=8)]
        public string IBAN {
            get {
                return this.IBANField;
            }
            set {
                if ((object.ReferenceEquals(this.IBANField, value) != true)) {
                    this.IBANField = value;
                    this.RaisePropertyChanged("IBAN");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="ResCargarPago", Namespace="http://tempuri.org/")]
    [System.SerializableAttribute()]
    public partial class ResCargarPago : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        private bool ResultadoField;
        
        private long IdLoteField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true)]
        public bool Resultado {
            get {
                return this.ResultadoField;
            }
            set {
                if ((this.ResultadoField.Equals(value) != true)) {
                    this.ResultadoField = value;
                    this.RaisePropertyChanged("Resultado");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true, Order=1)]
        public long IdLote {
            get {
                return this.IdLoteField;
            }
            set {
                if ((this.IdLoteField.Equals(value) != true)) {
                    this.IdLoteField = value;
                    this.RaisePropertyChanged("IdLote");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="NewOrdenesReference.BackendServiceSoap")]
    public interface BackendServiceSoap {
        
        // CODEGEN: Generating message contract since element name req from namespace http://tempuri.org/ is not marked nillable
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/CargarOrden", ReplyAction="*")]
        APIProgramathon.NewOrdenesReference.CargarOrdenResponse CargarOrden(APIProgramathon.NewOrdenesReference.CargarOrdenRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/CargarOrden", ReplyAction="*")]
        System.Threading.Tasks.Task<APIProgramathon.NewOrdenesReference.CargarOrdenResponse> CargarOrdenAsync(APIProgramathon.NewOrdenesReference.CargarOrdenRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class CargarOrdenRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="CargarOrden", Namespace="http://tempuri.org/", Order=0)]
        public APIProgramathon.NewOrdenesReference.CargarOrdenRequestBody Body;
        
        public CargarOrdenRequest() {
        }
        
        public CargarOrdenRequest(APIProgramathon.NewOrdenesReference.CargarOrdenRequestBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class CargarOrdenRequestBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public APIProgramathon.NewOrdenesReference.ReqCargarPago req;
        
        public CargarOrdenRequestBody() {
        }
        
        public CargarOrdenRequestBody(APIProgramathon.NewOrdenesReference.ReqCargarPago req) {
            this.req = req;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class CargarOrdenResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="CargarOrdenResponse", Namespace="http://tempuri.org/", Order=0)]
        public APIProgramathon.NewOrdenesReference.CargarOrdenResponseBody Body;
        
        public CargarOrdenResponse() {
        }
        
        public CargarOrdenResponse(APIProgramathon.NewOrdenesReference.CargarOrdenResponseBody Body) {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class CargarOrdenResponseBody {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public APIProgramathon.NewOrdenesReference.ResCargarPago CargarOrdenResult;
        
        public CargarOrdenResponseBody() {
        }
        
        public CargarOrdenResponseBody(APIProgramathon.NewOrdenesReference.ResCargarPago CargarOrdenResult) {
            this.CargarOrdenResult = CargarOrdenResult;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface BackendServiceSoapChannel : APIProgramathon.NewOrdenesReference.BackendServiceSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class BackendServiceSoapClient : System.ServiceModel.ClientBase<APIProgramathon.NewOrdenesReference.BackendServiceSoap>, APIProgramathon.NewOrdenesReference.BackendServiceSoap {
        
        public BackendServiceSoapClient() {
        }
        
        public BackendServiceSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public BackendServiceSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public BackendServiceSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public BackendServiceSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        APIProgramathon.NewOrdenesReference.CargarOrdenResponse APIProgramathon.NewOrdenesReference.BackendServiceSoap.CargarOrden(APIProgramathon.NewOrdenesReference.CargarOrdenRequest request) {
            return base.Channel.CargarOrden(request);
        }
        
        public APIProgramathon.NewOrdenesReference.ResCargarPago CargarOrden(APIProgramathon.NewOrdenesReference.ReqCargarPago req) {
            APIProgramathon.NewOrdenesReference.CargarOrdenRequest inValue = new APIProgramathon.NewOrdenesReference.CargarOrdenRequest();
            inValue.Body = new APIProgramathon.NewOrdenesReference.CargarOrdenRequestBody();
            inValue.Body.req = req;
            APIProgramathon.NewOrdenesReference.CargarOrdenResponse retVal = ((APIProgramathon.NewOrdenesReference.BackendServiceSoap)(this)).CargarOrden(inValue);
            return retVal.Body.CargarOrdenResult;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<APIProgramathon.NewOrdenesReference.CargarOrdenResponse> APIProgramathon.NewOrdenesReference.BackendServiceSoap.CargarOrdenAsync(APIProgramathon.NewOrdenesReference.CargarOrdenRequest request) {
            return base.Channel.CargarOrdenAsync(request);
        }
        
        public System.Threading.Tasks.Task<APIProgramathon.NewOrdenesReference.CargarOrdenResponse> CargarOrdenAsync(APIProgramathon.NewOrdenesReference.ReqCargarPago req) {
            APIProgramathon.NewOrdenesReference.CargarOrdenRequest inValue = new APIProgramathon.NewOrdenesReference.CargarOrdenRequest();
            inValue.Body = new APIProgramathon.NewOrdenesReference.CargarOrdenRequestBody();
            inValue.Body.req = req;
            return ((APIProgramathon.NewOrdenesReference.BackendServiceSoap)(this)).CargarOrdenAsync(inValue);
        }
    }
}
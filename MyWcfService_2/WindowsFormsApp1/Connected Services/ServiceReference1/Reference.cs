﻿//------------------------------------------------------------------------------
// <auto-generated>
//     此代码由工具生成。
//     运行时版本:4.0.30319.42000
//
//     对此文件的更改可能会导致不正确的行为，并且如果
//     重新生成代码，这些更改将会丢失。
// </auto-generated>
//------------------------------------------------------------------------------

namespace WindowsFormsApp1.ServiceReference1 {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServiceReference1.IService1")]
    public interface IService1 {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IService1/C2f", ReplyAction="http://tempuri.org/IService1/C2fResponse")]
        double C2f(double c);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IService1/C2f", ReplyAction="http://tempuri.org/IService1/C2fResponse")]
        System.Threading.Tasks.Task<double> C2fAsync(double c);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IService1/F2c", ReplyAction="http://tempuri.org/IService1/F2cResponse")]
        double F2c(double f);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IService1/F2c", ReplyAction="http://tempuri.org/IService1/F2cResponse")]
        System.Threading.Tasks.Task<double> F2cAsync(double f);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IService1Channel : WindowsFormsApp1.ServiceReference1.IService1, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class Service1Client : System.ServiceModel.ClientBase<WindowsFormsApp1.ServiceReference1.IService1>, WindowsFormsApp1.ServiceReference1.IService1 {
        
        public Service1Client() {
        }
        
        public Service1Client(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public Service1Client(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public Service1Client(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public Service1Client(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public double C2f(double c) {
            return base.Channel.C2f(c);
        }
        
        public System.Threading.Tasks.Task<double> C2fAsync(double c) {
            return base.Channel.C2fAsync(c);
        }
        
        public double F2c(double f) {
            return base.Channel.F2c(f);
        }
        
        public System.Threading.Tasks.Task<double> F2cAsync(double f) {
            return base.Channel.F2cAsync(f);
        }
    }
}
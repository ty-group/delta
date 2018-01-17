/**
 * AuthServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.sso.ws.api;

public class AuthServiceLocator extends org.apache.axis.client.Service implements com.thinkgem.jeesite.modules.sso.ws.api.AuthService {

    public AuthServiceLocator() {
    }


    public AuthServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AuthServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AuthServiceHttpSoap11Endpoint
    private java.lang.String AuthServiceHttpSoap11Endpoint_address = "http://10.11.3.61:8080/hiip-portal/services/AuthService.AuthServiceHttpSoap11Endpoint/";

    public java.lang.String getAuthServiceHttpSoap11EndpointAddress() {
        return AuthServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AuthServiceHttpSoap11EndpointWSDDServiceName = "AuthServiceHttpSoap11Endpoint";

    public java.lang.String getAuthServiceHttpSoap11EndpointWSDDServiceName() {
        return AuthServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setAuthServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        AuthServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public com.thinkgem.jeesite.modules.sso.ws.api.AuthServicePortType getAuthServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AuthServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAuthServiceHttpSoap11Endpoint(endpoint);
    }

    public com.thinkgem.jeesite.modules.sso.ws.api.AuthServicePortType getAuthServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.thinkgem.jeesite.modules.sso.ws.api.AuthServiceSoap11BindingStub _stub = new com.thinkgem.jeesite.modules.sso.ws.api.AuthServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getAuthServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAuthServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        AuthServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.thinkgem.jeesite.modules.sso.ws.api.AuthServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.thinkgem.jeesite.modules.sso.ws.api.AuthServiceSoap11BindingStub _stub = new com.thinkgem.jeesite.modules.sso.ws.api.AuthServiceSoap11BindingStub(new java.net.URL(AuthServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getAuthServiceHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AuthServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getAuthServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://api.ws.sso.modules.jeesite.thinkgem.com", "AuthService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://api.ws.sso.modules.jeesite.thinkgem.com", "AuthServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AuthServiceHttpSoap11Endpoint".equals(portName)) {
            setAuthServiceHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

/**
 * AutoName_serviceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.srmwsdl;

public class AutoName_serviceLocator extends org.apache.axis.client.Service implements com.delta.srmwsdl.AutoName_service {

    public AutoName_serviceLocator() {
    }


    public AutoName_serviceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AutoName_serviceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for autoName_port
    private java.lang.String autoName_port_address = "http://delta.train.going-link.com/itf/modules/ws_eitf/ACP_BILL/eitf_acp_bill_status_from_oa.svc";

    public java.lang.String getautoName_portAddress() {
        return autoName_port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String autoName_portWSDDServiceName = "autoName_port";

    public java.lang.String getautoName_portWSDDServiceName() {
        return autoName_portWSDDServiceName;
    }

    public void setautoName_portWSDDServiceName(java.lang.String name) {
        autoName_portWSDDServiceName = name;
    }

    public com.delta.srmwsdl.AutoName_portType getautoName_port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(autoName_port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getautoName_port(endpoint);
    }

    public com.delta.srmwsdl.AutoName_portType getautoName_port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.delta.srmwsdl.ACP_BILLEitf_acp_bill_status_from_oaSvc_bindingStub _stub = new com.delta.srmwsdl.ACP_BILLEitf_acp_bill_status_from_oaSvc_bindingStub(portAddress, this);
            _stub.setPortName(getautoName_portWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setautoName_portEndpointAddress(java.lang.String address) {
        autoName_port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.delta.srmwsdl.AutoName_portType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.delta.srmwsdl.ACP_BILLEitf_acp_bill_status_from_oaSvc_bindingStub _stub = new com.delta.srmwsdl.ACP_BILLEitf_acp_bill_status_from_oaSvc_bindingStub(new java.net.URL(autoName_port_address), this);
                _stub.setPortName(getautoName_portWSDDServiceName());
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
        if ("autoName_port".equals(inputPortName)) {
            return getautoName_port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "autoName_service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "autoName_port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("autoName_port".equals(portName)) {
            setautoName_portEndpointAddress(address);
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

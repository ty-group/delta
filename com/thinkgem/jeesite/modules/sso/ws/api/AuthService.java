/**
 * AuthService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.sso.ws.api;

public interface AuthService extends javax.xml.rpc.Service {
    public java.lang.String getAuthServiceHttpSoap11EndpointAddress();

    public com.thinkgem.jeesite.modules.sso.ws.api.AuthServicePortType getAuthServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public com.thinkgem.jeesite.modules.sso.ws.api.AuthServicePortType getAuthServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

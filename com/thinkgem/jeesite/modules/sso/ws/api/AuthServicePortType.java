/**
 * AuthServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.sso.ws.api;

public interface AuthServicePortType extends java.rmi.Remote {
    public com.thinkgem.jeesite.modules.sso.entity.xsd.SsoResultParam authService(java.lang.String uid, java.lang.String token) throws java.rmi.RemoteException;
}

package com.thinkgem.jeesite.modules.sso.ws.api;

public class AuthServicePortTypeProxy implements com.thinkgem.jeesite.modules.sso.ws.api.AuthServicePortType {
  private String _endpoint = null;
  private com.thinkgem.jeesite.modules.sso.ws.api.AuthServicePortType authServicePortType = null;
  
  public AuthServicePortTypeProxy() {
    _initAuthServicePortTypeProxy();
  }
  
  public AuthServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAuthServicePortTypeProxy();
  }
  
  private void _initAuthServicePortTypeProxy() {
    try {
      authServicePortType = (new com.thinkgem.jeesite.modules.sso.ws.api.AuthServiceLocator()).getAuthServiceHttpSoap11Endpoint();
      if (authServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)authServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)authServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (authServicePortType != null)
      ((javax.xml.rpc.Stub)authServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.thinkgem.jeesite.modules.sso.ws.api.AuthServicePortType getAuthServicePortType() {
    if (authServicePortType == null)
      _initAuthServicePortTypeProxy();
    return authServicePortType;
  }
  
  public com.thinkgem.jeesite.modules.sso.entity.xsd.SsoResultParam authService(java.lang.String uid, java.lang.String token) throws java.rmi.RemoteException{
    if (authServicePortType == null)
      _initAuthServicePortTypeProxy();
    return authServicePortType.authService(uid, token);
  }
  
  
}
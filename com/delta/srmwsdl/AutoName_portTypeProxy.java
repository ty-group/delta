package com.delta.srmwsdl;

public class AutoName_portTypeProxy implements com.delta.srmwsdl.AutoName_portType {
  private String _endpoint = null;
  private com.delta.srmwsdl.AutoName_portType autoName_portType = null;
  
  public AutoName_portTypeProxy() {
    _initAutoName_portTypeProxy();
  }
  
  public AutoName_portTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initAutoName_portTypeProxy();
  }
  
  private void _initAutoName_portTypeProxy() {
    try {
      autoName_portType = (new com.delta.srmwsdl.AutoName_serviceLocator()).getautoName_port();
      if (autoName_portType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)autoName_portType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)autoName_portType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (autoName_portType != null)
      ((javax.xml.rpc.Stub)autoName_portType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.delta.srmwsdl.AutoName_portType getAutoName_portType() {
    if (autoName_portType == null)
      _initAutoName_portTypeProxy();
    return autoName_portType;
  }
  
  public com.delta.srmwsdl.RESPONSE execute(com.delta.srmwsdl.REQUEST request_part) throws java.rmi.RemoteException{
    if (autoName_portType == null)
      _initAutoName_portTypeProxy();
    return autoName_portType.execute(request_part);
  }
  
  
}
package org.aurora_framework.www.schema;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

/**
 * 2017-12-28
 *Created by Ink,tangyue Corp 
 */
public class SRMRemoteUtil {

	public static RESPONSE invokeSRM(REQUESTHEADER header,REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD record) throws RemoteException, ServiceException{
		AutoName_serviceLocator locator = new AutoName_serviceLocator();
		PUR_CONEitf_pur_contract_status_from_oaSvc_bindingStub stub = (PUR_CONEitf_pur_contract_status_from_oaSvc_bindingStub)locator.getautoName_port();
		REQUEST request_part = new REQUEST();
		
		REQUESTCONTEXT CONTEXT = new REQUESTCONTEXT();
		REQUESTCONTEXTEITF_PUR_CON_APPROVE approve = new REQUESTCONTEXTEITF_PUR_CON_APPROVE();
		
		approve.setRECORD(record);
		CONTEXT.setEITF_PUR_CON_APPROVE(approve);
		request_part.setCONTEXT(CONTEXT);
		
		request_part.setHEADER(header);
		return stub.execute(request_part);
	}
	
}

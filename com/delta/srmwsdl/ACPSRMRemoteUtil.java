package com.delta.srmwsdl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

/**
 * 2017-12-28
 *Created by Ink,tangyue Corp 
 */
public class ACPSRMRemoteUtil {

	public static RESPONSE invokeSRM(REQUESTHEADER header,REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD record) throws RemoteException, ServiceException{
		AutoName_serviceLocator locator = new AutoName_serviceLocator();
		ACP_BILLEitf_acp_bill_status_from_oaSvc_bindingStub stub = (ACP_BILLEitf_acp_bill_status_from_oaSvc_bindingStub)locator.getautoName_port();
		REQUEST request_part = new REQUEST();
		
		REQUESTCONTEXT CONTEXT = new REQUESTCONTEXT();
		REQUESTCONTEXTEITF_ACP_BILL_APPROVE approve = new REQUESTCONTEXTEITF_ACP_BILL_APPROVE();
		
		approve.setRECORD(record);
		CONTEXT.setEITF_ACP_BILL_APPROVE(approve);
		request_part.setCONTEXT(CONTEXT);
		
		request_part.setHEADER(header);
		return stub.execute(request_part);
	}
	
}

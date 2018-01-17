package com.delta.cgsqwsdl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

/**
 * 2018-1-10
 *Created by Ink,tangyue Corp 
 */
public class Req2SRMUtil {
	public static RESPONSE execute(EnvelopeBodyREQUESTHEADER header,EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORD record) throws ServiceException, RemoteException{
		AutoName_serviceLocator locator = new AutoName_serviceLocator();
		PUR_REQEitf_pur_req_headers_foaSvc_bindingStub stub = (PUR_REQEitf_pur_req_headers_foaSvc_bindingStub)locator.getautoName_port();
		
		Envelope request_part = new Envelope();
		EnvelopeBody body = new EnvelopeBody();
		EnvelopeBodyREQUEST request = new EnvelopeBodyREQUEST();
		request.setHEADER(header);
		
		EnvelopeBodyREQUESTCONTEXT context = new EnvelopeBodyREQUESTCONTEXT();
		EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS headers = new EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS();
		
		headers.setRECORD(record);
		context.setEITF_PUR_REQ_HEADERS(headers);
		request.setCONTEXT(context);
		body.setREQUEST(request);
		request_part.setHeader("");
		request_part.setBody(body);
		
		
		
		return stub.execute(request_part);
	}
}

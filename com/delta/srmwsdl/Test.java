package com.delta.srmwsdl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;


public class Test {

	public static void main(String[] args) throws ServiceException, RemoteException {
		AutoName_serviceLocator locator = new AutoName_serviceLocator();
		ACP_BILLEitf_acp_bill_status_from_oaSvc_bindingStub stub = (ACP_BILLEitf_acp_bill_status_from_oaSvc_bindingStub)locator.getautoName_port();
		REQUEST request_part = new REQUEST();
		
		REQUESTCONTEXT CONTEXT = new REQUESTCONTEXT();
		REQUESTCONTEXTEITF_ACP_BILL_APPROVE approve = new REQUESTCONTEXTEITF_ACP_BILL_APPROVE();
		REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD record = new REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD();
		
		
		record.setBILL_NUMBER("1111");
		record.setBILL_STATUS("CONFIRMED");
		approve.setRECORD(record);
		CONTEXT.setEITF_ACP_BILL_APPROVE(approve);
		request_part.setCONTEXT(CONTEXT);
		
		REQUESTHEADER header = new REQUESTHEADER();
		header.setBATCH_NUM("1109011013");
		header.setBUSINESS_GROUP("BG00000101");
		header.setIF_CATE_CODE("ACP_BILL");
		header.setIF_CODE("ACP_BILL_STATUS");
		header.setPASSWORD("A083BC7AC27350AB4072E06F7CF2A53C");
		header.setREQUEST_ID("609133");
		header.setSEG_NUM("1");
		header.setSYSTEM_CODE("BG00000101_OA");
		header.setTOTAL_SEG_COUNT("2");
		header.setUSER_NAME("90485444");
		request_part.setHEADER(header);
		RESPONSE response = stub.execute(request_part);
		System.out.println(response.getSuccess());
		System.out.println(response.getRESPONSE_HEADER().getRESPONSE_MESSAGE());
		System.out.println(response.getRESPONSE_HEADER().getRESPONSE_STATUS());
	}
	
}

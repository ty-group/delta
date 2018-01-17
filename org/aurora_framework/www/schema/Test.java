package org.aurora_framework.www.schema;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Test {

	public static void main(String[] args) throws ServiceException, RemoteException {
		AutoName_serviceLocator locator = new AutoName_serviceLocator();
		PUR_CONEitf_pur_contract_status_from_oaSvc_bindingStub stub = (PUR_CONEitf_pur_contract_status_from_oaSvc_bindingStub)locator.getautoName_port();
		REQUEST request_part = new REQUEST();
		
		REQUESTCONTEXT CONTEXT = new REQUESTCONTEXT();
		REQUESTCONTEXTEITF_PUR_CON_APPROVE approve = new REQUESTCONTEXTEITF_PUR_CON_APPROVE();
		REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD record = new REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD();
		
		record.setCON_STATUS("backed");
		record.setDOCUMENT_NUMBER("SGHT000001");
		approve.setRECORD(record);
		CONTEXT.setEITF_PUR_CON_APPROVE(approve);
		request_part.setCONTEXT(CONTEXT);
		
		REQUESTHEADER header = new REQUESTHEADER();
		header.setBATCH_NUM("BATCH_NUM");
		header.setBUSINESS_GROUP("BUSINESS_GROUP");
		header.setIF_CATE_CODE("IF_CATE_CODE");
		header.setIF_CODE("IF_CODE");
		header.setPASSWORD("PASSWORD");
		header.setREQUEST_ID("REQUEST_ID");
		header.setSEG_NUM("SEG_NUM");
		header.setSYSTEM_CODE("SYSTEM_CODE");
		header.setTOTAL_SEG_COUNT("TOTAL_SEG_COUNT");
		header.setUSER_NAME("USER_NAME");
		request_part.setHEADER(header);
		stub.execute(request_part);
	}
	
}

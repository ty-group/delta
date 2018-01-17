package com.delta;

import java.util.List;

public class InstallParams {
	private String top = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">";
	private  String SOAHeader =  "<ns1:SOAHeader>"+
    "       <ns1:Responsibility>CUX_WS_USER_RESP</ns1:Responsibility>"+
    "       <ns1:RespApplication>CUX</ns1:RespApplication>"+
    "      <ns1:SecurityGroup>STANDARD</ns1:SecurityGroup>"+
    "     <ns1:NLSLanguage>AMERICAN</ns1:NLSLanguage>"+
    "    <ns1:Org_Id>82</ns1:Org_Id>"+
    "   </ns1:SOAHeader>"+
   " <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" soap:mustUnderstand=\"1\">"+
   "	<wsse:UsernameToken xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">"+
  	"   <wsse:Username>OA</wsse:Username>"+
  	 
  	 "<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">dhcdhc</wsse:Password>"+
   "</wsse:UsernameToken>"+
   "</wsse:Security>"+
   "</soap:Header>";
	
	
	/**
	 * 组装获取单据编号传入参数
	 * @param docType
	 * @return
	 */
	public String getDocNumParam(String docType){
		String param = top +"<soap:Header xmlns:ns1=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_inv_apply_data_ws_pkg/\">"+
						SOAHeader+
					    "<soap:Body xmlns:ns2=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_inv_apply_data_ws_pkg/get_doc_number/\">"+
				        "<ns2:InputParameters>"+
				            "<ns2:P_DOC_TYPE>"+docType+"</ns2:P_DOC_TYPE>"+
				        "</ns2:InputParameters>"+
				    "</soap:Body>"+
				"</soap:Envelope>";
		System.out.println(param);
		return param;
	}
	
	
	/**
	 * 组装布草传入参数
	 * @param linen
	 * @param list
	 * @return
	 */
	public String getOaLinen(Linen linen,List<LinenData> list){
		
		
		
		
		
		
		
		String params = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"+
					    "<soap:Header xmlns:ns1=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_inv_linen_data_ws_pkg/\">"+
					    "    <ns1:SOAHeader>"+
					    "       <ns1:Responsibility>CUX_WS_USER_RESP</ns1:Responsibility>"+
					    "        <ns1:RespApplication>CUX</ns1:RespApplication>"+
					    "        <ns1:SecurityGroup>STANDARD</ns1:SecurityGroup>"+
					    "        <ns1:NLSLanguage>AMERICAN</ns1:NLSLanguage>"+
					    "        <ns1:Org_Id>82</ns1:Org_Id>"+
					    "    </ns1:SOAHeader>"+
					    "     <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" soap:mustUnderstand=\"1\"><wsse:UsernameToken xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:Username>OA</wsse:Username><wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">dhcdhc</wsse:Password></wsse:UsernameToken></wsse:Security>"+
					    "</soap:Header>";
	  
		
		
		
		
		
		
		
		
		

		params += " <soap:Body xmlns:ns2=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_inv_linen_data_ws_pkg/inv_oa_linen/\">"+
        "<ns2:InputParameters>"+
        " <ns2:P_HEADER_TBL>"+
        "<ns2:P_HEADER_TBL_ITEM>"+
        
        
        "<ns2:ORG_ID>"+linen.getOrg_id()+"</ns2:ORG_ID>"+
        "<ns2:ORGANIZATION_ID>"+linen.getOrganization_id()+"</ns2:ORGANIZATION_ID>"+
        "<ns2:BILL_TYPE_ID>"+linen.getBill_type_id()+"</ns2:BILL_TYPE_ID>"+
        "<ns2:BILL_NUMBER>"+linen.getBill_number()+"</ns2:BILL_NUMBER>"+
        "<ns2:APPLY_DATE>"+linen.getApply_date()+"</ns2:APPLY_DATE>"+
        "<ns2:APPLY_ROOM>"+linen.getApply_room()+"</ns2:APPLY_ROOM>"+
        "<ns2:TRANSACTION_TYPE_ID></ns2:TRANSACTION_TYPE_ID>"+
        "<ns2:APPROVAL_DATE>"+linen.getApproval_date()+"</ns2:APPROVAL_DATE>"+
        "<ns2:STATUS_CODE>"+linen.getStatus_code()+"</ns2:STATUS_CODE>"+
        "<ns2:BILL_DESCRIPTION>"+linen.getBill_description()+"</ns2:BILL_DESCRIPTION>"+
        "<ns2:BILL_COMMENT>"+linen.getBill_comment()+"</ns2:BILL_COMMENT>"+
        "<ns2:SOURCE_CODE>OA</ns2:SOURCE_CODE>"+
        "<ns2:ATTRIBUTE14>"+linen.getAttribute14()+"</ns2:ATTRIBUTE14>"+
        "<ns2:ATTRIBUTE15>"+linen.getAttribute15()+"</ns2:ATTRIBUTE15>"+ 
        
     
       
        "<ns2:LINE_TBL>";  
		String line_tbl_item = "";
        for(int i=0; i < list.size() ; i++){
        	LinenData data = list.get(i);
        	line_tbl_item +="<ns2:LINE_TBL_ITEM>"+
 
        	"<ns2:ORG_ID>"+data.getOrg_id()+"</ns2:ORG_ID>"+
              "<ns2:LINE_NUMBER>"+data.getLine_number()+"</ns2:LINE_NUMBER>"+
              "<ns2:ITEM_ID>"+data.getItem_id()+"</ns2:ITEM_ID>"+
              "<ns2:ORGANIZATION_ID>"+data.getOrganization_id()+"</ns2:ORGANIZATION_ID>"+
              
              "<ns2:ACCOUNT_UNIT_CODE>"+data.getAccount_unit_code()+"</ns2:ACCOUNT_UNIT_CODE>"+
              "<ns2:APPLY_NUMBER>"+data.getApply_number()+"</ns2:APPLY_NUMBER>"+
              "<ns2:HANDLE_NUMBER>"+data.getHandle_number()+"</ns2:HANDLE_NUMBER>"+
              "<ns2:FROM_INVENTORY_CODE>"+data.getFrom_inventory_code()+"</ns2:FROM_INVENTORY_CODE>"+
              "<ns2:TO_INVENTORY_CODE>"+data.getTo_inventory_code()+"</ns2:TO_INVENTORY_CODE>"+
              "<ns2:PROCESS_PERSON_ID>"+data.getProcess_person_id()+"</ns2:PROCESS_PERSON_ID>"+
              "<ns2:PROCESS_DATE>"+data.getProcess_date()+"</ns2:PROCESS_DATE>"+
              "<ns2:LINE_STATUS_CODE>"+data.getLine_status_code()+"</ns2:LINE_STATUS_CODE>"+
              "<ns2:LINE_COMMENT>"+data.getLine_comment()+"</ns2:LINE_COMMENT>"+
             
              "</ns2:LINE_TBL_ITEM>";
        }
        
        params +=line_tbl_item+
		 "</ns2:LINE_TBL>"+
        "</ns2:P_HEADER_TBL_ITEM>"+
       "</ns2:P_HEADER_TBL> "+
      "</ns2:InputParameters>"+
    "</soap:Body>"+
   "</soap:Envelope>";
        
        
        return params;
        
	}
	
	
	
	/**
	 * 组装物资传入入参数
	 * @param linen
	 * @param list
	 * @return
	 */
	public String getOAIMP(Imp imp,List<ImpData> list){
		
		
		
		String params = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"+
	    "<soap:Header xmlns:ns1=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_inv_oa_apply_imp_ws/\">"+
	    "    <ns1:SOAHeader>"+
	    "        <ns1:Responsibility>CUX_WS_USER_RESP</ns1:Responsibility>"+
	    "        <ns1:RespApplication>CUX</ns1:RespApplication>"+
	    "        <ns1:SecurityGroup>STANDARD</ns1:SecurityGroup>"+
	    "        <ns1:NLSLanguage>AMERICAN</ns1:NLSLanguage>"+
	    "        <ns1:Org_Id>82</ns1:Org_Id>"+
	    "    </ns1:SOAHeader>"+
	    "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" soap:mustUnderstand=\"1\">" +
	    		"<wsse:UsernameToken xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">" +
	    		"<wsse:Username>OA</wsse:Username>" +
	    		"<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">dhcdhc</wsse:Password>" +
	    		"</wsse:UsernameToken></wsse:Security>" +
	    		"</soap:Header>"+ 
	   
	   
	    "<soap:Body xmlns:ns2=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_inv_oa_apply_imp_ws/inv_oa_apply/\">"+
	    "    <ns2:InputParameters>"+
	    "        <ns2:P_HEADER_TBL>"+
	    "            <ns2:P_HEADER_TBL_ITEM>"+
	    "                <ns2:ORGANIZATION_ID>"+imp.getOrganization_id()+"</ns2:ORGANIZATION_ID>"+
	    "                <ns2:URGENT_LEVEL>"+imp.getUrgent_level()+"</ns2:URGENT_LEVEL>"+
	    "                <ns2:DOC_TYPE_ID>"+imp.getDoc_type_id()+"</ns2:DOC_TYPE_ID>"+
	    "                <ns2:SOURCE_CODE>OA</ns2:SOURCE_CODE>"+
	    "                <ns2:DOC_NUMBER>"+imp.getDoc_number()+"</ns2:DOC_NUMBER>"+
	    "                <ns2:APPLY_EMPLOYEE_NUMBER>"+imp.getApply_employee_number()+"</ns2:APPLY_EMPLOYEE_NUMBER>"+
	    "                <ns2:APPLY_ORGANIZATION_ID></ns2:APPLY_ORGANIZATION_ID>"+
	    "                <ns2:APPLY_DATE>"+imp.getApply_date()+"</ns2:APPLY_DATE>"+
	    "                <ns2:SUB_INVENTORY_FROM>"+imp.getSub_inventory_from()+"</ns2:SUB_INVENTORY_FROM>"+
	    "                <ns2:SUB_INVENTORY_TO>"+imp.getSub_inventory_to()+"</ns2:SUB_INVENTORY_TO>"+
	    "                <ns2:WARD_AREA></ns2:WARD_AREA>"+
	    "                <ns2:MAINTAIN_ORDER>"+imp.getMaintain_order()+"</ns2:MAINTAIN_ORDER>"+
	    "                <ns2:PROJECT_NUMBER/>"+
	    "                <ns2:APPROVAL_DATE>"+imp.getApproval_date()+"</ns2:APPROVAL_DATE>"+
	    "                <ns2:APPROVAL_EMPLOYEE_NUMBER>"+imp.getApproval_employee_number()+"</ns2:APPROVAL_EMPLOYEE_NUMBER>"+
	    "                <ns2:DOC_STATUS>"+imp.getDoc_status()+"</ns2:DOC_STATUS>"+
	    "                <ns2:COMMENTS>"+imp.getComments()+"</ns2:COMMENTS>"+ 
	    "                <ns2:ATTRIBUTE15>"+imp.getApply_organization_id()+"</ns2:ATTRIBUTE15>"+ 
	    "                <ns2:LINE_TBL>";
		String line_tbl_item = "";
        for(int i=0; i < list.size() ; i++){  
        	ImpData data = list.get(i);  
        	line_tbl_item +="<ns2:LINE_TBL_ITEM>"+    
        	
    	    "                        <ns2:ORGANIZATION_ID>"+data.getOrganization_id()+"</ns2:ORGANIZATION_ID>"+
    	    "                        <ns2:LINE_NUMBER>"+data.getLine_number()+"</ns2:LINE_NUMBER>"+
    	    "                        <ns2:ITEM_NUMBER>"+data.getItem_number()+"</ns2:ITEM_NUMBER>"+
    	    "                        <ns2:ITEM_DESC>"+data.getItem_desc()+"、<![CDATA["+data.getGgxh()+"]]></ns2:ITEM_DESC>"+
    	    "                        <ns2:SUB_INVENTORY_FROM>"+data.getSub_inventory_from()+"</ns2:SUB_INVENTORY_FROM>"+
    	    "                        <ns2:SUB_INVENTORY_TO>"+data.getSub_inventory_to()+"</ns2:SUB_INVENTORY_TO>"+
    	    "                        <ns2:QUANTITY>"+data.getQuantity()+"</ns2:QUANTITY>"+
    	    "                        <ns2:UOM>"+data.getUom()+"</ns2:UOM>"+
    	    "                        <ns2:NEED_DATE>"+data.getNeed_date()+"</ns2:NEED_DATE>"+
    	    
    	    "                        <ns2:PROJECT_NUMBER/>"+ 
    	    "                        <ns2:LINE_STATUS>"+data.getLine_status()+"</ns2:LINE_STATUS>"+
    	    "                        <ns2:BOX_BOARD></ns2:BOX_BOARD>"+
    	    "                        <ns2:VENDOR_ID>"+data.getVendor_id()+"</ns2:VENDOR_ID>"+
    	    "                        <ns2:VENDOR_SITE_ID>"+data.getVendor_site_id()+"</ns2:VENDOR_SITE_ID>"+
    	    "                        <ns2:MANU_ID>"+data.getManu_id()+"</ns2:MANU_ID>"+
    	    "                        <ns2:BUDGET_NUM>"+data.getBudget_num()+"</ns2:BUDGET_NUM>"+
    	    "                        <ns2:ATTRIBUTE7>"+data.getDj()+"</ns2:ATTRIBUTE7>"+
    	    "                        <ns2:COMMENTS>"+data.getComments()+"</ns2:COMMENTS>"+
    	    
    	    "                    </ns2:LINE_TBL_ITEM>";
        }
		
        params +=line_tbl_item+
	    "                </ns2:LINE_TBL>"+
	    "            </ns2:P_HEADER_TBL_ITEM>"+
	    "        </ns2:P_HEADER_TBL>"+
	    "    </ns2:InputParameters>"+
	    "</soap:Body>"+
	" </soap:Envelope>";

		

return params;
	}
	
	
	/**
	 * 采购订单
	 * @param lists
	 * @return
	 */
	public String getApproval(List<ApprLog> lists){
		String params = ""+
		
		"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"+
	    "<soap:Header xmlns:ns1=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_po_apprhis_ret_ws/\">"+
	        "<ns1:SOAHeader>"+
	            "<ns1:Responsibility>CUX_WS_USER_RESP</ns1:Responsibility>"+
	            "<ns1:RespApplication>CUX</ns1:RespApplication>"+
	            "<ns1:SecurityGroup>STANDARD</ns1:SecurityGroup>"+
	            "<ns1:NLSLanguage>AMERICAN</ns1:NLSLanguage>"+
	            "<ns1:Org_Id>82</ns1:Org_Id>"+
	        "</ns1:SOAHeader>"+
	    "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" soap:mustUnderstand=\"1\"><wsse:UsernameToken xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:Username>OA</wsse:Username><wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">dhcdhc</wsse:Password></wsse:UsernameToken></wsse:Security></soap:Header>"+
	    "<soap:Body xmlns:ns2=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_po_apprhis_ret_ws/get_appr_history/\">"+ 
	        "<ns2:InputParameters>"+
		"<ns2:P_TBL>";
		String str = "";
		int count = 0;
		for(ApprLog log: lists){ 
			count++;
	            
	                str += "<ns2:P_TBL_ITEM>"+
	                    "<ns2:CREATED_BY/>"+
	                    "<ns2:ACTION_CODE>"+log.getAction_code()+"</ns2:ACTION_CODE>"+
	                    "<ns2:ACTION_DATE>"+log.getAction_date()+"</ns2:ACTION_DATE>"+
	                    "<ns2:EMPLOYEE_ID/>"+
	                    "<ns2:EMPLOYEE_NUMBER>"+log.getEmployee_number()+"</ns2:EMPLOYEE_NUMBER>"+
	                    "<ns2:APPROVAL_PATH_ID/>"+
	                    "<ns2:NOTE>"+log.getNote()+"</ns2:NOTE>"+
	                    "<ns2:OBJECT_REVISION_NUM>"+log.getObject_revison_num()+"</ns2:OBJECT_REVISION_NUM>"+
	                    "<ns2:OFFLINE_CODE/>"+
	                    "<ns2:LAST_UPDATE_LOGIN/>"+
	                    "<ns2:REQUEST_ID/>"+ 
	                    "<ns2:PROGRAM_APPLICATION_ID/>"+
	                    "<ns2:PROGRAM_ID/>"+
	                    "<ns2:PROGRAM_UPDATE_DATE/>"+
	                    "<ns2:PROGRAM_DATE/>"+
	                    "<ns2:OBJECT_ID/>"+ 
	                    "<ns2:PO_NUMBER>"+log.getPo_number()+"</ns2:PO_NUMBER>"+
	                    "<ns2:OBJECT_TYPE_CODE>"+log.getObject_type_code()+"</ns2:OBJECT_TYPE_CODE>"+
	                    "<ns2:OBJECT_SUB_TYPE_CODE>"+log.getObject_sub_type_code()+"</ns2:OBJECT_SUB_TYPE_CODE>"+
	                    "<ns2:SEQUENCE_NUM>"+count+"</ns2:SEQUENCE_NUM>"+
	                    "<ns2:LAST_UPDATE_DATE/>"+
	                    "<ns2:LAST_UPDATED_BY/>"+
	                    "<ns2:CREATION_DATE/>"+
	                    "<ns2:EMPLOYEE_NAME/>"+
	                    "<ns2:ACTION_CODE_DSP/>"+
	                "</ns2:P_TBL_ITEM>";
	                
		}
		params += str+        "</ns2:P_TBL>"+
	        "</ns2:InputParameters>"+
	    "</soap:Body>"+
	"</soap:Envelope>";
		

	
	return params;

	}
	
	
	/**
	 * 固资申请传入参数
	 */
	public String getBudget(List<BudgetData> list){

		
		String parsms = ""+
		"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"+
	    "<soap:Header xmlns:ns1=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_fa_budget_reserves_ws/\">"+
	        "<ns1:SOAHeader>"+
	            "<ns1:Responsibility>CUX_WS_USER_RESP</ns1:Responsibility>"+
	            "<ns1:RespApplication>CUX</ns1:RespApplication>"+
	            "<ns1:SecurityGroup>STANDARD</ns1:SecurityGroup>"+
	            "<ns1:NLSLanguage>AMERICAN</ns1:NLSLanguage>"+
	            "<ns1:Org_Id>82</ns1:Org_Id>"+
	        "</ns1:SOAHeader>"+
	    "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" soap:mustUnderstand=\"1\"><wsse:UsernameToken xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsse:Username>OA</wsse:Username><wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">dhcdhc</wsse:Password></wsse:UsernameToken></wsse:Security></soap:Header>"+
	    "<soap:Body xmlns:ns2=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_fa_budget_reserves_ws/get_budget_data/\">"+
	        "<ns2:InputParameters>"+
	            "<ns2:P_BUDGET_TBL>";
		String items = ""; 
		int count = 1; 
	            for(BudgetData data : list){
	            	items += "<ns2:P_BUDGET_TBL_ITEM>"+
	                    "<ns2:BUDGET_NUMBER>"+data.getBudget_number()+"</ns2:BUDGET_NUMBER>"+//预算编号
	                    "<ns2:STATUS_CODE>"+data.getStatus_code()+"</ns2:STATUS_CODE>"+//物资申请单状态
	                    "<ns2:RESERVE_TYPE>"+data.getReserve_type()+"</ns2:RESERVE_TYPE>"+//预算类型 --ADD 保留   RELEASE 释放
	                    "<ns2:ORDER_TYPE>PR</ns2:ORDER_TYPE>"+//固定给PO
	                    "<ns2:ORDER_NUMBER>"+data.getOrder_number()+"</ns2:ORDER_NUMBER>"+//物资申请单 单据编号
	                    "<ns2:ORDER_LINE_NUM>"+count+++"</ns2:ORDER_LINE_NUM>"+//物资申请单行号
	                    "<ns2:RESERVE_DATE>"+data.getReserve_date()+"</ns2:RESERVE_DATE>"+//预算日期
	                    "<ns2:QUANTITY>"+data.getQuantity()+"</ns2:QUANTITY>"+//数量
	                    "<ns2:UNIT_PRICE>"+data.getUnit_price()+"</ns2:UNIT_PRICE>"+//单价
	                "</ns2:P_BUDGET_TBL_ITEM>";
	            }
	            parsms += items+
	            "</ns2:P_BUDGET_TBL>"+
	        "</ns2:InputParameters>"+
	    "</soap:Body>"+
	"</soap:Envelope>";
		
		return parsms;
		
	}
	
	
	
	

}

package com.delta;

import java.io.UnsupportedEncodingException;

import org.dom4j.DocumentException;

/**
 * 返回值解析
 * @author Admin
 *
 */
public class AnalyzeParams {
	
	
	/**
	 * 解析单据编号
	 * @param inParam
	 * @return
	 */
	public DocNum  getDocNum(String inParam){
		DocNum num = new DocNum();
		XMLUtil xml;
		try {
			xml = new XMLUtil(inParam);
			num.setX_STATUS(xml.get2Property("X_STATUS"));
			num.setX_DOC_NUMBER(xml.get2Property("X_DOC_NUMBER"));
			num.setX_MESSAGE(xml.get2Property("X_MESSAGE"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
		
	
		
	}
	
	
	/**
	 * 解析布草单据编号
	 * @param inParam
	 */
	public DocNum getBillNumber(String inParam){
		DocNum num = new DocNum();
		XMLUtil xml;
		try {
			//xml = new XMLUtil(inParam);
			System.out.println(inParam);
			xml = new XMLUtil(inParam);
			num.setX_STATUS(xml.get3Property("X_RETURN_STATUS"));
			num.setX_DOC_NUMBER(xml.get3Property("BILL_NUMBER"));
			num.setX_MESSAGE(xml.get3Property("X_MSG_DATA"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
	
	
	
	/**
	 * 解析物资申请单据编号
	 * @param inParam
	 */
	public DocNum getImpNumber(String inParam){
		DocNum num = new DocNum();
		XMLUtil xml;
		try {
			xml = new XMLUtil(inParam);
			
			num.setX_STATUS(xml.get3Property("X_RETURN_STATUS"));
			num.setX_DOC_NUMBER(xml.get3Property("DOC_NUMBER"));
			num.setX_MESSAGE(xml.get3Property("X_MSG_DATA"));

			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return num;
	} 
	
	/**
	 * 解析采购订单单据编号
	 * @param inParam
	 */
	public DocNum getImpAPPLog(String inParam){
		DocNum num = new DocNum();
		XMLUtil xml;
		try {
			xml = new XMLUtil(inParam);
			
			num.setX_STATUS(xml.get3Property("PO_NUMBER"));
			num.setX_DOC_NUMBER(xml.get3Property("STATUS_CODE"));
			num.setX_MESSAGE(xml.get3Property("ERROR_MSG"));

			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return num;
	} 
	
	
	
	/**
	 * 解析采购订单单据编号
	 * @param inParam
	 */
	public DocNum getImpBudgetNum(String inParam){
		DocNum num = new DocNum();
		XMLUtil xml;
		try {
			xml = new XMLUtil(inParam);
			
			num.setX_STATUS(xml.get3Property("BUDGET_NUMBER"));
			num.setX_DOC_NUMBER(xml.get3Property("X_RETURN_STATUS"));
			num.setX_MESSAGE(xml.get3Property("X_MSG_DATA"));

			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return num;
	} 
	
	
	/*
	public static void main(String[] args) {
		
		String xml = "<?xml version=\"1.0\"?>"+
		"<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">"+
	    "<env:Header />"+
	    "<env:Body>"+
	        "<OutputParameters xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_fa_budget_reserves_ws/get_budget_data/\">"+
	            "<X_RESULT_TBL>"+
	                "<X_RESULT_TBL_ITEM>"+
	                    "<BUDGET_NUMBER>2301201500004</BUDGET_NUMBER>"+
	                    "<X_RETURN_STATUS>S</X_RETURN_STATUS>"+
	                    "<X_MSG_DATA xsi:nil=\"true\" />"+
	                "</X_RESULT_TBL_ITEM>"+
	            "</X_RESULT_TBL>"+
	        "</OutputParameters>"+
	    "</env:Body>"+
	"</env:Envelope>";
		
		AnalyzeParams ana = new AnalyzeParams();
		System.out.println(ana.getImpBudgetNum(xml).getX_DOC_NUMBER());
	}
*/
	
}

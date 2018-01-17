package com.delta;

import java.util.ArrayList;
import java.util.List;

public class WebService {

	
	private ServiceClient client = new ServiceClient();
	private InstallParams params = new InstallParams();
	private AnalyzeParams analyze = new AnalyzeParams();
	
	/**
	 * 获取文档编码
	 * 
	 * @param url
	 * @param docType
	 * @return 返回E为错误
	 */
	public  String getDocNum(String url,String docType){
		String number = "";
		Result result = ServiceClient.sendPost(url, params.getDocNumParam(docType));
		if(result.getResponseCode() == 200){
			DocNum num = analyze.getDocNum(result.getResponseRet());
			if("S".equals(num.getX_STATUS())){
				number = num.getX_DOC_NUMBER();
			}else{
				number = "E";
			}
		}else{
			number = "E";
		}
		return number;
	}
	
	public static void main(String[] args) {
		WebService ws = new WebService();
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
		ws.getDocNum("http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_apply_data_ws_pkg/?wsdl", "10001");
	}
	
	
	
	/**
	 * 布草写入
	 * @param url
	 * @param imp
	 * @param datas
	 * 返回E为错误
	 */
	public String BillNumber(String url,Linen imp,List<LinenData> datas){
		String number = "";
		Result result = client.sendPost(url, params.getOaLinen(imp,datas));
		
		if(result.getResponseCode() == 200){
			DocNum num = analyze.getBillNumber(result.getResponseRet());
			if("S".equals(num.getX_STATUS())){
				number = num.getX_DOC_NUMBER();
			}else{
				number = "E";
			}
		}else{
			number = "E";
		}
		return number;
		
	}
	

	
	
	
	/**
	 * 物料写入
	 * @param url
	 * @param imp
	 * @param datas
	 * 返回E为错误
	 */
	public String impData(String url,Imp imp,List<ImpData> datas){
		String number = "";
		Result result = client.sendPost(url, params.getOAIMP(imp, datas));
		
		if(result.getResponseCode() == 200){
			DocNum num = analyze.getImpNumber(result.getResponseRet());
			if("S".equals(num.getX_STATUS())){
				number = num.getX_DOC_NUMBER();
			}else{
				number = "E";
			}
		}else{
			number = "E";
		}
		return number;
		
	}
	
	
	
	/**
	 * 签字意见写入
	 * @param url
	 * @param imp
	 * @param datas
	 * 返回E为错误
	 */
	public String impLog(String url,List<ApprLog> datas){
		String number = "";
		Result result = client.sendPost(url, params.getApproval(datas));
		
		if(result.getResponseCode() == 200){
			DocNum num = analyze.getImpAPPLog(result.getResponseRet());
			if("S".equals(num.getX_STATUS())){
				number = num.getX_DOC_NUMBER();
			}else{
				number = "E";
			}
		}else{
			number = "E";
		}
		return number;
		
	}
	
	
	/**
	 * 固资申请写入
	 */
	public String impBudget(String url,List<BudgetData> datas){
		String number = "";
		Result result = client.sendPost(url, params.getBudget(datas));
		
		if(result.getResponseCode() == 200){
			DocNum num = analyze.getImpBudgetNum(result.getResponseRet());
			if("S".equals(num.getX_STATUS())){
				number = num.getX_DOC_NUMBER();
			}else{
				number = "E";
			}
		}else{
			number = "E";
		}
		return number;
	}
	
	/*
	public static void main(String[] args) {
		
		String url = "http://192.168.7.95:8001/webservices/SOAProvider/plsql/cux_inv_oa_apply_imp_ws/";
		Imp imp = new  Imp();
		imp.setOrganization_id("102");
		imp.setUrgent_level("PLAN");
		imp.setDoc_type_id("10031");
		imp.setDoc_number("DIS00002");
		imp.setApply_employee_number("WS0001");
		imp.setApply_organization_id("0");
		imp.setApply_date("2015-05-21");
		imp.setSub_inventory_from("CL11001");
		imp.setSub_inventory_to("HV22019");
		imp.setApproval_date("2015-05-21");
		imp.setApproval_employee_number("WS0001");
		
		ImpData data = new ImpData();
		
		data.setComments("11");
		data.setItem_number("9002");
		data.setLine_number(Integer.valueOf(1).toString());
		data.setNeed_date("2015-05-25");
		data.setOrganization_id("102");
		data.setQuantity("10");
		data.setSub_inventory_from("CL11001");
		data.setSub_inventory_to("HV22019");
		data.setUom("aa");
		List<ImpData> datas = new ArrayList<ImpData>();
		datas.add(data);
		
		
		WebService service = new WebService();
		String ret = service.impData(url, imp, datas);
		System.out.println(ret);
	}
	*/
	
	
	
	

	
	
	
}

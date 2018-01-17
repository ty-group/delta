package com.delta.ep;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import weaver.conn.RecordSet;
import weaver.general.Util;
import weaver.hrm.webservice.JobTitleBean;

import com.delta.Result;
import com.delta.ServiceClient;

public class TestAction {
	
	private ServiceClient client = new ServiceClient();
	private String URL = "http://192.168.7.116:8000/PSIGW/PeopleSoftServiceListeningConnector/PSFT_HR";
	/**
	 * 人员基本信息
	 * @param system_id
	 * @param password
	 * @param bgn_dt
	 * @param end_dt
	 */
	public List<UserInfo> sysResourceBase(String system_id,String password, String bgn_dt,String end_dt){
		String inParams = ""+
		"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hps=\"http://xmlns.oracle.com/Enterprise/Tools/schemas/HPSServiceDocs.HPSIncDataRequest.V1\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<hps:HPSIncDataRequest>"+

		         "<hps:SYSTEM_ID>OA</hps:SYSTEM_ID>"+
	
		         "<hps:PASSWORD>OA</hps:PASSWORD>"+
		     
		         "<hps:DATA_TYPE></hps:DATA_TYPE>"+
		      
		         "<hps:BGN_DT>"+bgn_dt+"</hps:BGN_DT>"+
		       
		         "<hps:END_DT>"+end_dt+"</hps:END_DT>"+
		      "</hps:HPSIncDataRequest>"+
		   "</soapenv:Body>"+ 
		"</soapenv:Envelope>";
		Result res =  client.sendPostEPS(URL, inParams, "HPSPERSINCDATASERVICE.v1");
		if(res.getResponseCode() == 200){//调用成功
			AnalyzeParams ayz = new AnalyzeParams();
			List<UserInfo> list = ayz.ayzResourceBase(res.getResponseRet());
			return list;

		}else{ 
			return null;
		}
		
	}
	


	
	
	
	
	/**
	 * 合同信息
	 * @param system_id
	 * @param password
	 * @param bgn_dt
	 * @param end_dt
	 */
	public HashMap<String, Contract> sysResourceContract(String system_id,String password, String bgn_dt,String end_dt){
		String inParams = ""+
		"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hps=\"http://xmlns.oracle.com/Enterprise/Tools/schemas/HPSServiceDocs.HPSIncDataRequest.V1\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<hps:HPSIncDataRequest>"+

		       "<hps:SYSTEM_ID>"+system_id+"</hps:SYSTEM_ID>"+
		   	
		         "<hps:PASSWORD>"+password+"</hps:PASSWORD>"+
		     
		         "<hps:DATA_TYPE></hps:DATA_TYPE>"+ 
		      
		         "<hps:BGN_DT>"+bgn_dt+"</hps:BGN_DT>"+ 
		       
		         "<hps:END_DT>"+end_dt+"</hps:END_DT>"+
		      "</hps:HPSIncDataRequest>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
		Result res =  client.sendPostEPS(URL, inParams, "HPSCNTRINCDATASERVICE.v1");
		if(res.getResponseCode() == 200){//调用成功
			AnalyzeParams ayz = new AnalyzeParams();
			HashMap<String, Contract> list = ayz.ayzResourceContract(res.getResponseRet());
			return list;
		}else{ 
			return null;
		}
		
	}
	
	/**
	 * 任职信息
	 * @param system_id
	 * @param password
	 * @param bgn_dt
	 * @param end_dt
	 */
	public HashMap<String, UserInfo> sysResourceOffice(String system_id,String password, String bgn_dt,String end_dt){
		String inParams = ""+
		"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hps=\"http://xmlns.oracle.com/Enterprise/Tools/schemas/HPSServiceDocs.HPSIncDataRequest.V1\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<hps:HPSIncDataRequest>"+

		       "<hps:SYSTEM_ID>"+system_id+"</hps:SYSTEM_ID>"+
		   	
		         "<hps:PASSWORD>"+password+"</hps:PASSWORD>"+
		     
		         "<hps:DATA_TYPE></hps:DATA_TYPE>"+ 
		      
		         "<hps:BGN_DT>"+bgn_dt+"</hps:BGN_DT>"+
		       
		         "<hps:END_DT>"+end_dt+"</hps:END_DT>"+
		      "</hps:HPSIncDataRequest>"+
		   "</soapenv:Body>"+ 
		"</soapenv:Envelope>";
		Result res =  client.sendPostEPS(URL, inParams, "HPSJOBINCDATASERVICE.v1");
		if(res.getResponseCode() == 200){//调用成功
			AnalyzeParams ayz = new AnalyzeParams();
			HashMap<String, UserInfo> maps_office = ayz.ayzResourceOffice(res.getResponseRet());
		
			return maps_office;
		}else{ 
			return null;
		}
		
	}
	
	
	/**
	 * EP 职务  对应  OA 岗位
	 * @param system_id
	 * @param password
	 * @param bgn_dt
	 * @param end_dt
	 */
	public void sysDuties(String system_id,String password, String bgn_dt,String end_dt){
		String inParams = ""+
		"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hps=\"http://xmlns.oracle.com/Enterprise/Tools/schemas//HPSServiceDocs.HPSIncDataRequest.V1\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<hps:HPSIncDataRequest>"+

		         "<hps:SYSTEM_ID>"+system_id+"</hps:SYSTEM_ID>"+
	
		         "<hps:PASSWORD>"+password+"</hps:PASSWORD>"+
		     
		         "<hps:DATA_TYPE></hps:DATA_TYPE>"+ 
		      
		         "<hps:BGN_DT>"+bgn_dt+"</hps:BGN_DT>"+
		       
		         "<hps:END_DT>"+end_dt+"</hps:END_DT>"+
		      "</hps:HPSIncDataRequest>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
		Result res =  client.sendPostEPS(URL, inParams, "HPSJCODEINCDATASERVICE.v1");
		if(res.getResponseCode() == 200){//调用成功
			// char separator = Util.getSeparator() ;
			AnalyzeParams ayz = new AnalyzeParams(); 
			List<JobTitleBean> list = ayz.ayzDuties(res.getResponseRet());
			//RecordSet rs = new RecordSet();
			for(JobTitleBean job:list){
				//System.out.println(org.getShortname());
				if("A".equals(job.getAction())){
					//String dep_sql = "select * from hrmdepartment t where t.canceled <> 1 or t.canceled is null ";
					//rs.executeSql(dep_sql);
					String jobCode = job.get_code();
					System.out.println(jobCode);
					if("1120".equals(jobCode)){
						System.out.print(jobCode);
					//while(rs.next()){
						JobTitleBean jobNew = new JobTitleBean();
						jobNew = job; 

						//jobNew.set_departmentid(rs.getString("departmentcode"));
						//jobNew.s
						//jobNew.set_code(jobCode+"_"+rs.getString("id"));
						//this.oaService.addJobTitle(IP, jobNew);
					//}  
					 
					}
					
				}else if("I".equals(job.getAction())){//删除
					//String  sql = "delete  hrmjobtitles h where h.jobtitlecode like '"+job.get_code()+"_%'";
					//rs.executeSql(sql);
				}
				
			}

		}else{ 
			//this.oaService.writeLog("获取职务信息异常!!!!!!!!!!");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		TestAction action = new TestAction();
		//action.sysDuties("OA","OA","2014-01-01","2015-11-04"); 
		/*List<UserInfo> list = action.sysResourceBase("OA","OA","2014-01-01","2015-11-02"); 
		//for(UserInfo u: list){
			//System.out.println(u.getWorkcode()+"===="+u.getLastname());
		//}*/
		
		HashMap<String, UserInfo> mapO = action.sysResourceOffice("OA","OA","2014-01-01","2015-11-05"); 
		Set<String> keyC = mapO.keySet();

		for (Iterator it = keyC.iterator(); it.hasNext();) {
			String s = (String) it.next();
			//System.out.println(s);
			UserInfo u = mapO.get(s);
			if("100387".equals(u.getWorkcode())){
			System.out.println(u.getJobactivityid());
			System.out.println(u.getWorkcode());
			System.out.println(u.getManagerid());
			}
		}
		

//		HashMap<String, Contract> mapC = action.sysResourceContract("OA","OA","2014-01-01","2015-12-02");
//		Set<String> keyC = mapC.keySet();
//		//RecordSet rsC = new RecordSet();
//		for (Iterator it = keyC.iterator(); it.hasNext();) {
//			String s = (String) it.next();
//			System.out.println(s);
//			Contract u = mapC.get(s);
//			System.out.println(u.getContract_num());
//		}
		
		
		
	}
}

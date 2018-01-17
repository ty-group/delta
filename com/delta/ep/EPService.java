package com.delta.ep;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import weaver.hrm.resource.ResourceComInfo;
import weaver.hrm.webservice.HrmServiceAction;
import weaver.hrm.webservice.JobTitleBean;
import weaver.hrm.webservice.OrgXmlBean;
import weaver.join.hrm.in.HrmResourceVo;
import weaver.join.hrm.in.IHrmImportProcess;
import weaver.join.hrm.in.ImportLog;

import com.delta.Result;
import com.delta.ServiceClient;

import weaver.conn.RecordSet;
import weaver.file.LogMan;
import weaver.general.Util; 

/**
 * 组织同步Service客户端
 * @author Admin
 *
 */
public class EPService {
 
	
	private ServiceClient client = new ServiceClient();
	private HrmServiceAction oaService = new HrmServiceAction();
	private String IP = oaService.getPropValue("HrmWebserviceIP", "ipaddress");
	private String URL = oaService.getPropValue("HrmWebserviceIP", "epswsurl");
	//private String URL = "http://192.168.7.96:8000/PSIGW/PeopleSoftServiceListeningConnector/PSFT_HR";
	 
	/**
	 * 同步分部信息
	 */
	public boolean sysSup(String system_id,String password, String bgn_dt,String end_dt){
		boolean isOK = false;
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
		
		Result res =  client.sendPostEPS(URL, inParams, "HPSCOMPINCDATASERVICE.v1");
		if(res.getResponseCode() == 200){//调用成功
			AnalyzeParams ayz = new AnalyzeParams();
			List<OrgXmlBean> list = ayz.ayzCompay(res.getResponseRet());
			for(OrgXmlBean org:list){
				org.setParent_code("0");
				if("A".equals(org.getAction())){//有效编辑或新增
					this.oaService.addSubCompany(IP, org);
				}else if("I".equals(org.getAction())){//无效封存
					org.setCanceled("1");
					this.oaService.delSubCompany(IP, org);
				}
			}
		
			isOK = true;
		}else{ 
			isOK = false;
			this.oaService.writeLog("同步分部失败!");
		}
		
		return isOK;
		
	}
	
	
	public boolean sysDep(String system_id,String password, String bgn_dt,String end_dt){
		boolean isOK = false;
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
		
		Result res =  client.sendPostEPS(URL, inParams, "HPSDEPTINCDATASERVICE.v1");
		if(res.getResponseCode() == 200){//调用成功
			AnalyzeParams ayz = new AnalyzeParams();
			List<OrgXmlBean> list = ayz.ayzDept(res.getResponseRet());
			for(OrgXmlBean org:list){
				org.setParent_code("0");
				if("A".equals(org.getAction())){//有效编辑或新增
					this.oaService.addDepartment(IP, org);
				}else if("I".equals(org.getAction())){//无效封存
					org.setCanceled("1");
					this.oaService.delDepartment(IP, org);
				}
			}
		
			isOK = true;
		}else{ 
			isOK = false;
			this.oaService.writeLog("同步部门失败!");
		}
		
		return isOK;
		
	}
	
	
	
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

		       "<hps:SYSTEM_ID>"+system_id+"</hps:SYSTEM_ID>"+
		   	
		         "<hps:PASSWORD>"+password+"</hps:PASSWORD>"+
		     
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
	 * 岗位
	 * @param system_id
	 * @param password
	 * @param bgn_dt
	 * @param end_dt
	 */
	public void sysJobTitle(String system_id,String password, String bgn_dt,String end_dt){
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
		Result res =  client.sendPostEPS(URL, inParams, "HPSPOSNINCDATASERVICE.v1");
		if(res.getResponseCode() == 200){//调用成功
			AnalyzeParams ayz = new AnalyzeParams();
			List<JobTitleBean> list = ayz.ayzJobTitle(res.getResponseRet());
			for(JobTitleBean job:list){
				//System.out.println(org.getShortname());
				if("A".equals(job.getAction())){
					this.oaService.delJobTitle(IP, job);
				}else if("I".equals(job.getAction())){
					this.oaService.addJobTitle(IP, job);
				}
				
			}

		}else{ 
			this.oaService.writeLog("获取岗位信息异常!!!!!!!!!!");
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
			 char separator = Util.getSeparator() ;
			AnalyzeParams ayz = new AnalyzeParams(); 
			List<JobTitleBean> list = ayz.ayzDuties(res.getResponseRet());
			RecordSet rs = new RecordSet();
			for(JobTitleBean job:list){
				//System.out.println(org.getShortname());
				if("A".equals(job.getAction())){
					String dep_sql = "select * from hrmdepartment t where t.canceled <> 1 or t.canceled is null ";
					rs.executeSql(dep_sql);
					String jobCode = job.get_code();
					while(rs.next()){
						JobTitleBean jobNew = new JobTitleBean();
						jobNew = job; 

						jobNew.set_departmentid(rs.getString("departmentcode"));
						//jobNew.s
						jobNew.set_code(jobCode+"_"+rs.getString("id"));
						this.oaService.addJobTitle(IP, jobNew);
					}  
					 

					
				}else if("I".equals(job.getAction())){//删除
					String  sql = "delete  hrmjobtitles h where h.jobtitlecode like '"+job.get_code()+"_%'";
					rs.executeSql(sql);
				}
				
			}

		}else{ 
			this.oaService.writeLog("获取职务信息异常!!!!!!!!!!");
		}
		
	}
	
	
	public void sysHrmresource(String system_id,String password, String bgn_dt,String end_dt){
		List<UserInfo> list = this.sysResourceBase(system_id, password, bgn_dt, end_dt);
		HashMap<String, Contract> mapC = this.sysResourceContract(system_id, password, bgn_dt, end_dt);
		HashMap<String, UserInfo> mapO = this.sysResourceOffice(system_id, password, bgn_dt, end_dt);
		
		//List<UserInfo> listNew = new ArrayList<UserInfo>();
		RecordSet rs = new RecordSet();
		RecordSet rs1 = new RecordSet();
		RecordSet rs3 = new RecordSet();
		LogMan lmdept = LogMan.getInstance();
		String sql = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateTime = sdf.format(new Date());
		char separator = Util.getSeparator();
		Calendar todaycal = Calendar.getInstance();
		String today = Util.add0(todaycal.get(Calendar.YEAR), 4) + "-"
				+ Util.add0(todaycal.get(Calendar.MONTH) + 1, 2) + "-"
				+ Util.add0(todaycal.get(Calendar.DAY_OF_MONTH), 2);
		String userpara = "" + 1 + separator + today;

		if(!(list == null)){
		//基本信息 
		for(UserInfo user:list){
			
			sql = "select * from hrmresource where workcode = '"+user.getWorkcode()+"'";
			rs.executeSql(sql);
			rs.next();
			String workcode = Util.null2String(rs.getString("workcode"));
			String lastname = Util.null2String(user.getLastname());
			lastname = lastname.replace("'", "");
			lastname = lastname.replace(",","");
			if(workcode.equals(user.getWorkcode())){//存在则更新
				String updateSQL = " update hrmresource set "    
					
					//+ " loginid = '"+ Util.null2String(user.getLoginid()) + "', "					
					+ " lastname = '"+ lastname + "', "				
					+ " sex = '" + Util.null2String(user.getSex())+ "', "
					+ " mobile = '" + Util.null2String(user.getMobile())+ "', "		 			
					+ " email = '"+ Util.null2String(user.getEmail()) + "', "
					+ " birthday = '"+ Util.null2String(user.getBirthday()) + "', "
					+ " nationality = '"+ Util.null2String(user.getNativeplace()) + "', "
					+ " certificatenum = '"+ Util.null2String(user.getCertificatenum()) + "', "
					//+ " maritalstatus = '"+ Util.null2String(rs.getString("email")) + "', "//婚姻状况需转换
					+ " numberfield1 = '"+ Util.null2String(user.getEp_rating()) + "'"//上年度绩效
					//+ " textfield5 = '"+ Util.null2String(user.getHr_bp()) + "'"//HPS_HR_BP  

					+ " where workcode = '"+ Util.null2String(user.getWorkcode()) + "'";
				
			RecordSet rsUpdate = new RecordSet();
			//lmdept.writeLog(updateSQL);  
			boolean isok8 = rsUpdate.executeSql(updateSQL);
			if(!isok8){lmdept.writeLog("更新人员基本信息 异常：执行语句：====" + updateSQL);};
				
			}else{//不存在则新增  
				  
				rs3.executeProc("HrmResourceMaxId_Get", "");
				rs3.next(); 
				int maxid = rs3.getInt(1);
				//UserInfo userC =  mapC.get(user.getWorkcode());
				//UserInfo userO =  mapO.get(user.getWorkcode());
				
				String insertSQL = "insert into hrmresource(id,workcode,loginid,password,lastname,sex,"
					+ "mobile,email,status," +
							"createdate,systemlanguage,numberfield1,birthday,nationality,certificatenum) " +
							"values ('"+maxid+"','"+user.getWorkcode()+"','"+user.getWorkcode()+"','B43E691700A8A4F5C1E903B6BC29A60A','"+lastname+"'," +
									"'"+user.getSex()+"','"+user.getMobile()+"','"+user.getEmail()+"'," +
									"'1','"+dateTime+"','7'," +
											"'"+user.getEp_rating()+"','"+user.getBirthday()+"','"+trimNull(user.getNativeplace())+"','"+trimNull(user.getCertificatenum())+"')";
				
				  
				
				RecordSet rsInsert = new RecordSet();
				boolean isok9 = rsInsert.executeSql(insertSQL);
				if(!isok9){lmdept.writeLog("新增入员 异常：执行语句：====" + insertSQL);};
				// System.out.println(insertSQL);

				String p_para = "" + maxid + separator + this.getDid(user.getDepartmentid()) + separator
						+ "1" + separator + -1 + separator + "10" + separator + ""
						+ separator + "0" + separator + "0" + separator + "0"
						+ separator + "0" + separator + "0" + separator + "0";
				boolean isoks = rs1.executeProc("HrmResourceShare", p_para);
				boolean isoks2 = rs1.executeProc("HrmResource_CreateInfo", ""
						+ maxid + separator + userpara + separator + userpara);

				String para = "" + maxid + separator + "-1" + separator
						+ this.getDid(user.getDepartmentid()) + separator + "1" + separator + "10"
						+ separator + "";
				boolean isoks3 = rs1
						.executeProc("HrmResource_Trigger_Insert", para);
				System.out.println("yanglin ok1 = " + isoks + "ok2 = " + isoks2
						+ "isok3=" + isoks3);
				String sql_1 = "insert into HrmInfoStatus (itemid,hrmid,status) values(1,"
						+ maxid + ",1)";
				rs1.executeSql(sql_1);
				String sql_2 = "insert into HrmInfoStatus (itemid,hrmid) values (2,"
						+ maxid + ")";
				rs1.executeSql(sql_2);
				String sql_3 = "insert into HrmInfoStatus (itemid,hrmid) values (3,"
						+ maxid + ")";
				rs1.executeSql(sql_3);
				String sql_10 = "insert into HrmInfoStatus (itemid,hrmid) values(10,"
						+ maxid + ")";
				rs1.executeSql(sql_10);
			} 
			
			

		//	listNew.add(user);
			

			//if(user)
		}  
		}
		
		if(mapO != null){ 
		 
		/**
		 * 任职信息更新
		 */ 
		Set<String> keyO = mapO.keySet();
		for (Iterator it = keyO.iterator(); it.hasNext();) {
			String s = (String) it.next();
			UserInfo u = mapO.get(s); 

			String uSql = "update hrmresource set ";
			if("5".equals(u.getStatus())){
				uSql = uSql +" textfield5='"+u.getEnddate()+" ' ,";
			}
			uSql = uSql +" departmentid = '"+this.getDid(u.getDepartmentid())+"',subcompanyid1 = '"+this.getSid(u.getSubcompanyid1())+"'" +
					",jobtitle = '"+getJobid(u.getJobactivityid(),this.getDid(u.getDepartmentid()))+"',managerid = '"+this.getUid(u.getManagerid())+"',textfield4 = '"+u.getCost_center_can()+"',numberfield2 = '"+u.getHr_bp()+"' where workcode = '"+u.getWorkcode()+"'";
			boolean isok9 = rs.executeSql(uSql);
			if(!isok9){lmdept.writeLog("跟新任职信息异常：执行语句：====" + uSql);};
		}
		
		}
		
		try{
			
		
		/**
		 * 合同信息更新
		 */
		
		Set<String> keyC = mapC.keySet();
		RecordSet rsC = new RecordSet();
		for (Iterator it = keyC.iterator(); it.hasNext();) {
			String s = (String) it.next();
			Contract u = mapC.get(s);
			
			
			String cSql = "select * from formtable_main_21 where htbh = '"+u.getContract_num()+"'";
			rsC.executeSql(cSql);
			String isHave = "";
			if(rsC.next()){
				isHave = Util.null2String(rsC.getString("htbh"));
			}
				if("".equals(isHave)){//新增
					cSql = "insert into formtable_main_21(htbh,htksrq,htjsrq,htyjjsrq,htlx,rybh,zhxgrq) values('"+u.getContract_num()+"','"+u.getContract_begin_dt()+"'" +
							",'"+u.getContract_end_dt()+"','"+u.getContrct_exp_end_dt()+"','"+u.getContract_type_desc()+"','"+u.getEmplid()+"','"+u.getLastupddttm()+"')";
					boolean isok9 = rsC.executeSql(cSql);
					rsC.writeLog(cSql);
					if(!isok9){lmdept.writeLog("新增合同信息异常：执行语句：====" + cSql);};
				}else{//更新
					
					cSql = "update formtable_main_21 set " +
							"htbh = '"+u.getContract_num()+"'," +
							"htksrq = '"+u.getContract_begin_dt()+"'" +
							",htjsrq = '"+u.getContract_end_dt()+"'," +
							"htyjjsrq = '"+u.getContrct_exp_end_dt()+"'," +
							"htlx = '"+u.getContract_type_desc()+"'," +
							"rybh = '"+u.getEmplid()+"'," +
							"zhxgrq = '"+u.getLastupddttm()+"' where htbh = '"+u.getContract_num()+"'";
					
					rsC.writeLog(cSql);
						boolean isok9 = rsC.executeSql(cSql);
			if(!isok9){lmdept.writeLog("更新合同信息异常：执行语句：====" + cSql);};
				}
				
			
			
			
			
			
		}
		
		}catch(Exception ex){
			rs.writeLog("合同同步异常");
		}


		

		try { 
			ResourceComInfo rci = new ResourceComInfo();
			rci.removeResourceCache();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public String trimNull(Object o) {
		if (o != null)
			return ((String) o);

		return ""; 
	}
	public String GettrimNull(Object o) {
		if (o != null)
			return ((String) o);

		return null;
	}
	
	
	private String getUid(String workcode){
		RecordSet rs = new RecordSet();
		if("".equals(workcode)) return "";
		rs.executeSql("select * from hrmresource where workcode = '"+workcode+"'");
		if(rs.next()){
			return rs.getString("id");
		}
		return "";
	}
	
	private String getJobid(String jobCode,String depid){
		RecordSet rs = new RecordSet();
		if("".equals(jobCode)) return "";
		rs.executeSql("select * from hrmjobtitles where jobtitlecode = '"+jobCode+"_"+depid+"'");
		if(rs.next()){
			return rs.getString("id");
		}
		return "";
	}
	
	private String getDid(String deptcode){
		RecordSet rs = new RecordSet();
		if("".equals(deptcode)) return "";
		rs.executeSql("select * from hrmdepartment where departmentcode = '"+deptcode+"'");
		if(rs.next()){
			return rs.getString("id");
		}
		return "";
	}
	
	private String getSid(String scode){
		RecordSet rs = new RecordSet();
		if("".equals(scode)) return "";
		rs.executeSql("select * from hrmsubcompany where subcompanycode = '"+scode+"'");
		if(rs.next()){
			return rs.getString("id");
		}
		return "";
	}
	
	
	
	
	

	
	
	

}

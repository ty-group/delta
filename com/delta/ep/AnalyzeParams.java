package com.delta.ep;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;


import weaver.hrm.webservice.JobTitleBean;
import weaver.hrm.webservice.OrgXmlBean;

import com.delta.XMLUtil;

public class AnalyzeParams {

	
	/**
	 * 解析分部
	 * @param inParam
	 * @return
	 */ 
	public List<OrgXmlBean> ayzCompay(String inParam){
		XMLUtil xml;
		List<OrgXmlBean> orgs = new ArrayList<OrgXmlBean>();
		try {
			xml = new XMLUtil(inParam); 
			
			List list = xml.get4Property();
			for(int i=0; i < list.size(); i++){
				Element temp = (Element)list.get(i);
				temp = (Element)temp.elements().get(0);
				OrgXmlBean org = new OrgXmlBean();
				org.setCode(temp.elementText("COMPANY"));
				org.setShortname(temp.elementText("DESCR"));
				org.setFullname(temp.elementText("DESCR"));
				org.setAction(temp.elementText("EFF_STATUS"));
				orgs.add(org);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			orgs = null;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			orgs = null;
		}
		
		return orgs;
	}
	
	
	
	/**
	 * 解析部门
	 * @param inParam
	 * @return
	 */
	public List<OrgXmlBean> ayzDept(String inParam){
		XMLUtil xml;
		List<OrgXmlBean> orgs = new ArrayList<OrgXmlBean>();
		try {
			xml = new XMLUtil(inParam);
			
			List list = xml.get4Property(); 
			for(int i=0; i < list.size(); i++){
				Element temp = (Element)list.get(i);
				temp = (Element)temp.elements().get(0);
				OrgXmlBean org = new OrgXmlBean();
				org.setCode(temp.elementText("DEPTID"));
				org.setShortname(temp.elementText("DESCR"));
				org.setFullname(temp.elementText("DESCR"));
				org.setAction(temp.elementText("EFF_STATUS"));
				org.setOrg_code(temp.elementText("COMPANY"));
				org.setParent_code(temp.elementText("PARENT_NODE_NAME"));
				orgs.add(org);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			orgs = null;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			orgs = null;
		}
		
		return orgs;
	}
	
	
	
	/**
	 * 解析人员
	 * @param inParam
	 * @return
	 */
	public List<UserInfo> ayzResourceBase(String inParam){
		XMLUtil xml;
		
		
		List<UserInfo> users = new ArrayList<UserInfo>();
		try {
			xml = new XMLUtil(inParam); 
			
			List list = xml.get4Property();   
			for(int i=0; i < list.size(); i++){
				Element temp = (Element)list.get(i);
				temp = (Element)temp.elements().get(0);
				UserInfo userInfo = new UserInfo();
				userInfo.setWorkcode(temp.elementText("EMPLID"));
				userInfo.setLastname(temp.elementText("NAME_DISPLAY"));
				String sex = "";
				if("F".equals(temp.elementText("SEX"))){//女
					sex = "1";
				}else if("M".equals(temp.elementText("SEX"))){//男
					sex = "0";
				}
				userInfo.setSex(sex);
				userInfo.setMobile(temp.elementText("PHONE1"));
				userInfo.setEmail(temp.elementText("EMAIL_ADDR"));
				userInfo.setBirthday(temp.elementText("BIRTHDATE"));
				userInfo.setPassword("1");
				userInfo.setCertificatenum(temp.elementText("NATIONAL_ID"));
				//userInfo.setJobactivitydesc(jobactivitydesc)
				//userInfo.setManagerid(temp.elementText(""));
				//userInfo.setStatus(temp.elementText(""));
				//userInfo.setLocationid(temp.elementText(""));
				//userInfo.setMobilecall(temp.elementText(""));
				userInfo.setMaritalstatus(temp.elementText("MAR_STATUS_DESC"));
				userInfo.setEducationlevel(temp.elementText("HIGHEST_EDULV_DESR"));
				//userInfo.setCreatedate(temp.elementText(""));
				//userInfo.setEnddate(temp.elementText(""));
				userInfo.setEp_rating(temp.elementText("EP_RATING"));
				userInfo.setLoginid(temp.elementText("HPS_LOGIN_ID"));
				users.add(userInfo);
				
				

			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			users = null;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			users = null;
		}
		
		return users;
	}
	
	
	/**
	 * 解析人员任职
	 * @param inParam
	 * @return
	 */
	public HashMap<String, UserInfo> ayzResourceOffice(String inParam){
		XMLUtil xml;
		
		HashMap<String, UserInfo> users = new HashMap<String, UserInfo>();
		
		//List<UserInfo> users = new ArrayList<UserInfo>();
		try {
			xml = new XMLUtil(inParam); 
			
			List list = xml.get4Property();
			for(int i=0; i < list.size(); i++){
				Element temp = (Element)list.get(i);
				temp = (Element)temp.elements().get(0);
				UserInfo userInfo = new UserInfo();
				String workCode = temp.elementText("EMPLID");
				userInfo.setWorkcode(workCode);
				userInfo.setSubcompanyid1(temp.elementText("COMPANY"));
				userInfo.setJobactivityid(temp.elementText("JOBCODE"));
				//userInfo.setJobactivitydesc();
				userInfo.setManagerid(temp.elementText("SUPERVISOR_ID"));
				String status = "1";
				if("A".equals(temp.elementText("HR_STATUS"))){
					status = "1";
				}else{
					status = "5";
				} 
				userInfo.setStatus(status);
				userInfo.setEnddate(temp.elementText("EFFDT"));//合同结束日期做离职日期
				userInfo.setLocationid(temp.elementText("LOCATION_DESCR"));
				userInfo.setDepartmentid(temp.elementText("DEPTID"));   
				userInfo.setCost_center_can(temp.elementText("COST_CENTER_CAN"));
				userInfo.setHr_bp(temp.elementText("HPS_HR_BP"));
				users.put(workCode, userInfo);
				
				

			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			users = null;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			users = null;
		}
		
		return users;
	}
	
	
	/**
	 * 解析人员合同
	 * @param inParam
	 * @return
	 */
	public HashMap<String, Contract> ayzResourceContract(String inParam){
		XMLUtil xml;
		
		HashMap<String, Contract> users = new HashMap<String, Contract>();
		
		//List<UserInfo> users = new ArrayList<UserInfo>();
		try {
			xml = new XMLUtil(inParam);
			
			List list = xml.get4Property();
			for(int i=0; i < list.size(); i++){
				Element temp = (Element)list.get(i);
				temp = (Element)temp.elements().get(0);
				Contract contract = new Contract();
				String workCode = temp.elementText("EMPLID");
				contract.setEmplid(workCode);
				contract.setContract_begin_dt(temp.elementText("CONTRACT_BEGIN_DT"));
				contract.setContract_end_dt(temp.elementText("CONTRACT_END_DT"));
				contract.setContract_num(temp.elementText("CONTRACT_NUM"));
				contract.setContract_type_desc(temp.elementText("CONTRACT_TYPE_DESC"));
				contract.setLastupddttm(temp.elementText("LASTUPDDTTM"));
				
			
				users.put(workCode, contract);
				

			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			users = null;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			users = null;
		}
		
		return users;
	}
	
	
	
	/**
	 * 解析岗位
	 * @param inParam
	 * @return
	 */
	public List<JobTitleBean> ayzJobTitle(String inParam){
		XMLUtil xml;
		List<JobTitleBean> jobs = new ArrayList<JobTitleBean>();
		try {
			xml = new XMLUtil(inParam);
			
			List list = xml.get4Property();
			for(int i=0; i < list.size(); i++){ 
				Element temp = (Element)list.get(i);
				temp = (Element)temp.elements().get(0);
				JobTitleBean job = new JobTitleBean();
				
				//job.set_departmentid(temp.elementText(""));
				job.set_fullname(temp.elementText("HPS_ENG_DESCR"));
				job.set_shortname(temp.elementText("DESCR"));
				job.set_code(temp.elementText("POSITION_NBR"));
				job.setAction(temp.elementText("EFF_STATUS"));
				job.set_departmentid(temp.elementText("DEPTID"));
				jobs.add(job);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jobs = null;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jobs = null;
		}
		
		return jobs;
	}
	
	
	/**
	 * 解析职务
	 * @param inParam
	 * @return
	 */
	public List<JobTitleBean> ayzDuties(String inParam){
		XMLUtil xml;
		List<JobTitleBean> jobs = new ArrayList<JobTitleBean>();
		try {
			xml = new XMLUtil(inParam);
			
			List list = xml.get4Property();
			for(int i=0; i < list.size(); i++){ 
				Element temp = (Element)list.get(i);
				temp = (Element)temp.elements().get(0);
				JobTitleBean job = new JobTitleBean();
				
				//job.set_departmentid(temp.elementText(""));
				job.set_fullname(temp.elementText("HPS_ENG_DESCR"));
				job.set_shortname(temp.elementText("DESCR"));
				job.set_code(temp.elementText("JOBCODE"));
				job.setAction(temp.elementText("EFF_STATUS"));
				
				jobs.add(job);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jobs = null;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jobs = null;
		}
		
		return jobs;
	}
}

package com.delta.action;

import java.util.Properties;

import org.aurora_framework.www.schema.REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD;
import org.aurora_framework.www.schema.REQUESTHEADER;
import org.aurora_framework.www.schema.RESPONSE;
import org.aurora_framework.www.schema.SRMRemoteUtil;

import weaver.conn.RecordSet;
import weaver.file.Prop;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.interfaces.workflow.action.Action;
import weaver.interfaces.workflow.action.BaseAction;
import weaver.soa.workflow.request.RequestInfo;

/**
 * 2017-12-28 Created by Ink,tangyue Corp
 * 合同审批
 */
public class HTSP2SRMAction extends BaseAction implements Action {

	static{
		Properties properties=System.getProperties();
		properties.setProperty("http.proxyHost", "10.11.9.70");
		properties.setProperty("http.proxyPort", "3128");
	}
	
	public static String business_group = "";

	public static String system_code = "";

	public static String username = "";

	public static String password = "";
	
	public static String oaurl = "";

	static {
		business_group = Prop.getPropValue("SRMVal", "business_group");
		system_code = Prop.getPropValue("SRMVal", "system_code");
		username = Prop.getPropValue("SRMVal", "username");
		password = Prop.getPropValue("SRMVal", "password");
		oaurl=Prop.getPropValue("SRMVal", "oaurl");
	}

	public String execute(RequestInfo requestInfo) {
		try {
			new BaseBean().writeLog("s德达合同审批结果回传SRM...");
			String requestid = requestInfo.getRequestid();
			String workflowid = requestInfo.getWorkflowid();
			int formid = requestInfo.getRequestManager().getFormid();
			String tablename = "formtable_main_" + Math.abs(formid);
			RecordSet rs = new RecordSet();
			rs.execute("select * from " + tablename + " where requestid =  "
					+ requestid);
			rs.next();
			
			String htbh = Util.null2String(rs.getString("srmhtbh"));
			REQUESTHEADER header = new REQUESTHEADER();
			header.setBUSINESS_GROUP(business_group);
			header.setSYSTEM_CODE(system_code);
			header.setREQUEST_ID(requestid);
			header.setIF_CATE_CODE("PUR_CONTRACT");
			header.setIF_CODE("PUR_CONTRACT_STATUS");
			header.setUSER_NAME(username);
			header.setPASSWORD(password);
			header.setBATCH_NUM("1111");
			header.setTOTAL_SEG_COUNT("1");
			header.setSEG_NUM("1");
			new BaseBean().writeLog("\tHEAD-------------");
			new BaseBean().writeLog("\tbusiness_group="+business_group);
			new BaseBean().writeLog("\tsystem_code="+system_code);
			new BaseBean().writeLog("\tusername="+username);
			new BaseBean().writeLog("\tpassword="+password);
			new BaseBean().writeLog("\tIF_CATE_CODE=PUR_CONTRACT");
			new BaseBean().writeLog("\tIF_CODE=PUR_CONTRACT_STATUS");
			new BaseBean().writeLog("\tREQUEST_ID="+requestid);
			
			
			REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD recorder = new REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD();
			new BaseBean().writeLog("\tRECORD-------------");
			String src = requestInfo.getRequestManager().getSrc();
			if (src.equalsIgnoreCase("reject")) {
				recorder.setCON_STATUS("BACKED");
				new BaseBean().writeLog("\tCON_STATUS=BACKED");
			} else {
				recorder.setCON_STATUS("APPROVED");
				new BaseBean().writeLog("\tCON_STATUS=APPROVED");
			}
			recorder.setDOCUMENT_NUMBER(htbh);
			new BaseBean().writeLog("\tDOCUMENT_NUMBER="+htbh);
			RESPONSE response = SRMRemoteUtil.invokeSRM(header, recorder);
		} catch (Exception e) {
			new BaseBean().writeLog(e);
			requestInfo.getRequestManager().setMessage("11111111111111");
			requestInfo.getRequestManager().setMessageid("1111111111111");
			requestInfo.getRequestManager().setMessagecontent(e.getMessage());
		} finally {
			new BaseBean().writeLog("e德达合同审批结果回传SRM...");
		}
		return Action.SUCCESS;
	}
}

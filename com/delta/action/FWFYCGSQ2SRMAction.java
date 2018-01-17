package com.delta.action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import net.sf.json.JSONObject;

import weaver.conn.RecordSet;
import weaver.file.Prop;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.hrm.resource.ResourceComInfo;
import weaver.interfaces.workflow.action.Action;
import weaver.interfaces.workflow.action.BaseAction;
import weaver.soa.workflow.request.RequestInfo;

import com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORD;
import com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORDEITF_PUR_REQ_LINESRECORD;
import com.delta.cgsqwsdl.EnvelopeBodyREQUESTHEADER;
import com.delta.cgsqwsdl.Req2SRMUtil;

/**
 * 2017-12-28 Created by Ink,tangyue Corp
 * 服务费用采购申请
 */
public class FWFYCGSQ2SRMAction extends BaseAction implements Action {
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
			new BaseBean().writeLog("s德达服务费用采购申请结果回传SRM...");
			String requestid = requestInfo.getRequestid();
			String workflowid = requestInfo.getWorkflowid();
			int formid = requestInfo.getRequestManager().getFormid();
			String tablename = "formtable_main_" + Math.abs(formid);
			
			EnvelopeBodyREQUESTHEADER header = new EnvelopeBodyREQUESTHEADER();
			header.setBUSINESS_GROUP(business_group);
			header.setSYSTEM_CODE(system_code);
			header.setREQUEST_ID(requestid);
			header.setIF_CATE_CODE("PUR_PO");
			header.setIF_CODE("PUR_REQ_IMP_F_OA");
			header.setUSER_NAME(username);
			header.setPASSWORD(password);
			header.setBATCH_NUM("1111");
			header.setTOTAL_SEG_COUNT("1");
			header.setSEG_NUM("1");
			
			JSONObject headerJSON = JSONObject.fromObject(header);
			new BaseBean().writeLog("headerJSON = "+headerJSON.toString());
			
			String datestr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			RecordSet rs = new RecordSet();
			RecordSet rs1 = new RecordSet();
			rs.execute("select * from " + tablename + " where requestid =  "
					+ requestid);
			rs.next();
			EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORD record = new EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORD();
			String mainid = Util.null2String(rs.getString("ID"));
			record.setES_REQ_HEADER_ID(Util.null2String(rs.getString("ID")));//主表ID
			record.setES_REQ_NUMBER(Util.null2String(rs.getString("djbh")));//单据编号
			record.setERP_CREATION_DATE(Util.null2String(rs.getString("sqrq")));//申请日期
			record.setPROJECT_NAME(Util.null2String(rs.getString("xm")));
			
			
			String 	att=Util.null2String(rs.getString("att"));
			String fileurlString="";
			if(!"".equals(att)){
				String xgfj_array[]=att.split(",");
				for (int i=0;i<xgfj_array.length;i++){
					System.out.println(xgfj_array[i]);
					fileurlString+="<a target='_blank'   href='http://"+oaurl+"/weaver/weaver.file.FileDownload?fileid="+xgfj_array[i]+"&download=1'>附件"+(1+i)+"</a><br>";
				}
			}
			record.setREQ_ATTACHMENT(fileurlString);//附件
			rs1.execute("select lastname from hrmresource where id = "+Util.null2String(rs.getString("sqr")));
			rs1.next();
			String lastname = rs1.getString("lastname");
			record.setERP_CREATED_BY(lastname);//申请人工号			record.setERP_LAST_UPDATE_DATE(datestr);
			record.setERP_LAST_UPDATED_BY(requestInfo.getLastoperator());
			record.setERP_LAST_UPDATE_DATE(datestr);
			record.setENABLED_FLAG("Y");
			record.setDESCRIPTION(Util.null2String(rs.getString("bz")));
			String src = requestInfo.getRequestManager().getSrc();
			
			
			new BaseBean().writeLog("+++getNodeid = "+requestInfo.getRequestManager().getNodeid());
			new BaseBean().writeLog("+++getNodetype = "+requestInfo.getRequestManager().getNodetype());
			new BaseBean().writeLog("+++getNextNodeid = "+requestInfo.getRequestManager().getNextNodeid());
			new BaseBean().writeLog("+++getNextNodetype = "+requestInfo.getRequestManager().getNextNodetype());
			
			
			if (src.equalsIgnoreCase("reject")) {
				record.setAUTHORIZATION_STATUS("CANCEL");
			}else if("3".equals(requestInfo.getRequestManager().getNodetype())||"3".equals(requestInfo.getRequestManager().getNextNodetype())){
				record.setAUTHORIZATION_STATUS("APPROVED");
			}else{
				record.setAUTHORIZATION_STATUS("SUBMITTED");
			}
			record.setAPPROVED_DATE(datestr);
			record.setREQ_TYPE_NAME(Util.null2String(rs.getString("djlxtxt")));
			record.setEMERGENCY_LEVEL(Util.null2String(rs.getString("jjcd")));
			record.setAPPLICATION_DATE(Util.null2String(rs.getString("sqrq")));
			record.setES_UNIT_CODE(Util.null2String(rs.getString("lyks")));
			String kczz = Util.null2String(rs.getString("kczz"));
			
			rs.execute("select * from " + tablename + "_dt1 where mainid =  "
					+ mainid);
			int i = 1;
			List<EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORDEITF_PUR_REQ_LINESRECORD> lineList = new ArrayList<EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORDEITF_PUR_REQ_LINESRECORD>();
			while(rs.next()){
				EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORDEITF_PUR_REQ_LINESRECORD lines = new EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORDEITF_PUR_REQ_LINESRECORD();
				lines.setES_REQ_LINE_ID(Util.null2String(rs.getString("id")));
				lines.setES_REQ_HEADER_ID(mainid);
				lines.setLINE_NUM(String.valueOf(i));
				lines.setITEM_ID(Util.null2String(rs.getString("fwwlbm")));
				lines.setITEM_DESCRIPTION(Util.null2String(rs.getString("wlsm")));
				lines.setUNIT_MEAS_LOOKUP_CODE(Util.null2String(rs.getString("sqdw")));
				lines.setUNIT_PRICE(Util.null2String(rs.getString("dj")));
				lines.setQUANTITY(Util.null2String(rs.getString("sqsl")));
				lines.setERP_LAST_UPDATE_DATE(datestr);
				lines.setERP_LAST_UPDATED_BY(requestInfo.getLastoperator());
				lines.setERP_CREATION_DATE(record.getERP_CREATION_DATE());//申请日期
				lines.setERP_CREATED_BY(record.getERP_CREATED_BY());//申请人工号
				lines.setNEED_BY_DATE(Util.null2String(rs.getString("xyrq")));
				lines.setDESTINATION_ORGANIZATION_ID(kczz);
				lines.setDESTINATION_ORGANIZATION_CODE("");
				lines.setROW_STATE(record.getAUTHORIZATION_STATUS());
				lines.setLINE_COMMENTS(Util.null2String(rs.getString("bz")));
				lineList.add(lines);
				i++;
			}
			EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORDEITF_PUR_REQ_LINESRECORD[] lines = new EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORDEITF_PUR_REQ_LINESRECORD[lineList.size()];
			for (int j=0;j<lineList.size();j++) {
				lines[j]=lineList.get(j);
			}
			record.setEITF_PUR_REQ_LINES(lines);
			JSONObject recordJSON = JSONObject.fromObject(record);
			new BaseBean().writeLog("recordJSON = "+recordJSON.toString());
			Req2SRMUtil.execute(header, record);
			
		} catch (Exception e) {
			new BaseBean().writeLog(e);
			requestInfo.getRequestManager().setMessage("11111111111111");
			requestInfo.getRequestManager().setMessageid("1111111111111");
			requestInfo.getRequestManager().setMessagecontent(e.getMessage());
		} finally {
			new BaseBean().writeLog("e德达服务费用采购申请结果回传SRM...");
		}
		return Action.SUCCESS;
	}
}

package com.delta.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import com.delta.ApprLog;
import com.delta.Imp;
import com.delta.ImpData;
import com.delta.Linen;
import com.delta.LinenData;

import com.delta.WebService;
import weaver.conn.RecordSet;
import weaver.file.LogMan;
import weaver.general.BaseBean;
import weaver.general.Util;

import weaver.interfaces.workflow.action.Action;
import weaver.soa.workflow.request.Cell;
import weaver.soa.workflow.request.DetailTable;
import weaver.soa.workflow.request.Log;
import weaver.soa.workflow.request.Property;
import weaver.soa.workflow.request.RequestInfo;
import weaver.soa.workflow.request.RequestLog;
import weaver.soa.workflow.request.Row;

/**
 * 
 * 功能采购订单审批意见写入
 * 
 * 
 */
public class AppLogAction extends BaseBean implements Action {
	public String execute(RequestInfo request) {
		LogMan lmdept = LogMan.getInstance();
		String url = super.getPropValue("delta", "APPURL");

		request.getMainTableInfo();
		String requestid = Util.null2String(request.getRequestid());
		char separator = Util.getSeparator();
		Log[] logs = request.getRequestLog().getLog();
		



		List<LinenData> datas = new ArrayList();
		Linen imp = new Linen(); 

		Calendar todaycal = Calendar.getInstance();
		String today = Util.add0(todaycal.get(Calendar.YEAR), 4) + "-"
				+ Util.add0(todaycal.get(Calendar.MONTH) + 1, 2) + "-"
				+ Util.add0(todaycal.get(Calendar.DAY_OF_MONTH), 2);
		// String userpara = "" + 1 + separator + today;

		lmdept.writeLog("意见写入开始------------------------------");

		String poNumber = "";
		String object_revison_num = "";
		String sfty = "";


		// 取主表数据
		Property[] properties = request.getMainTableInfo().getProperty();// 获取表单主字段信息
		for (int i = 0; i < properties.length; i++) {

			String name = properties[i].getName();// 主字段名称
			String value = Util.null2String(properties[i].getValue());// 主字段对应的值
			// System.out.println(name + " " + value);
			if (name.equals("jdbh")) {
				poNumber = value;
			}
			if (name.equals("ddbbh")) {
				object_revison_num = value;
			}
			
			if (name.equals("sfty")) {
				sfty = value;
			} 
		} 
		 
		List<ApprLog> list = new ArrayList<ApprLog>() ;
		for(Log log : logs){ 
			ApprLog aLog = new ApprLog();
			String a = "APPROVE";
			if("0".equals(sfty)){
				a = "APPROVE";
			}else if("1".equals(sfty)){
				a = "REJECT";
			}
			aLog.setAction_code(a);
			
			
			aLog.setAction_date(log.getOpdate()+" "+log.getOptime());
			aLog.setEmployee_id("");
			aLog.setObject_revison_num(object_revison_num);
			aLog.setEmployee_number(this.getProById(log.getOperatorid(), "workcode"));
			String comment = Util.null2String(log.getComment());
			comment=StrUtil.repNbsp(comment);
			//aLog.setEmployee_number("100040");
			try { 
				
				comment = "<![CDATA["+StrUtil.subStringByByte(comment,240)+"]]>";
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			aLog.setNote(comment);
			aLog.setObject_id("");
			aLog.setPo_number(poNumber);
			aLog.setObject_sub_type_code("STANDARD");
			aLog.setObject_type_code("PO");
			list.add(aLog); 
		}     
	 


		WebService service = new WebService();
		String ret = service.impLog(url, list);   
		if ("E".equals(ret)) {
			//request.getRequestManager().setMessageid("9999999");
			//request.getRequestManager().setMessagecontent("采购订单写入异常,请通知管理员@!!!");
			lmdept.writeLog("采购订单写入失败...............................");
		} else {
			lmdept.writeLog("采购订单数据写入成功...................");
		}

		return Action.SUCCESS;
	}
	
	public String getProById(String uid,String prop){
		String sql = "select * from hrmresource where id = '"+uid+"'";
		String ret = "";
		RecordSet rs = new RecordSet();
		rs.executeSql(sql);
		if(rs.next()){
			ret = rs.getString(prop);
		}
		
		return ret;
	}
}

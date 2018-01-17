package com.delta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.apache.pdfbox.util.operator.SetWordSpacing;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.general.Util;
import weaver.hrm.User;
import weaver.hrm.resource.ResourceComInfo;
import weaver.workflow.request.RequestManager;
import weaver.workflow.workflow.WorkflowBillComInfo;
import weaver.workflow.workflow.WorkflowComInfo;

/**
 * 2017-3-15 Created by Ink,tangyue Corp
 */
public class RequestServiceInfo4Delta {

	public String workflowid;

	public String creator;

	public String requestid;

	public String isNextNode;

	public Map<String, String> mainMap = new HashMap<String, String>();

	public Map<String, List<Map<String, String>>> detailMap = new HashMap<String, List<Map<String, String>>>();

	public String getWorkflowid() {
		return workflowid;
	}

	public void setWorkflowid(String workflowid) {
		this.workflowid = workflowid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getIsNextNode() {
		return isNextNode;
	}

	public void setIsNextNode(String isNextNode) {
		this.isNextNode = isNextNode;
	}

	public Map<String, String> getMainMap() {
		return mainMap;
	}

	public void setMainMap(Map<String, String> mainMap) {
		this.mainMap = mainMap;
	}

	public Map<String, List<Map<String, String>>> getDetailMap() {
		return detailMap;
	}

	public void setDetailMap(Map<String, List<Map<String, String>>> detailMap) {
		this.detailMap = detailMap;
	}

	public String execute() {
		RecordSet rs = new RecordSet();
		RecordSet rs1 = new RecordSet();
		boolean isCreate = false;
		String creator = "";
		String sql = "select id from hrmresource where loginid = '"+getCreator()+"'";
		rs.execute(sql);
		if(rs.next()){
			creator = rs.getString("id");
		}else{
			return RequestServiceResponseUtil.getResponse("E005"+"", "创建人错误！");
		}
		if ("".equals(getRequestid())) {
			isCreate = true;
		}else{
			rs.execute("select * from workflow_requestbase where requestid = "+getRequestid());
			String _creator = "";
			String currentNodetype = "";
			if(rs.next()){
				currentNodetype = rs.getString("currentnodetype");
				_creator = rs.getString("creater");
			}
			if(!"0".equals(currentNodetype)){
				return RequestServiceResponseUtil.getResponse("E010"+"", "流程未被退回！");
			}
			if(!creator.equals(_creator)){
				return RequestServiceResponseUtil.getResponse("E005"+"", "本次创建人并非原创建人！");
			}
		}
		RequestManager requestManager = createRequest(Integer.parseInt(creator), "Y".equals(isNextNode));
		if(requestManager == null){
			return RequestServiceResponseUtil.getResponse("E10", "系统错误！请联系OA管理员!");
		}
		requestid = requestManager.getRequestid()+"";
		rs.execute("select formid from workflow_base where id = "
				+ getWorkflowid());
		if (rs.next()) {
			String billid = rs.getString("formid");
			rs.execute("select t1.id,t1.fieldname,t3.labelname,t1.fielddbtype,t1.type,t1.fieldhtmltype,t1.detailtable,t1.dsporder "
					+ " from workflow_billfield t1 "
					+ " left join HtmlLabelIndex t2 on t1.fieldlabel = t2.id "
					+ " left join HtmlLabelInfo t3 on t2.id = t3.indexid and t3.languageid=7 "
					+ " where billid = "
					+ billid
					+ " order by detailtable,dsporder");
			int i = 0;
			String mainSql = null;
			Map<String,List<String>> fieldMap = new HashMap<String,List<String>>();
			List<String> mainValueList = new ArrayList<String>();
			while (rs.next()) {
				String detailtable = Util.null2String(rs
						.getString("detailtable"));
				String fieldname = Util.null2String(rs.getString("fieldname"));
				String labelname = Util.null2String(rs.getString("labelname"));
				String fielddbtype = Util.null2String(rs
						.getString("fielddbtype"));
				String type = Util.null2String(rs.getString("type"));
				String fieldhtmltype = Util.null2String(rs
						.getString("fieldhtmltype"));
				String fieldid = Util.null2String(rs.getString("id"));
				
				//主表直接拼SQL
				if ("".equals(detailtable)) {
					if (mainMap.get(fieldname.toUpperCase()) != null) {
						String value = mainMap.get(fieldname.toUpperCase());
						if("3".equals(fieldhtmltype)&&"1".equals(type)){//人力资源
							rs1.execute("select id from hrmresource where workcode = '"+value+"'");
							rs1.next();
							value = rs1.getString("id");
						}
						if("3".equals(fieldhtmltype)&&"4".equals(type)){//部门
							rs1.execute("select id from hrmdepartment where departmentname = '"+value+"'");
							rs1.next();
							value = rs1.getString("id");
						}
						if("3".equals(fieldhtmltype)&&("164".equals(type)||"194".equals(type))){//分部
							rs1.execute("select id from hrmsubcompany where subcompanyname = '"+value+"'");
							rs1.next();
							value = rs1.getString("id");
						}
						if (null == mainSql) {
							mainSql = "update formtable_main_"
									+ billid.replaceAll("-", "") + " set "
									+ fieldname + "='"+value+"'";
						}else{
							mainSql += ","+fieldname+"='"+value+"'";
						}
					}
					
				}else{
				//组装明细表字段
					String index = detailtable.replaceAll("formtable_main_"+billid.replaceAll("-", "")+"_dt","");
					List<String> fieldList = fieldMap.get(index);
					if(null==fieldList){
						fieldList = new ArrayList<String>();
						fieldMap.put(index, fieldList);
					}
					fieldList.add(fieldname);
				}
			}
			mainSql += " where requestid  = "+requestid;
			new BaseBean().writeLog("mainSql = "+mainSql);
			new BaseBean().writeLog("&&&&&&&&&&&&&&&&&&&&&&&&&&&fieldMap = "+fieldMap);
			rs.execute(mainSql);
			rs.execute("select * from formtable_main_"
									+ billid.replaceAll("-", "")+" where requestid = "+requestid);
			rs.next();
			String mainid = rs.getString("id");
			Set<String> keySet = detailMap.keySet();
			new BaseBean().writeLog("detailMap = "+detailMap);
			for (String string : keySet) {
				List<Map<String,String>> recordMapList = detailMap.get(string);
				rs.execute("delete from formtable_main_"
								+ billid.replaceAll("-", "")+"_dt"+string+" where mainid = "+mainid);
				for (Map<String, String> map : recordMapList) {
					String insertSqlfield = "insert into formtable_main_"
							+ billid.replaceAll("-", "")+"_dt"+string+"(mainid";
					String insertSqlvalue = " values ("+mainid+"";
					List<String> fieldList = fieldMap.get(string);
					List<String> valueList = new ArrayList<String>();
					new BaseBean().writeLog("fieldList = "+fieldList);
					if(fieldList == null){
						continue;
					}
					for (String fieldname : fieldList) {
						if(map.get(fieldname.toUpperCase())!=null){
							insertSqlfield += ","+fieldname;
							insertSqlvalue += ",'"+map.get(fieldname.toUpperCase())+"'";
//							valueList.add(map.get(fieldname.toUpperCase()));
						}
					}
					String insertSql = insertSqlfield+")"+insertSqlvalue+")";
					new BaseBean().writeLog("insertSql = "+insertSql);
					rs.execute(insertSql);
				}
			}
		}
		if("Y".equals(isNextNode)){
			requestManager.flowNextNode();
		}
		return RequestServiceResponseUtil.getResponse(requestid+"", "");
	}

	protected RequestManager createRequest(int userid, boolean isNextNode) {
		WorkflowComInfo workflowComInfo = null;
		WorkflowBillComInfo WorkflowBillComInfo = null;
		ResourceComInfo resourceComInfo = null;
		try {
			workflowComInfo = new WorkflowComInfo();
			WorkflowBillComInfo = new WorkflowBillComInfo();
			resourceComInfo = new ResourceComInfo();
		} catch (Exception e) {
			return null;
		}
		RequestManager RequestManager = new RequestManager();
		RecordSet rs = new RecordSet();
		int nodeid = 0;
		int requestId = 0;
		String requestName = "";
		/*rs.execute("select activeVersionID from workflow_base where id = "
				+ getWorkflowid());
		if (rs.next()) {
			String activeVersionID = Util.null2String(rs.getString("activeVersionID"));
			if(!"".equals(activeVersionID)){
				setWorkflowid(activeVersionID);
			}
		}*/
		String workflowname = workflowComInfo.getWorkflowname(getWorkflowid());
		String workflowtype = workflowComInfo.getWorkflowtype(getWorkflowid()); // 工作流种类
		String lastname = resourceComInfo.getLastname(String.valueOf(userid));
		int formid = Util.getIntValue(
				workflowComInfo.getFormId(getWorkflowid()), 0);
		int isbill = Util.getIntValue(
				workflowComInfo.getIsBill(getWorkflowid()), 0);
		rs.executeProc("workflow_CreateNode_Select", "" + getWorkflowid());
		if (rs.next()) {
			nodeid = Util.getIntValue(rs.getString(1), 0);
		}
		int IsagentCreater = 0;
		User user = new User();
		user.setUid(userid);
		user.setLanguage(Util.getIntValue("7"));
		user.setLogintype("1");
		requestName = workflowname + "-" + lastname + "-" + getCurrentDate();
		RequestManager.setSrc("submit");
		if("".equals(getRequestid())){
			RequestManager.setIscreate("1");
		}
		RequestManager.setWorkflowid(Util.getIntValue(getWorkflowid(), 0));
		RequestManager.setWorkflowtype(workflowtype);
		RequestManager.setIsremark(0);
		RequestManager.setFormid(formid);
		RequestManager.setIsbill(isbill);
		RequestManager.setBillid(-1);
		RequestManager.setNodeid(nodeid);
		RequestManager.setNodetype("0");
		RequestManager.setRequestname(requestName);
		RequestManager.setRequestlevel("0");
		RequestManager.setRemark("");
		RequestManager.setMessageType("0");
		RequestManager.setUser(user);
		RequestManager.setFlowFrom("1");
		RequestManager.setIsagentCreater(IsagentCreater);
		if("".equals(getRequestid())){
			boolean savestatus = RequestManager.saveRequestInfo();
			return RequestManager;
		}else{
			RequestManager.setRequestid(Integer.parseInt(getRequestid()));
			return RequestManager;
		}
	}

	public String getCurrentDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
}

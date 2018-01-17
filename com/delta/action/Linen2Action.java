package com.delta.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;


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
import weaver.soa.workflow.request.Property;
import weaver.soa.workflow.request.RequestInfo;
import weaver.soa.workflow.request.Row;


/**
 * 
 * 功能：布草报废
 * 
 * 
 */
public class Linen2Action extends BaseBean implements Action {
	public String execute(RequestInfo request) {
		LogMan lmdept = LogMan.getInstance();
		String url =  super.getPropValue("delta", "LINEDATA");
		
		request.getMainTableInfo();
		String requestid = Util.null2String(request.getRequestid());
		char separator = Util.getSeparator();
		RecordSet rs3 = new RecordSet();
		List<LinenData> datas = new ArrayList();
		Linen imp = new Linen();
		
		Calendar todaycal = Calendar.getInstance();
		String today = Util.add0(todaycal.get(Calendar.YEAR), 4) + "-"
				+ Util.add0(todaycal.get(Calendar.MONTH) + 1, 2) + "-"
				+ Util.add0(todaycal.get(Calendar.DAY_OF_MONTH), 2);
		//String userpara = "" + 1 + separator + today;
		
		
		lmdept.writeLog("布草报废退回开始------------------------------");
		String org_id = "";
		String organization_id = "";
		String bill_type_id = "";
		String bill_number = "";
		String apply_date = "";
		String apply_room = "";
		String transaction_type_id = "";
		String approval_date = "";
		String status_code = "";
		String bill_description = "";
		String bill_comment = "";
		String source_code = "";
 
		String sqrbh = "";
		String sprbh = ""+request.getRequestManager().getUserId();
		
		rs3.executeSql("select　* from hrmresource where id = '"+sprbh+"'");
		rs3.next();
		sprbh = rs3.getString("workcode"); 
		
		
		
		//取主表数据
		Property[] properties = request.getMainTableInfo().getProperty();// 获取表单主字段信息
		for (int i = 0; i < properties.length; i++) {

			String name = properties[i].getName();// 主字段名称
			String value = Util.null2String(properties[i].getValue());// 主字段对应的值
			//System.out.println(name + " " + value);
			if(name.equals("kczz")){
				organization_id = value;
			}
			if(name.equals("djbh")){
				bill_number = value;
			}
			if(name.equals("ywst")){
				org_id = value;
			}
			if(name.equals("djlx")){
				bill_type_id = value;
			}

			if(name.equals("lyks")){ 
				apply_room = value;
			}
			if(name.equals("sqbm")){
				transaction_type_id = value;
			}
			if(name.equals("sqrq")){
				apply_date = value;
			}
			if(name.equals("shrq")){
				approval_date = value;
			}
			if(name.equals("djzt")){
				status_code = value;
			}
			//if(name.equals("pzrq")){
				//approval_date = value;
			//}
			if(name.equals("ywmsn")){
				bill_description = value;
			}
			
			if(name.equals("sqrbh")){ 
				sqrbh = value;
			}
	
			
			if(name.equals("bz")){ 
				bill_comment = Util.null2String(value);
			}
		}
		
		try {
			
			bill_comment = "<![CDATA["+StrUtil.subStringByByte(bill_comment,240)+"]]>";
		
	
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		String org_sql = "select * from oa_inv_organization_v l WHERE l.organization_id = '"+organization_id+"' AND l.organization_id <> '101'";
		RecordSet rs = new RecordSet();
		rs.executeSql(org_sql);
		if(rs.next()){
			org_id = rs.getString(4);
		}
		
		imp.setOrganization_id(organization_id);
		imp.setApply_room(apply_room);
		imp.setApply_date(apply_date);
		imp.setBill_comment(bill_comment);//.replace("<", " ").replace(">", " ").replace("&", " ")
		imp.setBill_description(bill_description);
		imp.setBill_number(bill_number);
		imp.setBill_type_id(bill_type_id);
		imp.setOrg_id(org_id);  
		imp.setStatus_code("OA"); 
		imp.setStatus_code("APPROVED");
		imp.setAttribute14(sprbh);
		imp.setAttribute15(sprbh);
		
		imp.setTransaction_type_id(transaction_type_id);
		if("".equals(approval_date) || approval_date == null){
			approval_date = today;
		}

		imp.setApproval_date(approval_date);
		
		
		//imp.setApproval_date(approval_date);
	
		
		//取明细数据
		DetailTable[] detailtable = request.getDetailTableInfo()
				.getDetailTable();// 获取所有明细表
		if (detailtable.length > 0) {
			
			
			
			for (int i = 0; i < detailtable.length; i++) {
				DetailTable dt = detailtable[i];// 指定明细表
				
				Row[] s = dt.getRow();// 当前明细表的所有数据,按行存储
				for (int j = 0; j < s.length; j++) {
			
					Row r = s[j];// 指定行
					LinenData data = new LinenData();
					
					String line_number = "";
					String item_id = "";
		
					String account_unit_code = "";
					String apply_number = "";
					String handle_number = "";
					String from_inventory_code = "";
					String to_inventory_code = "";

					String process_person_id = "";
					String process_date = "";
					String line_status_code = "";
					String line_comment = "";
					
					
					Cell c[] = r.getCell();// 每行数据再按列存储
					for (int k = 0; k < c.length; k++) {
						Cell c1 = c[k];// 指定列
						String name = c1.getName();// 明细字段名称
						String value = c1.getValue();// 明细字段的值
						//System.out.println(name + " " + value);
						if("wlbm".equals(name)){
							item_id = value;
						} 
						if("hsdw".equals(name)){
							account_unit_code = value;
						}
						if("bfsqsl".equals(name)){
							apply_number = value;
						}
						if("clsl".equals(name)){
							handle_number = value;
						}
						if("bfddn".equals(name)){
							from_inventory_code = value;
						}
						if("mdn".equals(name)){
							to_inventory_code = value;
						} 
						if("clr".equals(name)){
							process_person_id = value;
						}
						if("clrq".equals(name)){
							process_date = value;
						}
						if("hzt".equals(name)){
							line_status_code = value;
						}
						if("bz".equals(name)){
							line_comment = Util.null2String(value);
						}
						//if("hsdw".equals(name)){
							//line_comment = value;
						//} 
					

						
					}
					
					
					try {
						
						line_comment = "<![CDATA["+StrUtil.subStringByByte(line_comment,240)+"]]>";
					
				
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					data.setAccount_unit_code(account_unit_code);
					data.setApply_number(apply_number);
					data.setFrom_inventory_code(from_inventory_code);
					data.setHandle_number(handle_number);
					data.setItem_id(item_id);
					data.setLine_number(Integer.valueOf(j+1).toString());
					data.setLine_comment(line_comment);//.replace("<", " ").replace(">", " ").replace("&", " ")
					data.setLine_status_code("APPROVED");
					data.setOrg_id(org_id); 
					data.setOrganization_id(organization_id);
					if("".equals(process_date) || process_date == null){
						process_date = today;
					}
					data.setProcess_date(process_date);
					data.setProcess_person_id(process_person_id);
					data.setTo_inventory_code(to_inventory_code);
					
					datas.add(data);  
					
				} 
			}
		}
		
		
		
		WebService service = new WebService();
		String ret = service.BillNumber(url, imp, datas);
		if("E".equals(ret)){
			request.getRequestManager().setMessageid("9999999");
			request.getRequestManager().setMessagecontent("布草报废写入异常,请通知管理员@!!!");
			lmdept.writeLog("布草写报废入失败...............................");
		}else{
			lmdept.writeLog("布草数据报废写入成功...................");
		}

 		return Action.SUCCESS;
	}
}

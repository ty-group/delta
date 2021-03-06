package com.delta.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;


import com.delta.Imp;
import com.delta.ImpData;

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
 * 功能：固资数据写入
 * 
 * 
 */
public class BudgetAction extends BaseBean implements Action {
	public String execute(RequestInfo request) {
		LogMan lmdept = LogMan.getInstance();
		String url =  super.getPropValue("delta", "IMPURL");
		
		request.getMainTableInfo();
		String requestid = Util.null2String(request.getRequestid());
		char separator = Util.getSeparator();
		
		List<ImpData> datas = new ArrayList();
		Imp imp = new Imp();
		
		Calendar todaycal = Calendar.getInstance();
		String today = Util.add0(todaycal.get(Calendar.YEAR), 4) + "-"
				+ Util.add0(todaycal.get(Calendar.MONTH) + 1, 2) + "-"
				+ Util.add0(todaycal.get(Calendar.DAY_OF_MONTH), 2);
		//String userpara = "" + 1 + separator + today;
		
		
		lmdept.writeLog("固资写入开始------------------------------");
		 String  organization_id  = "";
		 String  urgent_level  = "";
		 String  doc_type_id = "";
		 String  sourec_code = "";
		 String  doc_number = "";
		 String  apply_employee_number = "";
		 String  apply_organization_id = "";
		 String  apply_date = "";
		 //String  apply_time = "";
		 String  sub_inventory_from = "";
		 String  sub_inventory_to = "";
		 String  ward_area = "";
		 String  maintain_order = "";
		 String  project_number = "";
		 String  approval_date = "";
		 String  approval_employee_number = Integer.toString(request.getRequestManager().getUserId());
		 String  doc_status = "APPROVAL" ;
		 String comments = "";
 
		
		
		//取主表数据
		Property[] properties = request.getMainTableInfo().getProperty();// 获取表单主字段信息
		for (int i = 0; i < properties.length; i++) {

			String name = properties[i].getName();// 主字段名称
			String value = Util.null2String(properties[i].getValue());// 主字段对应的值
			//System.out.println(name + " " + value);
			if(name.equals("kczz")){
				organization_id = value;
			}
			if(name.equals("jjcd")){
				urgent_level = value;
			}
			if(name.equals("djlx")){
				doc_type_id = value;
			}
			if(name.equals("djbh")){
				doc_number = value;
			}
			if(name.equals("sqrbh")){
				apply_employee_number = value;
			}
			if(name.equals("sqbm")){
				apply_organization_id = value;
			}
			if(name.equals(" sqrq")){ 
				apply_date = value;
			}
			if(name.equals("lyzkc")){
				sub_inventory_from = value;
			}
			if(name.equals("mbzkc")){
				sub_inventory_to = value;
			}
			if(name.equals("pzrq")){
				approval_date = value;
			}
			if(name.equals("bz")){
				comments = Util.null2String(value);
			}
			
			if(name.equals("djzt")){
				//doc_status = value;
			}
		} 
		
		try {
			
			comments = "<![CDATA["+StrUtil.subStringByByte(comments,240)+"]]>";
	
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		if("".equals(apply_date) || apply_date == null ) {
			apply_date = today;
		} 
		
		imp.setOrganization_id(organization_id);
		imp.setUrgent_level(urgent_level);
		imp.setDoc_type_id(doc_type_id);
		imp.setDoc_number(doc_number);
		imp.setApply_employee_number(apply_employee_number);
		imp.setApply_organization_id("0");
		imp.setDoc_status("APPROVAL");
		imp.setApply_date(apply_date); 
		imp.setSub_inventory_from(sub_inventory_from);
		imp.setSub_inventory_to(sub_inventory_to); 
		 
		if("".equals(approval_date) || approval_date == null ) {
			approval_date = today;
		}
		imp.setApproval_date(approval_date);
		RecordSet rs3 = new RecordSet();
		rs3.executeSql("select　* from hrmresource where id = '"+approval_employee_number+"'"); 
		rs3.next();
		approval_employee_number = rs3.getString("workcode");
		
		imp.setApproval_employee_number(approval_employee_number);
		
		
		

		
		
	
		
		
		//取明细数据
		DetailTable[] detailtable = request.getDetailTableInfo()
				.getDetailTable();// 获取所有明细表
		if (detailtable.length > 0) {
			
			
			
			for (int i = 0; i < detailtable.length; i++) {
				DetailTable dt = detailtable[i];// 指定明细表
				
				Row[] s = dt.getRow();// 当前明细表的所有数据,按行存储
				for (int j = 0; j < s.length; j++) {
			
					Row r = s[j];// 指定行
					ImpData data = new ImpData();
					
					
			
					 
					 String item_number = "";
		
					 String quantity = "";
					 String uom = "";
					 String need_date = "";
					 String project_number_dt = "";
					 String line_status = "APPROVAL";
					 //String box_board;
					 String comments_dt = "";
					 String vendor_id = "";
					 String vendor_site_id = "";
					 String manu_id = "";
					
					
					Cell c[] = r.getCell();// 每行数据再按列存储
					for (int k = 0; k < c.length; k++) {
						Cell c1 = c[k];// 指定列
						String name = c1.getName();// 明细字段名称
						String value = c1.getValue();// 明细字段的值
						//System.out.println(name + " " + value);
						if("wlbm".equals(name)){
							item_number = value;
						}
						if("sqsl".equals(name)){
							quantity = value;
						}
						if("sqdw".equals(name)){
							uom = value;
						}
						if("xyrq".equals(name)){
							need_date = value;
						}
						if("bz".equals(name)){
							comments_dt = Util.null2String(value);
						}
						if("gys1".equals(name)){// --供应商
							vendor_id = value;
						}
						
						//if("bz".equals(name)){// --供应商地点
							//vendor_site_id = value;
						//}
						if("sccs".equals(name)){//--生产厂商
							manu_id = value;
						}

						
					}
					
					try {
						
						comments_dt = "<![CDATA["+StrUtil.subStringByByte(comments_dt,240)+"]]>";
				
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					
					data.setComments(comments_dt);
					data.setItem_number(item_number);
					data.setLine_number(Integer.valueOf(j+1).toString());
					data.setNeed_date(need_date);
					data.setOrganization_id(organization_id);
					data.setQuantity(quantity);
					data.setSub_inventory_from(sub_inventory_from);
					data.setSub_inventory_to(sub_inventory_to);
					data.setLine_status("APPROVAL");
					data.setUom(uom);
					data.setVendor_id(vendor_id);
					data.setVendor_site_id(vendor_site_id);
					data.setManu_id(manu_id);
					
					
					datas.add(data);
					
				}
			}
		}
		
		
		
		WebService service = new WebService();
		String ret = service.impData(url, imp, datas);
		if("E".equals(ret)){
			request.getRequestManager().setMessageid("9999999");
			request.getRequestManager().setMessagecontent("固资数据写入异常,请通知管理员@!!!");
			lmdept.writeLog("固资数据写入失败...............................");
		}else{
			lmdept.writeLog("固资数据写入成功...................");
		}

 		return Action.SUCCESS;
	}
}

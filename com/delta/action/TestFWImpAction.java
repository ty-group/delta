package com.delta.action;

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
 * 功能：服务写入
 * 
 * 
 */
public class TestFWImpAction extends BaseBean  {
	public String execute() {
		LogMan lmdept = LogMan.getInstance();
		String url =  super.getPropValue("delta", "IMPURL");
		
		
		char separator = Util.getSeparator();
		
		
		
		Calendar todaycal = Calendar.getInstance();
		String today = Util.add0(todaycal.get(Calendar.YEAR), 4) + "-"
				+ Util.add0(todaycal.get(Calendar.MONTH) + 1, 2) + "-"
				+ Util.add0(todaycal.get(Calendar.DAY_OF_MONTH), 2);
		//String userpara = "" + 1 + separator + today;
		
		
		lmdept.writeLog("服务写入开始------------------------------");
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
		 String  approval_employee_number = "";//Integer.toString(request.getRequestManager().getUserId());
		 String  doc_status = "APPROVAL" ;
		 String comments = "";
 
		 RecordSet rs = new RecordSet();
		 RecordSet rs2 = new RecordSet();
		//取主表数据  
		 
		 rs.executeSql("select * from formtable_main_16 where requestid in (1483)");
		 while(rs.next()){
			 List<ImpData> datas = new ArrayList(); 
			Imp imp = new Imp();
			 organization_id = Util.null2String(rs.getString("kczz"));
			 urgent_level = Util.null2String(rs.getString("jjcd"));
			 doc_type_id = Util.null2String(rs.getString("fwdjlx1"));
			 doc_number = Util.null2String(rs.getString("djbh"));
			 apply_employee_number = Util.null2String(rs.getString("sqrbh"));
			 apply_date = Util.null2String(rs.getString("sqrq"));
			 sub_inventory_from = Util.null2String(rs.getString("lyzkc"));
			 sub_inventory_to = Util.null2String(rs.getString("mbzkc"));
			 approval_date = Util.null2String(rs.getString("pzrq"));
			 comments = Util.null2String(Util.null2String(rs.getString("bz")));
			 apply_organization_id = Util.null2String(Util.null2String(rs.getString("lyks")));
			 
			 
				
				if("".equals(apply_date) || apply_date == null ) {
					apply_date = today;
				} 
				
				imp.setOrganization_id(organization_id);
				imp.setUrgent_level(urgent_level);
				imp.setDoc_type_id(doc_type_id);
				imp.setDoc_number(doc_number);
				imp.setApply_employee_number(apply_employee_number);
				imp.setApply_organization_id(apply_organization_id);
				imp.setDoc_status("APPROVAL");
				imp.setApply_date(apply_date); 
				imp.setSub_inventory_from(sub_inventory_from);
				imp.setSub_inventory_to(sub_inventory_to);
				imp.setComments(comments); 
				
				if("".equals(approval_date) || approval_date == null ) {
					approval_date = today;
				} 
				RecordSet rs3 = new RecordSet();
				rs3.executeSql("select　* from hrmresource where id = '"+approval_employee_number+"'"); 
				rs3.next();
				approval_employee_number = rs3.getString("workcode");
				
				imp.setApproval_date(approval_date);
				imp.setApproval_employee_number(approval_employee_number);
				
				//取明细
				String mainid = rs.getString("id");
				rs2.executeSql("select * from formtable_main_16_dt1 where mainid = '"+mainid+"'");

				
				int j = 0; 
				while(rs2.next()){
					
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
					 String  ysbh = "";
					 String wlsm = "";
					 String ggxh = "";
					 String dj = "";
				
							item_number = Util.null2String(rs2.getString("fwwlbm"));
				
							quantity = Util.null2String(rs2.getString("sqsl"));
						
							uom = Util.null2String(rs2.getString("sqdw"));
					
							need_date = Util.null2String(rs2.getString("xyrq"));
					
					
							comments_dt = Util.null2String(rs2.getString("bz"));
						
		
							vendor_id = Util.null2String(rs2.getString("gzgys"));// --供应商
					
						
						
							ggxh = Util.null2String(rs2.getString("ggxh"));// --规格型号
						
				
				
							dj = Util.null2String(rs2.getString("dj"));
						
						
			
							 ysbh  = Util.null2String(rs2.getString("fwysbh"));// --预算编号
						
					
							 wlsm  = Util.null2String(rs2.getString("wlsm"));//--物料说明
						
						
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
								data.setItem_desc(wlsm);
								data.setBudget_num(ysbh);
								data.setGgxh(ggxh);
								data.setDj(dj);
								j = j+1;
								
								
								
								datas.add(data); 
					 
				}
				
				//数据写入
				WebService service = new WebService();
				String ret = service.impData(url, imp, datas);
				if("E".equals(ret)){				
					lmdept.writeLog("服务数据写入失败...............................");
				}else{
					lmdept.writeLog("服务数据写入成功...................");
				}
				
		 }
		 
		 return "";
	}
}

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
 * 功能：固资申请写入
 * 
 * 
 */
public class ApplyImp1Action extends BaseBean implements Action {
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
				organization_id = Util.null2String(value);
			}
			if(name.equals("jjcd")){
				urgent_level = Util.null2String(value);
			}
			if(name.equals("djlx1")){
				doc_type_id = Util.null2String(value);
			}
			if(name.equals("djbh")){
				doc_number = Util.null2String(value);
			} 
			if(name.equals("sqrbh")){
				apply_employee_number = Util.null2String(value);
			}
		
			if(name.equals(" sqrq")){ 
				apply_date = Util.null2String(value);
			}
			if(name.equals("lyzkc")){
				sub_inventory_from = Util.null2String(value);
			}
			if(name.equals("mbzkc")){
				sub_inventory_to = Util.null2String(value);
			}
			if(name.equals("pzrq")){
				approval_date = Util.null2String(value);
			} 
			if(name.equals("bz")){
				comments = Util.null2String(Util.null2String(value));
			}
			if(name.equals("lyks")){
				apply_organization_id = Util.null2String(Util.null2String(value));
			}
			
			if(name.equals("djzt")){
				//doc_status = Util.null2String(value);
			}
		}  
		
		if("".equals(apply_date) || apply_date == null ) {
			apply_date = today;
		} 
		 
 
		RecordSet rs3 = new RecordSet();
		rs3.executeSql("select　* from hrmresource where id = '"+approval_employee_number+"'"); 
		rs3.next();
		approval_employee_number = rs3.getString("workcode");
		
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
		try {
			comments = StrUtil.subStringByByte(comments,240);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			comments = "";
		}
		imp.setComments("<![CDATA["+comments+"]]>"); 
		
		if("".equals(approval_date) || approval_date == null ) {
			approval_date = today;
		}
		imp.setApproval_date(approval_date);
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
					 String  ysbh = "";
					 String wlsm = "";
					 String ggxh = "";
					 String dj = "";
					
					
					Cell c[] = r.getCell();// 每行数据再按列存储
					for (int k = 0; k < c.length; k++) {
						Cell c1 = c[k];// 指定列
						String name = c1.getName();// 明细字段名称
						String value = c1.getValue();// 明细字段的值
						//System.out.println(name + " " + Util.null2String(value));
						if("gzwlbm".equals(name)){
							item_number = Util.null2String(value);
						}
						if("sqsl".equals(name)){
							quantity = Util.null2String(value);
						}
						if("sqdw".equals(name)){
							uom = Util.null2String(value);
						}
						if("xyrq".equals(name)){
							need_date = Util.null2String(value);
						}
						if("bz".equals(name)){
							comments_dt = Util.null2String(value);
						} 
						if("gzgys".equals(name)){// --供应商
							vendor_id = Util.null2String(value);
						}
						
						if("ggxh".equals(name)){// --规格型号
							ggxh = Util.null2String(value);
						}
						if("sccs".equals(name)){//--生产厂商
							//manu_id = Util.null2String(value);
						} 
						if("dj".equals(name)){//-
							dj = Util.null2String(value);
						} 
						
						if("gzysbm".equals(name)){// --预算编号
							 ysbh  = Util.null2String(value);
						}
						if("wlsm".equals(name)){//--物料说明
							 wlsm  = Util.null2String(value);
						} 
						
						
					}  
					try {
						wlsm = "<![CDATA["+StrUtil.subStringByByte(wlsm,240)+"]]>";
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					comments_dt = "<![CDATA["+comments_dt+"]]>";
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

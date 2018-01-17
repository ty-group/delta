package com.delta.action;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;


import com.delta.BudgetData;
import com.delta.Imp;
import com.delta.ImpData;

import com.delta.WebService;


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
public class BudgetImpAction extends BaseBean implements Action {
	public String execute(RequestInfo request) {
		LogMan lmdept = LogMan.getInstance();
		String url =  super.getPropValue("delta", "DEGBUT");
		
		request.getMainTableInfo();
		String requestid = Util.null2String(request.getRequestid());
		char separator = Util.getSeparator();
		
		List<BudgetData> list = new ArrayList<BudgetData>();

		
		Calendar todaycal = Calendar.getInstance();
		String today = Util.add0(todaycal.get(Calendar.YEAR), 4) + "-"
				+ Util.add0(todaycal.get(Calendar.MONTH) + 1, 2) + "-"
				+ Util.add0(todaycal.get(Calendar.DAY_OF_MONTH), 2);
		//String userpara = "" + 1 + separator + today;
		
		 
		lmdept.writeLog("固资写入开始------------------------------");

		
		String status_code = "";// 物资申请单状态
		String reserve_type = "" ;//预算类型 --add 保留   release 释放
		String order_type = "";//固定给po
		String order_number = "" ;//物资申请单 单据编号
		//String order_line_num = "";//物资申请单行号
		String sfysn = "";
	
		
		
		//取主表数据
		Property[] properties = request.getMainTableInfo().getProperty();// 获取表单主字段信息
		for (int i = 0; i < properties.length; i++) {

			String name = properties[i].getName();// 主字段名称
			String value = Util.null2String(properties[i].getValue());// 主字段对应的值
			//System.out.println(name + " " + value);
			if(name.equals("djbh")){
				order_number = value;
			}
			if(name.equals("djzt")){
				status_code = value;
			}
			if(name.equals("sfysn")){
				sfysn = value;
			}
			
		} 


		
		//取明细数据
		DetailTable[] detailtable = request.getDetailTableInfo()
				.getDetailTable();// 获取所有明细表
		if (detailtable.length > 0) {
			
			
			
			for (int i = 0; i < detailtable.length; i++) {
				DetailTable dt = detailtable[i];// 指定明细表
				
				Row[] s = dt.getRow();// 当前明细表的所有数据,按行存储
				for (int j = 0; j < s.length; j++) {
			
					Row r = s[j];// 指定行

					BudgetData data = new BudgetData();
					String budget_number = "";// 预算编号 ysbh
					String reserve_date  = "";//预算日期xyrq
					String quantity = "";//数量ddsl
					String unit_price = "";// 单价dj
					
					Cell c[] = r.getCell();// 每行数据再按列存储
					for (int k = 0; k < c.length; k++) {
						Cell c1 = c[k];// 指定列
						String name = c1.getName();// 明细字段名称
						String value = c1.getValue();// 明细字段的值
						//System.out.println(name + " " + value);
						if("ysbh".equals(name)){
							budget_number = value;
						}
						if("sqsl".equals(name)){
							quantity = value;
						}
						if("xyrq".equals(name)){
							reserve_date = value;
						}
						if("dj".equals(name)){
							unit_price = value;
						}  

						
					} 
					
					data.setBudget_number(budget_number);
					data.setOrder_number(order_number);
					data.setOrder_type(order_type);
					data.setQuantity(quantity);
					data.setReserve_date(reserve_date);
					data.setReserve_type("ADD");
					data.setStatus_code(status_code);
					data.setUnit_price(unit_price);
					list.add(data);
					
				} 
			}
		}
				
		if(sfysn.equals("0")){//预算内
			WebService service = new WebService();
			String ret = service.impBudget(url, list);
			if("E".equals(ret)){
				request.getRequestManager().setMessageid("9999999");
				request.getRequestManager().setMessagecontent("固资数据写入异常,请通知管理员@!!!");
				lmdept.writeLog("固资数据写入失败...............................");
			}else{
				lmdept.writeLog("固资数据写入成功...................");
			} 
		}


 		return Action.SUCCESS;
	}
}

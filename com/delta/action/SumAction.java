package com.delta.action;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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
 * 功能：非常规药品/物资采购申请单 金额计算

 * 
 * 
 */
public class SumAction extends BaseBean implements Action {
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
		
		
		RecordSet rs = new RecordSet();
	
		
		
		//取明细数据
		DetailTable[] detailtable = request.getDetailTableInfo()
				.getDetailTable();// 获取所有明细表
		if (detailtable.length > 0) {
			
			
			
			for (int i = 0; i < detailtable.length; i++) {
				DetailTable dt = detailtable[i];// 指定明细表
				double sum = 0.00;
				Row[] s = dt.getRow();// 当前明细表的所有数据,按行存储
				for (int j = 0; j < s.length; j++) {
			
					Row r = s[j];// 指定行
					ImpData data = new ImpData();
					
					
			
					 

					double sqsl = 0.00; 
					 double hsdj = 0.00; 
					
					
					Cell c[] = r.getCell();// 每行数据再按列存储
					for (int k = 0; k < c.length; k++) {
						Cell c1 = c[k];// 指定列
						String name = c1.getName();// 明细字段名称
						String value = c1.getValue();// 明细字段的值
				
						if("sqsl".equals(name)){
							if(value!=null){
								value=value.replace(",", "");
							}
							sqsl =  Util.getDoubleValue(value, 0.00);
						}
						
						
						if("hsdj".equals(name)){// --含税单价
							if(value!=null){
								value=value.replace(",", "");
							}
							hsdj = Util.getDoubleValue(value, 0.00);
						}
						
					}
				 
					//BigDecimal   b   =   new   BigDecimal(sqsl*hsdj);  
					BigDecimal   b   =   new   BigDecimal(ArithmeticUtil.mul(sqsl, hsdj));  
					double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
					//sum += f1;
					sum = ArithmeticUtil.add(sum, f1);
					
					
				} 
				
				
				
				rs.writeLog("合计Action"+"update formtable_main_10 set totalmoney = '"+sum+"' where requestid = '"+requestid+"'");
				//写入主表
				rs.executeSql("update formtable_main_10 set totalmoney = '"+sum+"' where requestid = '"+requestid+"'");
				
				
			}
		}
		
		
		

 		return Action.SUCCESS;
	}
}

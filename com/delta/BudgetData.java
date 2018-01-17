package com.delta;


/**
 * 固资数据
 * @author Admin
 *
 */
public class BudgetData {

	
	
	private String budget_number;// 预算编号
	private String status_code;// 物资申请单状态
	private String reserve_type ;//预算类型 --add 保留   release 释放
	private String order_type ;//固定给po
	private String order_number  ;//物资申请单 单据编号
	private String order_line_num ;//物资申请单行号
	private String reserve_date  ;//预算日期

	private String quantity ;//数量
	private String unit_price;// 单价
	public String getBudget_number() {
		return budget_number;
	}
	public void setBudget_number(String budgetNumber) {
		budget_number = budgetNumber;
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String statusCode) {
		status_code = statusCode;
	}
	public String getReserve_type() {
		return reserve_type;
	}
	public void setReserve_type(String reserveType) {
		reserve_type = reserveType;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String orderType) {
		order_type = orderType;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String orderNumber) {
		order_number = orderNumber;
	}
	public String getOrder_line_num() {
		return order_line_num;
	}
	public void setOrder_line_num(String orderLineNum) {
		order_line_num = orderLineNum;
	}
	public String getReserve_date() {
		return reserve_date;
	}
	public void setReserve_date(String reserveDate) {
		reserve_date = reserveDate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(String unitPrice) {
		unit_price = unitPrice;
	}
	
	
	
}

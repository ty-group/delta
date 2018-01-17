package com.delta;


/**
 * 物资申请行信息
 * @author Admin
 *
 */
public class ImpData {

	
	private String organization_id;
	private String line_number;
	private String item_number;
	private String sub_inventory_from;
	private String sub_inventory_to;
	private String quantity;
	private String uom;
	private String need_date;
	private String project_number;
	private String line_status;
	private String box_board;
	private String comments;  
	private String item_desc;
	private String budget_num;
	private String ggxh;
	private String dj;
	
	
	
	
	
	
	
	
	public String getDj() {
		return dj;
	}
	public void setDj(String dj) {
		this.dj = dj;
	}
	public String getGgxh() {
		return ggxh;
	}
	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String itemDesc) {
		item_desc = itemDesc;
	}
	public String getBudget_num() {
		return budget_num;
	}
	public void setBudget_num(String budgetNum) {
		budget_num = budgetNum;
	}
	private String vendor_id ;//    --供应商
	private String    vendor_site_id;//   --供应商地点
	private String    manu_id ;// --生产厂商
	public String getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(String organizationId) {
		organization_id = organizationId;
	}
	public String getLine_number() {
		return line_number;
	}
	public void setLine_number(String lineNumber) {
		line_number = lineNumber;
	}
	public String getItem_number() {
		return item_number;
	}
	public void setItem_number(String itemNumber) {
		item_number = itemNumber;
	}
	public String getSub_inventory_from() {
		return sub_inventory_from;
	}
	public void setSub_inventory_from(String subInventoryFrom) {
		sub_inventory_from = subInventoryFrom;
	}
	public String getSub_inventory_to() {
		return sub_inventory_to;
	}
	public void setSub_inventory_to(String subInventoryTo) {
		sub_inventory_to = subInventoryTo;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getNeed_date() {
		return need_date;
	}
	public void setNeed_date(String needDate) {
		need_date = needDate;
	}
	public String getProject_number() {
		return project_number;
	}
	public void setProject_number(String projectNumber) {
		project_number = projectNumber;
	}
	public String getLine_status() {
		return line_status;
	}
	public void setLine_status(String lineStatus) {
		line_status = lineStatus;
	}
	public String getBox_board() {
		return box_board;
	}
	public void setBox_board(String boxBoard) {
		box_board = boxBoard;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(String vendorId) {
		vendor_id = vendorId;
	}
	public String getVendor_site_id() {
		return vendor_site_id;
	}
	public void setVendor_site_id(String vendorSiteId) {
		vendor_site_id = vendorSiteId;
	}
	public String getManu_id() {
		return manu_id;
	}
	public void setManu_id(String manuId) {
		manu_id = manuId;
	}
	

}

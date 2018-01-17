package com.delta.sso;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.general.GCONST;
import weaver.general.StaticObj;
import weaver.general.Util;
import weaver.hrm.User;
import weaver.hrm.settings.HrmSettingsComInfo;
import weaver.systeminfo.SysMaintenanceLog;

/**
 * 2017-11-29 Created by Ink,tangyue Corp
 */
public class DeltaVerifyLogin {
	public String getUserCheck(HttpServletRequest request,
			HttpServletResponse response, String login_id, boolean isAdmin)
			throws Exception {
		try {
			StaticObj staticobj = null;
			staticobj = StaticObj.getInstance();

			RecordSet rs = new RecordSet();
			RecordSet rs1 = new RecordSet();
			RecordSet rs2 = new RecordSet();
			char separator = Util.getSeparator();
			String message = "";
			boolean MOREACCOUNTLANDING = GCONST.getMOREACCOUNTLANDING();
			Calendar today = Calendar.getInstance();
			String currentdate = Util.add0(today.get(Calendar.YEAR), 4) + "-"
					+ Util.add0(today.get(Calendar.MONTH) + 1, 2) + "-"
					+ Util.add0(today.get(Calendar.DAY_OF_MONTH), 2);
			String currenttime = Util.add0(today.get(Calendar.HOUR_OF_DAY), 2)
					+ ":" + Util.add0(today.get(Calendar.MINUTE), 2) + ":"
					+ Util.add0(today.get(Calendar.SECOND), 2);
			ArrayList onlineuserids = null;
			onlineuserids = (ArrayList) staticobj.getObject("onlineuserids");
			if(isAdmin){
				rs.execute("select * from hrmresourcemanager where loginid = '"+login_id+"'");
				rs.next();
			}else{
				rs.execute("select * from hrmresource where loginid = '"+login_id+"'");
				rs.next();
			}
			if (onlineuserids != null) {
				if (onlineuserids.indexOf("" + rs.getInt("id")) != -1) {
					String sqltmp = "";
					if (rs1.getDBType().equals("oracle")) {
						sqltmp = "select * from (select * from HrmSysMaintenanceLog where relatedid = "
								+ rs.getInt("id")
								+ " and operatetype='6' and operateitem='60' order by id desc ) where rownum=1 ";
					} else if (rs.getDBType().equals("db2")) {
						sqltmp = "select * from HrmSysMaintenanceLog where relatedid = "
								+ rs.getInt("id")
								+ " and operatetype='6' and operateitem='60' order by id desc fetch first 1 rows only ";
					} else {
						sqltmp = "select top 1 * from HrmSysMaintenanceLog where relatedid = "
								+ rs.getInt("id")
								+ " and operatetype='6' and operateitem='60' order by id desc";
					}

					rs1.executeSql(sqltmp);
					if (rs1.next())
						message = rs1.getString("clientaddress") + " "
								+ rs1.getString("operatedate") + " "
								+ rs1.getString("operatetime");
				}
			}
			
			String startdate = rs.getString("startdate");
			String enddate = rs.getString("enddate");

			User user = new User();

			user.setUid(rs.getInt("id"));
			user.setLoginid(login_id);
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setAliasname(rs.getString("aliasname"));
			user.setTitle(rs.getString("title"));
			user.setTitlelocation(rs.getString("titlelocation"));
			user.setSex(rs.getString("sex"));
			// user.setPwd(user_password);
			String languageidweaver = rs.getString("systemlanguage");
			user.setLanguage(Util.getIntValue(languageidweaver, 0));
			user.setTelephone(rs.getString("telephone"));
			user.setMobile(rs.getString("mobile"));
			user.setMobilecall(rs.getString("mobilecall"));
			user.setEmail(rs.getString("email"));
			user.setCountryid(rs.getString("countryid"));
			user.setLocationid(rs.getString("locationid"));
			user.setResourcetype(rs.getString("resourcetype"));
			user.setStartdate(startdate);
			user.setEnddate(enddate);
			user.setContractdate(rs.getString("contractdate"));
			user.setJobtitle(rs.getString("jobtitle"));
			user.setJobgroup(rs.getString("jobgroup"));
			user.setJobactivity(rs.getString("jobactivity"));
			user.setJoblevel(rs.getString("joblevel"));
			user.setSeclevel(rs.getString("seclevel"));
			user.setUserDepartment(Util.getIntValue(
					rs.getString("departmentid"), 0));
			user.setUserSubCompany1(Util.getIntValue(
					rs.getString("subcompanyid1"), 0));
			user.setUserSubCompany2(Util.getIntValue(
					rs.getString("subcompanyid2"), 0));
			user.setUserSubCompany3(Util.getIntValue(
					rs.getString("subcompanyid3"), 0));
			user.setUserSubCompany4(Util.getIntValue(
					rs.getString("subcompanyid4"), 0));
			user.setManagerid(rs.getString("managerid"));
			user.setAssistantid(rs.getString("assistantid"));
			user.setPurchaselimit(rs.getString("purchaselimit"));
			user.setCurrencyid(rs.getString("currencyid"));
			user.setLastlogindate(currentdate);
			user.setLogintype("1");
			user.setAccount(rs.getString("account"));
			//user.setIsAdmin(isAdmin);
			// xiaofeng
	/*		HrmSettingsComInfo sci = new HrmSettingsComInfo();

			*//** 检测是否启用usb网段策略开始 **//*
			String clientIP = request.getRemoteAddr();

			String usbType = sci.getUsbType();
			String needusbHt = sci.getNeedusbHt();
			String needusbDt = sci.getNeedusbDt();*/
			/*String userUsbType = Util.null2String(rs.getString("userUsbType")); // 指定usbkey验证类型
			if (!userUsbType.equals("")) {
				//usbType = userUsbType;
			}*/
			user.setLoginip(request.getRemoteAddr());
			request.getSession(true).setAttribute("weaver_user@bean", user);

			Util.setCookie(response, "loginidweaver", "" + user.getUID(),
					172800);
			Util.setCookie(response, "languageidweaver", languageidweaver,
					172800);
			char separater = Util.getSeparator();
//			rs.execute("HrmResource_UpdateLoginDate", rs.getString("id")
//					+ separater + currentdate);
			// 解决开启USB情况下时人员登录出现重复记录的问题 by sjh 54096
			// if("".equals(usbType) || usbType==null){
			/*SysMaintenanceLog log = new SysMaintenanceLog();
			log.resetParameter();
			log.setRelatedId(rs.getInt("id"));
			log.setRelatedName((rs.getString("firstname") + " " + rs
					.getString("lastname")).trim());
			log.setOperateType("6");
			log.setOperateDesc("");
			log.setOperateItem("60");
			log.setOperateUserid(rs.getInt("id"));
			log.setClientAddress(request.getRemoteAddr());
			log.setSysLogInfo();
			// }
			// 检查是否有客户联系计划
			 刘煜修改 2004－05－08 登录检查客户联系计划以前是选取所有的记录，并不需要，现在更改为选择总数 
			char flag = 2;
			String sql = "";
			rs1.executeProc("SysRemindInfo_InserCrmcontact",
					"" + rs.getInt("id") + flag + "0" + flag + "0");
			sql = " select count(*) from CRM_ContactLog where isfinished = 0 and contactdate ='"
					+ currentdate + "' and resourceid =" + rs.getInt("id");
			rs1.executeSql(sql);
			if (rs1.next()) {
				if (Util.getIntValue(rs1.getString(1), 0) > 0)
					rs1.executeProc("SysRemindInfo_InserCrmcontact",
							"" + rs.getInt("id") + flag + "0" + flag + "1");

			} else {
				return "15";
			}*/
		} catch (Exception e) {
			new BaseBean().writeLog(e);
		}
		return "";
	}

}

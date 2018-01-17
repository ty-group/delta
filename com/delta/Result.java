package com.delta;

import java.io.InputStream;

/**
 * 返回结果类
 * @author Admin
 *
 */
public class Result {

	private int responseCode;
	private String responseRet;

	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseRet() {
		return responseRet;
	}
	public void setResponseRet(String responseRet) {
		this.responseRet = responseRet;
	}

	
}

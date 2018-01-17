package com.delta.util;

import java.io.IOException;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.xml.rpc.ServiceException;

import net.sf.json.JSONObject;
import weaver.general.BaseBean;

import com.thinkgem.jeesite.modules.sso.entity.xsd.SsoResultParam;
import com.thinkgem.jeesite.modules.sso.ws.api.AuthServiceLocator;
import com.thinkgem.jeesite.modules.sso.ws.api.AuthServiceSoap11BindingStub;

public class SSOUtil extends BaseBean {

	public static boolean validateUserToken(String uid, String token)
			throws KeyManagementException, NoSuchAlgorithmException,
			IOException {
		String url = "http://42.202.130.145:8080/hiip-portal/auth";
		JSONObject param = new JSONObject();
		param.put("uid", uid);
		param.put("token", token);
		String ret = SSLClient.sendPost(url, param.toString());
		// String ret = new String(bytes,"UTF-8");
		JSONObject responseObject = JSONObject.fromObject(ret);
		System.out.println(responseObject);
		String errorcode = responseObject.getString("result");
		System.out.println(errorcode);
		return "1".equals(errorcode);
	}

	public static SsoResultParam validateUserTokenWS(String uid, String token) {
		try {
			AuthServiceLocator locator = new AuthServiceLocator();
			AuthServiceSoap11BindingStub stub = (AuthServiceSoap11BindingStub) locator
					.getAuthServiceHttpSoap11Endpoint();
			SsoResultParam param = stub.authService(uid, token);
			new BaseBean().writeLog("**************"+param.getResult());
			new BaseBean().writeLog("**************"+param.getMessage());
			return param;
		} catch (Exception e) {
			new BaseBean().writeLog(e);
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
			System.out.println(validateUserTokenWS("ssotest3",
					"6358E855FDA9C9E1211EB21A41E0481149575D525D4D9453F8EBF057"));
		/*} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}

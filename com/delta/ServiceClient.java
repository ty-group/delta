package com.delta;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import weaver.general.BaseBean;

public class ServiceClient extends BaseBean{

	
	
	
	

    /**
     * 向指定URL发送POST方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数。
     * @return 
     * 			所代表远程资源的响应结果
     */
    public  static Result sendPost(String url, String params) {
    	Result result = new Result();
        BufferedReader in = null;
        HttpURLConnection connection = null; 
        
        new BaseBean().writeLog("调用地址=》"+url+"    传入参数=》"+params);
        try {
            //String urlNameString = url+"?"+params;
            byte[] entitydata = params.toString().getBytes();//得到实体的二进制数据
            // 打开和URL之间的连接
            connection = (HttpURLConnection) (new URL(url)).openConnection();
            // 设置通用的请求属性 
            connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
            connection.setRequestProperty("SOAPAction", url);//cux_inv_apply_data_ws_pkg
            connection.setRequestProperty("Content-Length",String.valueOf(entitydata.length));
            
            connection.setRequestProperty("Connection","Keep-Alive");
            connection.setRequestProperty("User-Agent","Apache-HttpClient/4.1.1 (java 1.5)");
     
            
            connection.setRequestProperty("Content-type","text/xml;charset=GBK;");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true); 
            

            OutputStream outStream = connection.getOutputStream();
            outStream.write(entitydata);
            outStream.flush();
            outStream.close();
            String retStr = "";
            int responseCode = connection.getResponseCode();
            if(responseCode == 200){//调用成功
         
	        	InputStream inStrm = connection.getInputStream();
	        	
				// 读取文件流程
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(inStrm,"UTF-8"));
				// 采取行的方式进行读取
				retStr = rd.readLine();
			
            }else{
            	retStr = "远程调用异常";
            }
            result.setResponseCode(responseCode);
            result.setResponseRet(retStr);
            System.out.println(retStr);
            System.out.println("返回代码=》"+responseCode+"    返回内容=》"+retStr);
			new BaseBean().writeLog("返回代码=》"+responseCode+"    返回内容=》"+retStr);
            
            /*
            
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }*/
        } catch (Exception e) {
        	result.setResponseCode(-999);
            result.setResponseRet("请求异常");
            System.out.println("发送Post请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    
    
    public Result sendPostEPS(String url, String params,String soapAction){
    	Result result = new Result();
        BufferedReader in = null;
        HttpURLConnection connection = null; 
        
        this.writeLog("调用地址=》"+url+"    传入参数=》"+params);
        try {
            //String urlNameString = url+"?"+params;
            byte[] entitydata = params.toString().getBytes();//得到实体的二进制数据
            // 打开和URL之间的连接
            connection = (HttpURLConnection) (new URL(url)).openConnection();
            // 设置通用的请求属性 
            connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
            connection.setRequestProperty("SOAPAction",soapAction);//cux_inv_apply_data_ws_pkg
            connection.setRequestProperty("Content-Length",String.valueOf(entitydata.length));
            
            connection.setRequestProperty("Connection","Keep-Alive");
            connection.setRequestProperty("Host","192.168.7.96:8000");
            connection.setRequestProperty("User-Agent","Apache-HttpClient/4.1.1 (java 1.5)");
     
            
            connection.setRequestProperty("Content-type","text/xml;charset=GBK;");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true); 
            

            OutputStream outStream = connection.getOutputStream();
            outStream.write(entitydata);
            outStream.flush();
            outStream.close();
            String retStr = "";
            int responseCode = connection.getResponseCode();
            if(responseCode == 200){//调用成功
         
	        	InputStream inStrm = connection.getInputStream();
	        	
				// 读取文件流程
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(inStrm,"UTF-8"));
				// 采取行的方式进行读取
				retStr = rd.readLine();
			
            }else{
            	retStr = "远程调用异常";
            }
            result.setResponseCode(responseCode);
            result.setResponseRet(retStr);
            System.out.println(retStr);
			this.writeLog("返回代码=》"+responseCode+"    返回内容=》"+retStr);
            
        } catch (Exception e) {
        	result.setResponseCode(-999);
            result.setResponseRet("请求异常");
            System.out.println("发送Post请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
        
    }
    
    
    
    
    
    
    public static void main(String[] args) {
		ServiceClient service = new ServiceClient();
		String url = "http://ebstest.deltahealth.com:8001/webservices/SOAProvider/plsql/cux_po_approval_ws_pkg/";
		String params = ""+
		"<?xml version=\"1.0\"?>"+
		"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">"+
		 "   <soap:Header xmlns:ns1=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_po_approval_ws_pkg/\">"+
		    "    <ns1:SOAHeader>"+
		          "  <ns1:Responsibility>CUX_SUPPER_USER</ns1:Responsibility>"+
		           " <ns1:RespApplication>CUX</ns1:RespApplication>"+
		          "  <ns1:SecurityGroup>STANDARD</ns1:SecurityGroup>"+
		          "  <ns1:NLSLanguage>AMERICAN</ns1:NLSLanguage>"+
		          "  <ns1:Org_Id>82</ns1:Org_Id>"+
		       " </ns1:SOAHeader>"+
		       " <wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" soap:mustUnderstand=\"1\">"+
		          "  <wsse:UsernameToken xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">"+
		               " <wsse:Username>HIS</wsse:Username>"+
		              "  <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">dhcdhc</wsse:Password>"+
		          "  </wsse:UsernameToken>"+
		       " </wsse:Security>"+
		   " </soap:Header>"+
		   "<soap:Body xmlns:ns2=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_po_approval_ws_pkg/get_approval_data/\">"+
		       " <ns2:InputParameters>"+
		          "  <ns2:P_TBL>"+
		       
		                "<ns2:P_TBL_ITEM>"+
		                    "<ns2:ACTION_CODE>APPROVE</ns2:ACTION_CODE>"+
		                    "<ns2:ACTION_DATE>2015-06-05</ns2:ACTION_DATE>"+
		                    "<ns2:EMPLOYEE_ID></ns2:EMPLOYEE_ID>"+
		                    "<ns2:EMPLOYEE_NUMBER>100040</ns2:EMPLOYEE_NUMBER>"+
		                    "<ns2:NOTE><p>bbbbbbbb</p>"+
		                    "</ns2:NOTE>"+
		                    "<ns2:OBJECT_ID></ns2:OBJECT_ID>"+
		                    "<ns2:PO_NUMBER>172</ns2:PO_NUMBER>"+
		                    "<ns2:OBJECT_REVISON_NUM>0</ns2:OBJECT_REVISON_NUM>"+
		                    "<ns2:OBJECT_TYPE_CODE>PO</ns2:OBJECT_TYPE_CODE>"+
		                    "<ns2:OBJECT_SUB_TYPE_CODE>STANDARD</ns2:OBJECT_SUB_TYPE_CODE>"+
		                    "<ns2:SEQUENCE_NUM>3</ns2:SEQUENCE_NUM>"+
		                "</ns2:P_TBL_ITEM>"+
		                "<ns2:P_TBL_ITEM>"+
		                    "<ns2:ACTION_CODE>APPROVE</ns2:ACTION_CODE>"+
		                    "<ns2:ACTION_DATE>2015-06-05</ns2:ACTION_DATE>"+
		                    "<ns2:EMPLOYEE_ID></ns2:EMPLOYEE_ID>"+
		                    "<ns2:EMPLOYEE_NUMBER>100040</ns2:EMPLOYEE_NUMBER>"+
		                    "<ns2:NOTE><p>dddddddddd</p>"+
		                        
		                    "</ns2:NOTE>"+
		                    "<ns2:OBJECT_ID></ns2:OBJECT_ID>"+
		                    "<ns2:PO_NUMBER>172</ns2:PO_NUMBER>"+
		                    "<ns2:OBJECT_REVISON_NUM>0</ns2:OBJECT_REVISON_NUM>"+
		                    "<ns2:OBJECT_TYPE_CODE>PO</ns2:OBJECT_TYPE_CODE>"+
		                    "<ns2:OBJECT_SUB_TYPE_CODE>STANDARD</ns2:OBJECT_SUB_TYPE_CODE>"+
		                    "<ns2:SEQUENCE_NUM>4</ns2:SEQUENCE_NUM>"+
		                "</ns2:P_TBL_ITEM>"+
		            "</ns2:P_TBL>"+
		        "</ns2:InputParameters>"+
		    "</soap:Body>"+
		"</soap:Envelope>";
		service.sendPost(url, params);
	}
	
}

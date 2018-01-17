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
     * ��ָ��URL����POST����������
     * 
     * @param url
     *            ���������URL
     * @param param
     *            ���������
     * @return 
     * 			������Զ����Դ����Ӧ���
     */
    public  static Result sendPost(String url, String params) {
    	Result result = new Result();
        BufferedReader in = null;
        HttpURLConnection connection = null; 
        
        new BaseBean().writeLog("���õ�ַ=��"+url+"    �������=��"+params);
        try {
            //String urlNameString = url+"?"+params;
            byte[] entitydata = params.toString().getBytes();//�õ�ʵ��Ķ���������
            // �򿪺�URL֮�������
            connection = (HttpURLConnection) (new URL(url)).openConnection();
            // ����ͨ�õ��������� 
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
            if(responseCode == 200){//���óɹ�
         
	        	InputStream inStrm = connection.getInputStream();
	        	
				// ��ȡ�ļ�����
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(inStrm,"UTF-8"));
				// ��ȡ�еķ�ʽ���ж�ȡ
				retStr = rd.readLine();
			
            }else{
            	retStr = "Զ�̵����쳣";
            }
            result.setResponseCode(responseCode);
            result.setResponseRet(retStr);
            System.out.println(retStr);
            System.out.println("���ش���=��"+responseCode+"    ��������=��"+retStr);
			new BaseBean().writeLog("���ش���=��"+responseCode+"    ��������=��"+retStr);
            
            /*
            
            // �������е���Ӧͷ�ֶ�
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // ���� BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }*/
        } catch (Exception e) {
        	result.setResponseCode(-999);
            result.setResponseRet("�����쳣");
            System.out.println("����Post��������쳣��" + e);
            e.printStackTrace();
        }
        // ʹ��finally�����ر�������
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
        
        this.writeLog("���õ�ַ=��"+url+"    �������=��"+params);
        try {
            //String urlNameString = url+"?"+params;
            byte[] entitydata = params.toString().getBytes();//�õ�ʵ��Ķ���������
            // �򿪺�URL֮�������
            connection = (HttpURLConnection) (new URL(url)).openConnection();
            // ����ͨ�õ��������� 
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
            if(responseCode == 200){//���óɹ�
         
	        	InputStream inStrm = connection.getInputStream();
	        	
				// ��ȡ�ļ�����
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(inStrm,"UTF-8"));
				// ��ȡ�еķ�ʽ���ж�ȡ
				retStr = rd.readLine();
			
            }else{
            	retStr = "Զ�̵����쳣";
            }
            result.setResponseCode(responseCode);
            result.setResponseRet(retStr);
            System.out.println(retStr);
			this.writeLog("���ش���=��"+responseCode+"    ��������=��"+retStr);
            
        } catch (Exception e) {
        	result.setResponseCode(-999);
            result.setResponseRet("�����쳣");
            System.out.println("����Post��������쳣��" + e);
            e.printStackTrace();
        }
        // ʹ��finally�����ر�������
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

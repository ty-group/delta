package com.delta;


import weaver.general.BaseBean;
import java.io.*;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import freemarker.template.*;

import java.io.StringWriter;
import java.net.*;
import java.util.*;
import org.springframework.web.util.HtmlUtils;
public class Webs_test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	
	
	
	
	
	public static void main(String[] args) throws IOException, TemplateException {
		Properties properties = System.getProperties();
		properties.setProperty("http.proxyHost", "10.11.9.70");
		properties.setProperty("http.proxyPort", "3128");
	//	properties.setProperty("http.proxyHost", "");
		//properties.setProperty("http.proxyPort", "");

		BufferedReader in = null;
		HttpURLConnection connection = null;

		
		
		
		String uri="aaa.xml";
		Configuration cfg = new Configuration();
		File files=new java.io.File("D:/YiLi/ecology/zdelta");
		cfg.setDirectoryForTemplateLoading(files);
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		Template template = cfg.getTemplate(uri);
		StringWriter sw = new StringWriter();
		template.process(new Object(), sw);
		String option111 = sw.getBuffer().toString();
		String url = "http://ebs.testing.deltahealth.com.cn:8040/webservices/SOAProvider/plsql/cux_inv_oa_apply_imp_ws/";

		byte[] entitydata = option111.toString().getBytes();//得到实体的二进制数据
		connection = (HttpURLConnection) (new URL(url)).openConnection();
		connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
		connection.setRequestProperty("SOAPAction", url);//cux_inv_apply_data_ws_pkg
		connection.setRequestProperty("Content-Length", String.valueOf(entitydata.length));

		connection.setRequestProperty("Connection", "Keep-Alive");
		connection.setRequestProperty("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");

		connection.setRequestProperty("Content-type", "text/xml;charset=GBK;");
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);

		OutputStream outStream = connection.getOutputStream();
		outStream.write(entitydata);
		outStream.flush();
		outStream.close();
		String retStr = "";
		int responseCode = 0;
		try {

			responseCode = connection.getResponseCode();
		} catch (Exception e) {

		}

		//InputStream inStrm = connection.getInputStream();
		String result = "";
		if (responseCode == 200) {//调用成功

			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line = "";

			while ((line = in.readLine()) != null) {
				result += line;
			}
		}
		
		
		System.out.println(option111);
		System.out.println(responseCode);

	}

}

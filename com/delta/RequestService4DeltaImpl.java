package com.delta;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import weaver.conn.RecordSet;
import weaver.general.BaseBean;
import weaver.general.Util;

/**
 * 2017-3-15 Created by Ink,tangyue Corp
 */
public class RequestService4DeltaImpl implements IRequestService4Delta {

	@Override
	public String createRequestAuto(String xml) {
		new BaseBean().writeLog("外部系统自动触发流程 ，原始报文---> "+xml);
		Document document = null;
		String code = "";
		try {
			document = RequestServiceUtil.getDocument(xml);
			NodeList nodelist = document.getElementsByTagName("request");
			if (nodelist.getLength() != 1) {
				code = "E009";
			} else {
				Node requestNode = nodelist.item(0);
				NodeList requestInfo = requestNode.getChildNodes();
				String workflowid = "";
				String creator = "";
				String requestid = "";
				String isNextNode = "";
				Element mainEle = null;
				Node detailTableEle = null;
				for (int i = 0; i < requestInfo.getLength(); i++) {
					Node requestInfoItemNode = requestInfo.item(i);
					if (requestInfoItemNode.getNodeType() == Node.ELEMENT_NODE) {
						Element requestInfoItemEle = (Element) requestInfoItemNode;
						if ("workflowid".equalsIgnoreCase(requestInfoItemEle.getNodeName())) {
							if(requestInfoItemEle.getFirstChild()==null){
								return RequestServiceResponseUtil.getResponse("E001", "工作流ID错误!");
							}
							workflowid = requestInfoItemEle.getFirstChild().getNodeValue();
						} else if ("creator".equalsIgnoreCase(requestInfoItemEle
								.getNodeName())) {
							if(requestInfoItemEle.getFirstChild()==null){
								return RequestServiceResponseUtil.getResponse("E005", "创建人错误!1");
							}
							creator = requestInfoItemEle.getFirstChild().getNodeValue();
						} else if ("requestid".equalsIgnoreCase(requestInfoItemEle
								.getNodeName())) {
							if(requestInfoItemEle.getFirstChild()!=null){
								requestid = requestInfoItemEle.getFirstChild().getNodeValue();
							}
						} else if ("isNextNode".equalsIgnoreCase(requestInfoItemEle
								.getNodeName())) {
							if(requestInfoItemEle.getFirstChild()!=null){
								isNextNode = requestInfoItemEle.getFirstChild().getNodeValue();
							}
						} else if ("main".equalsIgnoreCase(requestInfoItemEle.getNodeName())) {
							mainEle = requestInfoItemEle;
						} else if ("detailTable".equalsIgnoreCase(requestInfoItemEle
								.getNodeName())) {
							detailTableEle = requestInfoItemEle;
						}
					}
				}
				RequestServiceInfo4Delta rsi = new RequestServiceInfo4Delta();
				rsi.setCreator(creator);
				rsi.setWorkflowid(workflowid);
				rsi.setRequestid(requestid);
				rsi.setIsNextNode(isNextNode);
				NodeList mainNodeList = mainEle.getChildNodes();
				for (int i = 0; i < mainNodeList.getLength(); i++) {
					Node fieldNode = mainNodeList.item(i);
					if (fieldNode.getNodeType() == Node.ELEMENT_NODE) {
						String fieldName = fieldNode.getNodeName();
						if(fieldNode.getFirstChild()==null){
							String fieldValue = "";
							System.out.println(fieldName+":"+fieldValue);
							rsi.getMainMap().put(fieldName.toUpperCase(), fieldValue.trim());
						}else{
							String fieldValue = "";
							StringWriter sw = new StringWriter(); 
							Transformer  transformer = TransformerFactory.newInstance().newTransformer(); 
							transformer.transform( new DOMSource(fieldNode), new StreamResult(sw)); 
							fieldValue = sw.toString(); 
							fieldValue = fieldValue.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "").replace("<"+fieldName+">", "").replace("</"+fieldName+">", "");
							fieldValue = fieldValue.trim();
							if(fieldValue!=null){
								if(fieldValue.startsWith("<![CDATA[")){
									fieldValue = fieldValue.substring(9);
									fieldValue = fieldValue.substring(0,fieldValue.length()-3);
								}
								fieldValue = fieldValue.replaceAll("\"", "'").replaceAll("'", "");
								System.out.println(fieldName+":"+fieldValue);
								rsi.getMainMap().put(fieldName.toUpperCase(), fieldValue.trim());
							}
						}
					}
				}
				if (detailTableEle != null) {
					NodeList detailTableList = detailTableEle.getChildNodes();
					for (int i = 0; i < detailTableList.getLength(); i++) {
						Node dtNode = detailTableList.item(i);
						if (dtNode.getNodeType() == Node.ELEMENT_NODE) {
							Element dtEle = (Element) dtNode;
							String index = dtEle.getAttribute("index");
							NodeList rowsList = dtEle.getChildNodes();
							List<Map<String, String>> recordMapList = new ArrayList<Map<String, String>>();
							for (int j = 0; j < rowsList.getLength(); j++) {
								Node rowNode = rowsList.item(j);
								Map<String, String> dtRecordMap = new HashMap<String, String>();
								if (rowNode.getNodeType() == Node.ELEMENT_NODE) {
									NodeList fieldNodeList = rowNode
											.getChildNodes();
									for (int k = 0; k < fieldNodeList.getLength(); k++) {
										Node fieldNode = fieldNodeList.item(k);
										if (fieldNode.getNodeType() == Node.ELEMENT_NODE) {
											String fieldName = fieldNode
													.getNodeName();
											if(fieldNode.getFirstChild()==null){
												String fieldValue = "";
												System.out.println("\t"+fieldName+":"+fieldValue);
												dtRecordMap.put(fieldName.toUpperCase(), fieldValue.trim());
											}else{
												String fieldValue = "";
												StringWriter sw = new StringWriter(); 
												Transformer  transformer = TransformerFactory.newInstance().newTransformer(); 
												transformer.transform( new DOMSource(fieldNode), new StreamResult(sw)); 
												fieldValue = sw.toString(); 
												fieldValue = fieldValue.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "").replace("<"+fieldName+">", "").replace("</"+fieldName+">", "");
												fieldValue = fieldValue.trim();
												if(fieldValue!=null){
													if(fieldValue.startsWith("<![CDATA[")){
														fieldValue = fieldValue.substring(9);
														fieldValue = fieldValue.substring(0,fieldValue.length()-3);
													}
													fieldValue = fieldValue.replaceAll("\"", "'").replaceAll("'", "");
													System.out.println("\t"+fieldName+":"+fieldValue);
													dtRecordMap.put(fieldName.toUpperCase(), fieldValue.trim());
												}
											}
										}
									}
									recordMapList.add(dtRecordMap);
								}
							}
							rsi.getDetailMap().put(index, recordMapList);
						}
					}
				}
				code = rsi.execute();
				return code;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RequestServiceResponseUtil.getResponse("E009", e.getMessage());
		}
		return xml;
	}

	@Override
	public String getRequestInfoXML(String workflowid) {
		new BaseBean().writeLog("workflowid:" + workflowid);
		/*if(!"6596".equals(workflowid)){
			return RequestServiceResponseUtil.getResponse("E001", "工作流ID错误!");
		}*/
		Document ret = null;
		try {
			ret = RequestServiceUtil.getDocument(null);
			Element requestEle = ret.createElement("request");
			Element workflowEle = ret.createElement("workflowid");
			Element creatorEle = ret.createElement("creator");
			Element requestidEle = ret.createElement("requestid");
			Element isNextNodeEle = ret.createElement("isNextNode");
			Element mainEle = ret.createElement("main");
			Element detailTableEle = null;// ret.createElement("detailTable");
			workflowEle.appendChild(ret.createTextNode(workflowid));
			creatorEle.appendChild(ret.createTextNode("用户登录名"));
			isNextNodeEle.appendChild(ret.createTextNode("Y|N"));
			requestidEle.appendChild(ret.createTextNode("需要更新的流程ID，可以为空"));
			requestEle.appendChild(workflowEle);
			requestEle.appendChild(creatorEle);
			requestEle.appendChild(requestidEle);
			requestEle.appendChild(isNextNodeEle);
			RecordSet rs = new RecordSet();
			RecordSet rs1 = new RecordSet();
			rs.execute("select formid from workflow_base where id = "
					+ workflowid);
			if (rs.next()) {
				String billid = rs.getString("formid");
				String detailtable = "";
				Element ele = mainEle;
				rs.execute("select t1.id,t1.fieldname,t3.labelname,t1.fielddbtype,t1.type,t1.fieldhtmltype,t1.detailtable,t1.dsporder "
						+ " from workflow_billfield t1 "
						+ " left join HtmlLabelIndex t2 on t1.fieldlabel = t2.id "
						+ " left join HtmlLabelInfo t3 on t2.id = t3.indexid and t3.languageid=7 "
						+ " where billid = "
						+ billid
						+ " order by detailtable desc,dsporder");
				while (rs.next()) {
					String _detailtable = Util.null2String(rs
							.getString("detailtable"));
					String fieldname = Util.null2String(rs
							.getString("fieldname"));
					String labelname = Util.null2String(rs
							.getString("labelname"));
					String fielddbtype = Util.null2String(rs
							.getString("fielddbtype"));
					String type = Util.null2String(rs.getString("type"));
					String fieldhtmltype = Util.null2String(rs
							.getString("fieldhtmltype"));
					String fieldid = Util.null2String(rs.getString("id"));
					if (_detailtable.equals(detailtable)) {

					} else {
						if (detailTableEle == null) {
							detailTableEle = ret.createElement("detailTable");
						}
						Element detailEle = ret.createElement("detail");
						String index = _detailtable.replaceAll("formtable_main_"+billid.replaceAll("-", "")+"_dt","");
						detailEle.setAttribute("index", index);
						detailEle.setAttribute("rows", "1");
						Element RowEle = ret.createElement("row");
						detailEle.appendChild(RowEle);
						detailTableEle.appendChild(detailEle);
						detailtable = _detailtable;
						ele = RowEle;
					}
					Element fieldEle = ret.createElement(fieldname);
					String value = labelname;
					String dbtype = fielddbtype;
					if ("161".equals(type)) {
						dbtype = "varchar(1000)";
					}
					value += " " + dbtype;
					if ("5".equals(fieldhtmltype)) {
						rs1.execute("select * from workflow_SelectItem where fieldid = "
								+ fieldid + " order by listorder");
						value += "(";
						while (rs1.next()) {
							value += rs1.getString("selectvalue") + ":"
									+ rs1.getString("selectname") + " ";
						}
						value += ")";
					}
					fieldEle.appendChild(ret.createTextNode(value));
					ele.appendChild(fieldEle);
				}
				requestEle.appendChild(mainEle);
				if (detailTableEle != null) {
					requestEle.appendChild(detailTableEle);
				}
				ret.appendChild(requestEle);
			} else {
				return "error,无此流程！";
			}
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t;
			String xmlStr = null;
			t = tf.newTransformer();
			t.setOutputProperty("encoding", "UTF-8");// 解决中文问题，试过用GBK不行
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			t.transform(new DOMSource(ret), new StreamResult(bos));
			xmlStr = bos.toString();
			return xmlStr;
		} catch (Exception e) {
			new BaseBean().writeLog(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String xmlFile = "C:\\Users\\Ink\\Desktop\\垃圾文件\\xml.xml";
		String xml = loadFile(xmlFile);
		new RequestService4DeltaImpl().createRequestAuto(xml);
	}
	
	
	public static String loadFile(String fileName) {
		InputStream fis;
		try {
			fis = new FileInputStream(fileName);
			byte[] bs = new byte[fis.available()];
			fis.read(bs);
			String res = new String(bs, "utf8");
			fis.close();
			return res;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

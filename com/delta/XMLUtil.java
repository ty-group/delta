package com.delta;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;
import org.dom4j.tree.DefaultElement;

/**
 * xml������
 * @author chenli
 *
 */
public class XMLUtil {
	private Document doc = null;

	public XMLUtil(File file) throws DocumentException, MalformedURLException {
		SAXReader saxReader = new SAXReader();
		doc = saxReader.read(file);
	}

	public XMLUtil(String file) throws DocumentException,
			UnsupportedEncodingException {
		SAXReader saxReader = new SAXReader();
		doc = saxReader.read(new ByteArrayInputStream(file.getBytes("utf-8")));
	}
	


	/**
	 * 
	 * @param node
	 * @return
	 */
	public List<Map<String, String>> getListNode(String node){
		return this.getListNode("list", node);
	}
	/**
	 * ��ȡxml�ڵ�ֵ ���� &lt;SSO&gt; &lt;items&gt; &lt; item name='1' pwd='1'&gt;&lt;/ item &gt; &lt;/items&gt;&lt;/SSO&gt; ��ȡresultֵ
	 * ��firstNodeֵΪ: items, node��ֵΪ item;���� name=1 pwd=1 ��map����
	 * 
	 * @param pro
	 * @return
	 */
	public List<Map<String, String>> getListNode(String firstNode, String node) {
		if (node == null) {
			return new ArrayList<Map<String, String>>();
		}
		List<Map<String, String>> mapArray = new ArrayList<Map<String, String>>();
		Element element = doc.getRootElement();
		if (firstNode != null) {
			element = element.element(firstNode);
		}
		Iterator<Element> root = element.elementIterator(node);
		while (root.hasNext()) {
			Element ele = root.next();
			List<DefaultAttribute> att = ele.attributes();
			Map<String, String> map = new HashMap<String, String>();
			for (DefaultAttribute a : att) {
				map.put(a.getName(), a.getText());
			}
			mapArray.add(map);
		}
		return mapArray;
	}
	
	/**
	 * ��ȡxml�ڵ�ֵ ���� &lt;SSO&gt; &lt;name&gt;1&lt;/name&gt;&lt;password&gt;1&lt;/password&gt;&lt;/SSO&gt; ��ȡresultֵ
	 * ���� name=1 password=1 ��map
	 * 
	 * @param pro
	 * @return
	 */
	public Map<String, String> getMapNode() {
		Map<String, String> map  = new HashMap<String, String>();
		Element element = doc.getRootElement();
		List<DefaultElement> att = element.elements();
		for (DefaultElement ele : att) {
			map.put(ele.getName(), ele.getText());
		}
		return map;
	}

	/**
	 * ��ȡxml�ڵ�ֵ ���� &lt;SSO&gt; &lt; result &gt;0&lt;/ result &gt; &lt; result1 &gt;1&lt;/ result1 &gt;
	 * &lt;/SSO&gt; ��ȡresultֵ ����proֵΪ: result ���벻���ڷŻ�null
	 * 
	 * @param pro
	 * @return
	 */

	public String getProperty(String pro) {
		Element element = doc.getRootElement();
		if (pro == null)
			return null;
		System.out.println(element.asXML());
		

		
		String result = element.elementText(pro);
		return result;
	}

	/**
	 * ��ȡ���ڵ������
	 * @return
	 */
	public String getRootName(){
		Element element = doc.getRootElement();
		return (element == null)? null:element.getName();
	}
	
	/**
	 * ����XML ����Elemenet����
	 * 
	 * �磺&lt;?xml version="1.0" encoding="utf-8"?&gt;
	 *	&lt;sso&gt;
	 *		&lt;item att1="1" att2="2"&gt;&lt;/item&gt;
	 *	&lt;/sso&gt;
	 * @param rootname ��Element����
	 * @param itemName Elemenet����
	 * @param list  Elemenet�����б�
	 * @return
	 */
	public static String newAttrXML(String rootname,String itemName, List<Hashtable<String, String>> list){
		org.dom4j.Document doc=DocumentHelper.createDocument();
		//doc.setXMLEncoding("UTF-8");
	    org.dom4j.Element root=doc.addElement(rootname);
	    for(int i=0;i<list.size();i++){
	    	Hashtable<String, String> table=list.get(i);
	    	org.dom4j.Element itemEl=root.addElement(itemName);
	    	Enumeration<String> keys=table.keys();
	    	while(keys.hasMoreElements()){
	    		String key=keys.nextElement();
	    		itemEl.addAttribute(key, table.get(key));
	    	}
	    }
		return doc.asXML();
	}
	
	/**
	 * ����XML ������ֵ
	 * 
	 * �磺&lt;?xml version="1.0" encoding="utf-8"?&gt; &lt;sso&gt; &lt;returncode&gt;0&lt;/returncode&gt;
	 * &lt;newsysid&gt;2132132132132&lt;/newsysid&gt; //other �д�� other.put("newsysid",
	 * "2132132132132"); &lt;/sso&gt;
	 * 
	 * @param rootname
	 *            ��Element����
	 * @param other
	 *            other.put("newsysid", "2132132132132");
	 * @return
	 */
	public static String newRecXML(String rootname,
			Map<String, String> other) {
		org.dom4j.Document doc = DocumentHelper.createDocument();
		//doc.setXMLEncoding("UTF-8");
		org.dom4j.Element root = doc.addElement(rootname);
		if (other != null) {
			Set<Map.Entry<String, String>> er = other.entrySet();
			for (Map.Entry<String, String> entry : er) {
				root.addElement(entry.getKey()).addText(entry.getValue());
			}
		}
		return doc.asXML();
	}

	/**
	 * ��Ĭ�ϵ� rootname ����xml
	 * 
	 * @param other
	 * @return
	 */
	public static String newRecXML(Map<String, String> other) {
		return XMLUtil.newRecXML("sso", other);
	}

	/**
	 * ����XML ��ѯ�ӿڷ��ص�XML �磺&lt;?xml version="1.0" encoding="utf-8"?&gt; &lt;sso&gt; &lt;list&gt;
	 * &lt;item argid="" appid="" argname="" argfieldname="" argfieldvalue=""
	 * memo=""&gt;&lt;/item&gt; &lt;/list&gt; &lt;returncode&gt;0&lt;/returncode&gt; &lt;totalcount&gt;&lt;/totalcount&gt;
	 * &lt;totalpage&gt;&lt;/totalpage&gt; &lt;nowpage&gt;&lt;/nowpage&gt; &lt;/sso&gt;
	 * 
	 * @param rootname
	 *            ��Element����
	 * @param listname
	 *            list Element����
	 * @param itemName
	 *            list �е�Element���� �磺item
	 * @param item
	 *            item��List����,List�д��Hashtable����
	 * @param otherElem
	 *            ����Element
	 * @return
	 */
	public static String newListXML(String rootname, String listname,
			String itemName, List<Hashtable<String, String>> item,
			Hashtable<String, String> otherElem) {
		org.dom4j.Document doc = DocumentHelper.createDocument();
		//doc.setXMLEncoding("UTF-8");
		org.dom4j.Element root = doc.addElement(rootname);
		org.dom4j.Element list = root.addElement(listname);
		for (int i = 0; i < item.size(); i++) {
			org.dom4j.Element itemname = list.addElement(itemName);
			Hashtable<String, String> itemTab = item.get(i);
			Enumeration<String> er = itemTab.keys();
			while (er.hasMoreElements()) {
				String key = er.nextElement();
				itemname.addAttribute(key, itemTab.get(key));
			}
		}
		Enumeration<String> erout = otherElem.keys();
		while (erout.hasMoreElements()) {
			String key = erout.nextElement();
			root.addElement(key).addText(otherElem.get(key));
		}
		return doc.asXML();
	}

	/**
	 * ��Ĭ�� rootname=sso listname=list item=item ������ѯxml
	 * 
	 * @param item
	 * @param otherElem
	 * @return
	 */
	public static String newListXML(List<Hashtable<String, String>> item,
			Hashtable<String, String> otherElem) {
		return XMLUtil.newListXML("sso", "list", "item", item, otherElem);
	}

	/**
	 * 
	 * @param pro
	 * @return
	 */
	public String get2Property(String pro) {
		Element element = doc.getRootElement();
		if (pro == null)
			return null;
		//System.out.println(element.asXML());
		Element temp = (Element)element.elements().get(1);
		temp = (Element)temp.elements().get(0);

		
		String result = temp.elementText(pro);
		return result;
	}
	
	/**
	 * 
	 * @param pro
	 * @return
	 */
	public String get3Property(String pro) {
		Element element = doc.getRootElement();
		if (pro == null)
			return null;
		//System.out.println(element.asXML());
		Element temp = (Element)element.elements().get(1);
		temp = (Element)temp.elements().get(0);
		temp = (Element)temp.elements().get(0);
		temp = (Element)temp.elements().get(0);
		
		String result = temp.elementText(pro);
		return result;
	}
	
	/**
	 * 
	 * @param pro
	 * @return
	 */
	public List get4Property() {
		Element element = doc.getRootElement();
		//if (pro == null)
			//return null;
		//System.out.println(element.asXML());
		Element temp = (Element)element.elements().get(0);
		temp = (Element)temp.elements().get(0);
		temp = (Element)temp.elements().get(1);
		//System.out.println(temp.getName());
		//temp = (Element)temp.elements().get(1);
		
		
		//temp = (Element)
		return temp.elements();//.get(0);
		//String result = temp.elementText(pro);
		//return result;
	} 
	

/*	
	public static void main(String[] args) throws Exception {


		String a = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"><env:Header/><env:Body><OutputParameters xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://xmlns.oracle.com/apps/cux/soaprovider/plsql/cux_inv_apply_data_ws_pkg/get_doc_number/\"><X_STATUS>E</X_STATUS><X_MESSAGE>CUX_INV_APPLY_DOCNUMBER (FND_ERROR_LOCATION_FIELD=) (FND_MESSAGE_TYPE=E)</X_MESSAGE></OutputParameters></env:Body></env:Envelope>";
		XMLUtil xml = new XMLUtil(a);
		
		System.out.println(xml.getProperty("env:Body"));
		System.out.println(xml.getRootName());
//		List<Map<String, String>> mapArray = xml.getListNode("item");
//		for (Map<String, String> map : mapArray) {
//			System.out.println(map.get("k"));
//		}
		

	}*/
}
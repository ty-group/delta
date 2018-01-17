package com.delta;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 2017-3-15
 *Created by Ink,tangyue Corp 
 */
public class RequestServiceUtil {

	public static Document getDocument(String xml) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = null;
		if(null==xml){
			d = db.newDocument();
		}else{
			d =  db.parse(new InputSource(new StringReader(xml)));
		}
		return d;
		
	}
	
}

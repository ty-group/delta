package com.delta;
/**
 * 2017-3-16
 *Created by Ink,tangyue Corp 
 */
public class RequestServiceResponseUtil {

	public static String getResponse(String code,String message){
		String ret = "<?xml version='1.0' encoding='UTF-8'?>";
		ret +="<response><head>"+(code.startsWith("E")?"F":"S")+"</head><code>"+code+"</code><message>"+message+"</message></response>";
		return ret;
	}
}

package com.delta.action;

import java.io.UnsupportedEncodingException;

public class StrUtil { 

	
	
    public static String subStringByByte(String str, int len) throws UnsupportedEncodingException {
        String result = null;
        if (str != null) {
            byte[] a = str.getBytes("GBK");
            if (a.length <= len) {
                result = str;
            } else if (len > 0) {
                result = new String(a, 0, len);
                int length = result.length();
                if (str.charAt(length - 1) != result.charAt(length - 1)) {
                    if (length < 2) {
                        result = null;
                    } else {
                        result = result.substring(0, length - 1);
                    }
                }
            } 
        }
        return result;
    }
    
	/**
	 * 替换nbsp;
	 * @param inString
	 * @return
	 */
	public static String repNbsp(String inString) {
		if (inString == null || "".equals(inString)) {
			return "";
		} else {

			return inString.replace("&nbsp;", " ");
		}
	}
	
 
}

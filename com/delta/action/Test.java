package com.delta.action;

import java.math.BigDecimal;

import weaver.general.Util;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value="1,000.00";
	
		value=value.replace(",", "");
		
		
		double sqsl = 1.00; 
		
		sqsl =  Util.getDoubleValue(value, 0.00);
		 double hsdj = 0.011; 
		BigDecimal   b   =   new   BigDecimal(sqsl*hsdj);  
		double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
		System.out.println(f1);

	}

}

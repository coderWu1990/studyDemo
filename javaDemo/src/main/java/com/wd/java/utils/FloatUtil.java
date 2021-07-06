/**
 * 
 */
package com.wd.java.utils;

import java.text.DecimalFormat;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2020-12-8 下午6:10:44 <br/>
 * 
 */
public class FloatUtil {

	public static String getFloat2(float value) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(value);
	}
}

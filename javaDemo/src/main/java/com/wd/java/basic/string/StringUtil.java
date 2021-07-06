package com.wd.java.basic.string;

public class StringUtil {

	/**
	 * 自动补0
	 * 
	 * @return 00025
	 */
	public static String getString1() {
		return String.format("%05d", 25);
	}

	/**
	 * 子串
	 * 
	 * @return 123
	 */
	public static String getString2() {
		return "12345".substring(0, 3);
	}
	
	/**
	 * 子串
	 * 
	 * @return 23
	 */
	public static String getString3() {
		return "12345".substring(1, 3);
	}

	/**
	 * 子串
	 * 
	 * @return 45
	 */
	public static String getString4() {
		return "12345".substring(3);
	}
}

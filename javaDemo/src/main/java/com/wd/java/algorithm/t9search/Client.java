/**
 * 
 */
package com.wd.java.algorithm.t9search;

import com.wd.java.algorithm.t9search.lib.T9Matcher;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-4-14 下午12:26:47 <br/> 
 * 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t9Key=T9SearchSupport.buildT9Key("吴迪");
		System.out.println("t9Key="+t9Key);
		System.out.println(T9Matcher.matches(t9Key, "93"));;
	}

}

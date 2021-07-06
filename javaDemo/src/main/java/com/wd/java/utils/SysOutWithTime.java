/**
 * 
 */
package com.wd.java.utils;


/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-2 下午9:04:09 <br/> 
 *
 */
public class SysOutWithTime {

	public static void print(String str){
		System.out.println(TimeUtil.getDeviceTimeOfSSS()+":"+str);
	}
}

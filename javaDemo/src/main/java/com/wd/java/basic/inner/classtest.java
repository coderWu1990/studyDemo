/**
 * 
 */
package com.wd.java.basic.inner;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-19 下午5:15:50 <br/> 
 *
 */
public class classtest {
	private String name="hahha";
	
	//静态内部类
	public static class Inner{
		
	}
	
	//非静态内部类
	public class InnerNon{	
		public void set(){
			name="xx";
		}
	}
}

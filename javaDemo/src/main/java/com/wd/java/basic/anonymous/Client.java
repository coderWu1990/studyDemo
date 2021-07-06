/**
 * 
 */
package com.wd.java.basic.anonymous;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-25 下午12:17:29 <br/> 
 * 匿名类
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Animals() {
			@Override
			public void eat() {
				System.out.println("自己吃");
			}
		}.eat();
	}

}

/**
 * 
 */
package com.wd.java.basic.anonymous;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-25 下午12:11:01 <br/>
 * 
 */
public class AnonymousClass {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 匿名内部类使用局部变量是通过自己维护的成员变量，因为无法保证内部类的成员变量与外部局部变量的数据同步，
		// 所以使用final修饰，使局部变量的值不可改变
		final String str = "haha";
		new Thread() {
			@Override
			public void run() {
				System.out.println(str);
			}
		}.start();

	}

}

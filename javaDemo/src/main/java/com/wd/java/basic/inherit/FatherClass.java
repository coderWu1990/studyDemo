/**
 * 
 */
package com.wd.java.basic.inherit;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-3 下午7:17:16 <br/>
 * 
 */
public class FatherClass {
	private int i = 0;
	private String name;

	/**
	 * 父类无参构造
	 */
	FatherClass() {
		System.out.println("--父类无参构造--");
	}

	/**
	 * 父类带参构造
	 * 
	 * @param name
	 */
	FatherClass(String name) {
		this.name = name;
		System.out.println("--父类带参构造--" + this.name);
	}

	/**
	 * 父类静态代码块
	 */
	static {
		System.out.println("--父类的静态代码块--");
	}
	/**
	 * 父类非静态代码块
	 */
	{
		++i;
		System.out.println("--父类的非静态代码块--" + i);
	}

	/**
	 * 父类的方法
	 */
	public void speak() {
		System.out.println("--父类的方法--");

	}

	// 加入一个main程序后
	public static void main(String[] args) {
		System.out.println("--父类主程序--");
		FatherClass father = new FatherClass("父类");
		father.speak();
	}
}

/**
 * 
 */
package com.wd.java.design.designmode.build;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-18 下午3:21:41 <br/> 
 *
 */
public class AppBuild {

	private String name;
	private int age;
	
	public AppBuild() {
		super();
	}
	
	public AppBuild setName(String name){
		this.name=name;
		return this;
	}
	
	public AppBuild setAge(int age){
		this.age=age;
		return this;
	}

	@Override
	public String toString() {
		return "AppBuild [name=" + name + ", age=" + age + "]";
	}
	
	
	
}

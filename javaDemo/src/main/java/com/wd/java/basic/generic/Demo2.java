/**
 * 
 */
package com.wd.java.basic.generic;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-2 下午7:53:55 <br/> 
 *
 */
public class Demo2 {

	public static void main(String[] args){
		Demo2 d=new Demo2();
		
		System.out.println(d.getListOne("haha"));
		
		System.out.println("ss="+d.getListTwo(new Person("wanhu", 30)));
	}
	
	public <T> T getListOne(T t){
		return t;
		
	}
	
	public <T> T getListTwo(Person a){
		return (T) a;
		
	}
}

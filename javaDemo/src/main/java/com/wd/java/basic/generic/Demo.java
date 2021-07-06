/**
 * 
 */
package com.wd.java.basic.generic;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-2 下午7:49:30 <br/> 
 *
 */
public class Demo<T> {
	
	public static void main(String[] args){
		Demo<String> d1=new Demo<>();
		System.out.println(d1.getListFrist("haha"));
		Demo<Integer> d2=new Demo<>();
		System.out.println(d2.getListFrist(3));
	}
	
	private T getListFrist(T data){
		return data;
		
	}

}

package com.wd.java.design.designmode.prototype;

import java.util.ArrayList;

/**
 * Object类提供 的方法clone只是拷贝本对象， 其对象内部的数组、 引用对象等都不拷贝(浅拷贝) 
 * 深拷贝
 * 
 * @author ZH-SW-Wudi
 * 
 */
public class Thing implements Cloneable {

	private ArrayList<String> list = new ArrayList<>();

	@Override
	protected Object clone() {
		Thing thing = null;
		try {
			thing = (Thing) super.clone();
			thing.list = (ArrayList<String>) this.list.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thing;
	}
}

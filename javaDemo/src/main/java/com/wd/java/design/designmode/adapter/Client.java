package com.wd.java.design.designmode.adapter;

/**
 * 适配器模式是一个补偿模式， 或者说是一个“补救”模式， 通常用来解决接口不相容的问 题
 * 
 * @author ZH-SW-Wudi
 * 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Dinner dinner=new Adapter();
		Dinner dinner=new SouthDinner();
		dinner.eat();
	}

}

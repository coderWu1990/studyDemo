package com.wd.java.design.designmode.interpreter;

import java.util.HashMap;

public class Client {

	/**
	 * 解释器模式 （给定一门语言， 定义 它的文法的一种表示， 并定义一个解释器， 该解释器使用该表示来解释语言中的句子
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expStr = "a+b-c";
		Calculator cal = new Calculator(expStr);
		HashMap<String, Integer> var = new HashMap<String, Integer>();
		var.put("a", 10);
		var.put("b", 23);
		var.put("c", 2);
		System.out.println("运算结果为： " + expStr + "=" + cal.run(var));
	}

}

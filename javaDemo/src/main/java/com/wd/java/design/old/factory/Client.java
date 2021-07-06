package com.wd.java.design.old.factory;

/**
 * @describe 调用类
 */
public class Client {

	public static void main(String[] args) {
		// 创建工厂
		Factory factory = new ConcreteFactory();
		// 创建产品
		Product product = factory.CreateProuct(2);
		// 调用产品的方法
		product.method();
	}
}

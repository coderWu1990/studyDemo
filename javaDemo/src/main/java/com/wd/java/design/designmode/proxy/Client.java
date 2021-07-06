package com.wd.java.design.designmode.proxy;

public class Client {

	/**
	 * 代理模式，动态代理
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject subject=new RealSubject();
		Subject proxy=SubjectDynamicProxy.newProxyInstance(subject);
		proxy.doSomething("haha");
	}

}

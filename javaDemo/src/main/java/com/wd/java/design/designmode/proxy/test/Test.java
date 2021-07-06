package com.wd.java.design.designmode.proxy.test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAction proxy=new ConcreteAction(); 
		//IAction action=new ActionProxy(proxy);
		IAction action=DynamicProxy.newInstance(proxy);
		action.action();
	}

}

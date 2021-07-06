package com.wd.java.design.designmode.proxy.test;

public class ActionProxy implements IAction{
	
	private IAction concrete;
	
	public ActionProxy(IAction action) {
		super();
		this.concrete = action;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("通过代理");
		this.concrete.action();
	}

}

package com.wd.java.design.designmode.handler;

public class Son extends Handler{

	public Son() {
		super(3);
		// TODO Auto-generated constructor stub
	}

	@Override
	void response() {
		System.out.println("儿子同意了");
	}

}

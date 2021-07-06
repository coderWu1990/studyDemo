package com.wd.java.design.designmode.handler;

public class Father extends Handler{

	public Father() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	void response() {
		System.out.println("爸爸同意了");
	}

}

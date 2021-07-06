package com.wd.java.design.designmode.handler;

public class Women implements Iwomen {
	private int type;
	private String request;

	public Women(int type, String request) {
		super();
		this.type = type;
		this.request = request;
		// 为了便于显示， 在这里做了点处理
		switch (this.type) {
		case 1:
			this.request = "女儿的请求是： " + request;
			break;
		case 2:
			this.request = "妻子的请求是： " + request;
			break;
		case 3:
			this.request = "母亲的请求是： " + request;
		}
		System.out.println("type="+type+" "+this.request);
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public String getRequest() {
		// TODO Auto-generated method stub
		return this.request;
	}

}

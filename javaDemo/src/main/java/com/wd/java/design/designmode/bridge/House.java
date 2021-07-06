package com.wd.java.design.designmode.bridge;

public class House implements Product{

	@Override
	public void beProduct() {
		// TODO Auto-generated method stub
		System. out. println( "生产出的房子是这样的. . . " ) ;
	
	}

	@Override
	public void beSell() {
		// TODO Auto-generated method stub
		System. out. println( "生产出的房子卖出去了. . . " ) ;
	}

}

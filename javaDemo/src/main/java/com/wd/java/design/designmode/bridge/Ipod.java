package com.wd.java.design.designmode.bridge;

public class Ipod implements Product{

	@Override
	public void beProduct() {
		// TODO Auto-generated method stub
		System. out. println( "生产出的iPod是这样的. . . " ) ;
	
	}

	@Override
	public void beSell() {
		// TODO Auto-generated method stub
		System. out. println( "生产出的iPod卖出去了. . . " ) ;
	}

}

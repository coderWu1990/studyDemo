package com.wd.java.design.designmode.bridge;

public class HouseCorp extends Crop{

	public HouseCorp(Product product) {
		super(product);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMoney() {
		// TODO Auto-generated method stub
		super. makeMoney( ) ;
		System. out. println( "房地产公司赚大钱了. . . " ) ;
	}

}

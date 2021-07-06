package com.wd.java.design.designmode.bridge;

public class ShanZhaiCorp extends Crop {

	public ShanZhaiCorp(Product product) {
		super(product);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMoney() {
		// TODO Auto-generated method stub
		super.makeMoney();
		System.out.println("我赚钱呀. . . ");
	}

}

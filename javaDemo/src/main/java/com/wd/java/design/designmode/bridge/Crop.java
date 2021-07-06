package com.wd.java.design.designmode.bridge;

public abstract class Crop {
	Product product;

	public Crop(Product product) {
		super();
		this.product = product;
	}

	public void makeMoney() {
		this.product.beProduct();
		// 然后销售
		this.product.beSell();
	};

}

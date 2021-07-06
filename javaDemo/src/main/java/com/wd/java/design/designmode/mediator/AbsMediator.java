package com.wd.java.design.designmode.mediator;

public abstract class AbsMediator {
	protected Purchase purchase;
	protected Sale sale;
	protected Stock stock;

	// 构造函数
	public AbsMediator() {
	}
	
	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public abstract void execute(String str, Object obj);
}

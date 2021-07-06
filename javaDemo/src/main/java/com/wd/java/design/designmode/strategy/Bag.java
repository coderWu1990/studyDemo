package com.wd.java.design.designmode.strategy;

public class Bag {

	private Strategy strategy;
	public Bag(Strategy strategy){
		this.strategy=strategy;
	}
	
	public void action(){
		this.strategy.operate();
	}
}

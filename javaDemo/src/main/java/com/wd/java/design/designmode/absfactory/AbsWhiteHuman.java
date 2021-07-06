package com.wd.java.design.designmode.absfactory;

public abstract class AbsWhiteHuman implements Human{

	@Override
	public void getColor() {
		// TODO Auto-generated method stub
		System.out.println("白色");
	}
	
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("说英语");
	}
}




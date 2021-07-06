package com.wd.java.design.designmode.absfactory;

public class FemaleHumanFactory implements HumanFactory{

	@Override
	public Human createWhiteHuman() {
		// TODO Auto-generated method stub
		return new FemaleWhiteHuman();
	}

	@Override
	public Human createYellowHuman() {
		// TODO Auto-generated method stub
		return new FemaleYellowHuman();
	}

	

}

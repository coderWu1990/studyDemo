package com.wd.java.design.designmode.build;

import java.util.ArrayList;

public class BenzBuilder implements CarBuilder{

	private CarModel carModel=new BenzModel();
	
	@Override
	public void setSequence(ArrayList<String> list) {
		// TODO Auto-generated method stub
		this.carModel.setSequence(list);
	}

	@Override
	public CarModel getCarModel() {
		// TODO Auto-generated method stub
		return this.carModel;
	}

}

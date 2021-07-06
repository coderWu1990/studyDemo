package com.wd.java.design.designmode.build;

import java.util.ArrayList;

public class BMWBuilder implements CarBuilder{

	private CarModel carModel=new BMWModel();
	
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

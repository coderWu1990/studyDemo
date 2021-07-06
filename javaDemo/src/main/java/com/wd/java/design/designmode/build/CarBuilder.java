package com.wd.java.design.designmode.build;

import java.util.ArrayList;

public interface CarBuilder {

	void setSequence(ArrayList<String> list);
	
	CarModel getCarModel();
}

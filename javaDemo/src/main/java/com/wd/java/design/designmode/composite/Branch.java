package com.wd.java.design.designmode.composite;

import java.util.ArrayList;

public class Branch extends Corp{
	private ArrayList<Corp> subordinateList = new ArrayList<Corp>( ) ;
	
	public Branch(String _name, String _position, int _salary) {
		super(_name, _position, _salary);
		// TODO Auto-generated constructor stub
	}

	public void addSubordinate(Corp corp){
		subordinateList.add(corp);
		corp.setParent(this);
	};
	
	public ArrayList<Corp> getSubordinate(){
		return subordinateList;
	}

}

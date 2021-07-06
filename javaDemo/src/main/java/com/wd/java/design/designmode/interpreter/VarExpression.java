package com.wd.java.design.designmode.interpreter;

import java.util.HashMap;

public class VarExpression extends Expression {

	private String key;

	public VarExpression(String _key) {
		this.key = _key;
	}

	@Override
	public int interpreter(HashMap<String, Integer> val) {
		// TODO Auto-generated method stub
		return val.get(key);
	}

	@Override
	public String toString() {
		return "VarExpression [key=" + key + "]";
	}
	
	

}

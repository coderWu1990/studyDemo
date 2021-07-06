package com.wd.java.design.designmode.interpreter;

import java.util.HashMap;

public class SubExpression extends SymbolExpression{

	public SubExpression(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int interpreter(HashMap<String, Integer> val) {
		// TODO Auto-generated method stub
		return super.left.interpreter(val)-super.right.interpreter(val);
	}

	@Override
	public String toString() {
		return "SubExpression [left=" + left + ", right=" + right + "]";
	}

	
}

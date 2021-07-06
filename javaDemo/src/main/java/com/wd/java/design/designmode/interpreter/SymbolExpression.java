package com.wd.java.design.designmode.interpreter;

public abstract class SymbolExpression extends Expression {

	protected Expression left;
	protected Expression right;

	public SymbolExpression(Expression left, Expression right) {
		super();
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "SymbolExpression [left=" + left + ", right=" + right + "]";
	}
	
	
}

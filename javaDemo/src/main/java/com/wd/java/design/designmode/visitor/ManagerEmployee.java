package com.wd.java.design.designmode.visitor;

public class ManagerEmployee extends Employee{

	String performance;

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	@Override
	void accept(Ivisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
	
}

package com.wd.java.design.designmode.visitor;

public class CommonEmployee extends Employee{

	String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	void accept(Ivisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
	
}

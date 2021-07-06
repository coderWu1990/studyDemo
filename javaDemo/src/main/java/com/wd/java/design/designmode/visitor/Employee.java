package com.wd.java.design.designmode.visitor;

public abstract class Employee {

	private int salary;
	private String name;
	private String sex;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	abstract void accept(Ivisitor visitor);
}

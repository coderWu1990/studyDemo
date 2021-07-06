package com.wd.java.design.designmode.visitor;

public class TotalVisitor implements ITotalVisitor{

	private int total;
	
	@Override
	public void visit(CommonEmployee commonEmployee) {
		// TODO Auto-generated method stub
		total+=commonEmployee.getSalary()*2;
	}

	@Override
	public void visit(ManagerEmployee managerEmployee) {
		// TODO Auto-generated method stub
		total+=managerEmployee.getSalary()*5;
	}

	@Override
	public void totalSalary() {
		// TODO Auto-generated method stub
		System.out.println("total="+total);
	}

}

package com.wd.java.design.designmode.visitor;

public interface Ivisitor {

	void visit(CommonEmployee commonEmployee);
	
	void visit(ManagerEmployee managerEmployee);
	
}

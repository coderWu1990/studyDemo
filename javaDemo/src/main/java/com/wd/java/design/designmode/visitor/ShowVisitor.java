package com.wd.java.design.designmode.visitor;

public class ShowVisitor implements IShowVisitor{

	private String report="";
	
	@Override
	public void visit(CommonEmployee commonEmployee) {
		// TODO Auto-generated method stub
		report+=getBaseReport(commonEmployee);
		report+="job="+commonEmployee.getJob()+"\n";
	}

	@Override
	public void visit(ManagerEmployee managerEmployee) {
		// TODO Auto-generated method stub
		report+=getBaseReport(managerEmployee);
		report+="Performance="+managerEmployee.getPerformance()+"\n";
	}

	@Override
	public void report() {
		// TODO Auto-generated method stub
		System.out.println(report);
	}
	
	private String getBaseReport(Employee employee){
		String info="name="+employee.getName()+" ";
		info+="salary="+employee.getSalary()+" ";
		info+="sex="+employee.getSex()+" ";
		return info;
	}

}

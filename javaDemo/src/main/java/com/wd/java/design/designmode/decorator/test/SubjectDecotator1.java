package com.wd.java.design.designmode.decorator.test;

public class SubjectDecotator1 implements ISubject{

	private ISubject iSubject;
	
	
	
	public SubjectDecotator1(ISubject iSubject) {
		super();
		this.iSubject = iSubject;
	}



	@Override
	public void action() {
		// TODO Auto-generated method stub
		
		this.iSubject.action();
		System.out.println("装修2");
	}

}

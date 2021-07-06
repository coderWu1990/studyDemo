package com.wd.java.design.designmode.decorator.test;

public class SubjectDecotator2 implements ISubject{

	private ISubject iSubject;
	
	
	
	public SubjectDecotator2(ISubject iSubject) {
		super();
		this.iSubject = iSubject;
	}



	@Override
	public void action() {
		// TODO Auto-generated method stub
		System.out.println("装修1");
		this.iSubject.action();
	}

}

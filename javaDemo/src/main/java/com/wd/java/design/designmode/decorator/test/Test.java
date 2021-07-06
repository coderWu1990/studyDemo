package com.wd.java.design.designmode.decorator.test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISubject subject=new ConcreteSubject();
		SubjectDecotator1 decotator1=new SubjectDecotator1(subject);
		SubjectDecotator2 decotator2=new SubjectDecotator2(decotator1);
		decotator2.action();
	}

}

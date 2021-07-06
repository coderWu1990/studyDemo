package com.wd.java.design.designmode.observer;

public class ConcreteSubject extends Subject {

	public void doSomething() {
		/*
		 * do something
		 */
		System.out.println("被观察者做事了");
		super.notifyChange();
	}

}

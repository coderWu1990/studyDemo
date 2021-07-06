package com.wd.java.design.designmode.observer;

public class Client {

	/**
	 * 观察者和被观察者之间是抽象耦合 如此设计， 则不管是增加观察者还是被观察者都非常容易扩展
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 创建一个被观察者
		ConcreteSubject subject = new ConcreteSubject();
		// 定义一个观察者
		Observer obs = new ConcreteObserver();
		// 观察者观察被观察者
		subject.attach(obs);
		// 观察者开始活动了
		subject.doSomething();
	}

}

package com.wd.java.design.designmode.decorator;

public class ConcreteDecorator1 extends Decorator {
	// 定义被修饰者
	public ConcreteDecorator1(Component _component) {
		super(_component);
	}

	// 定义自 己的修饰方法
	private void method1() {
		System.out.println(" method1 修饰");
	}

	// 重写父类的Operation方法
	public void operate() {
		this.method1();
		super.operate();
	}
}

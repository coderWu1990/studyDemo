package com.wd.java.design.designmode.decorator;

/**
 * 装饰类和被装饰类可以独立发展， 而不会相互耦合。 换句话说， Component类无须知 道Decorator类，
 * Decorator类是从外部来扩展Component类的功能， 而Decorator也不用知道具 体的构件。
 * 
 * @author ZH-SW-Wudi
 * 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Component component = new ConcreteComPonent();
		// 第一次修饰
		component = new ConcreteDecorator1(component);
		// 第二次修饰
		component = new ConcreteDecorator2(component);
		// 修饰后运行
		component.operate();
	}

}

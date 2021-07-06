package com.wd.java.design.old.factory;

/**
 * @describe 抽象工厂类的具体实现方法
 */
public class ConcreteFactory extends Factory {

	@Override
	public Product CreateProuct(int type) {
		if (type == 1) {
			return new ConcreteProductA();
		} else {
			return new ConcreteProductB();
		}

	}
}
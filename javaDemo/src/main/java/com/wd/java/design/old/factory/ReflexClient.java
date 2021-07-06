package com.wd.java.design.old.factory;

public class ReflexClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReflexFactory factory=new ReflexConCreateFactory();
		Product product=factory.createFactory(ConcreteProductB.class);
		product.method();
	}

}

package com.wd.java.design.old.factory;

public class ReflexConCreateFactory extends ReflexFactory{

	@Override
	public <T extends Product> T createFactory(Class<T> cls) {
		Product p=null;
		try {
			p=(Product)Class.forName(cls.getName()).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) p;
	}

}

package com.wd.java.design.old.factory;

public abstract class ReflexFactory {

	public abstract <T extends Product> T createFactory(Class<T> cls);
}

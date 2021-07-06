package com.wd.java.design.old.factory;

/**
 * @describe 抽象工厂类
 */
public abstract class Factory {

	/**
	 * 抽象工厂类方法
	 * 
	 * @return
	 */
	public abstract Product CreateProuct(int type);
}
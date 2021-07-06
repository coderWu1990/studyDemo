package com.wd.java.design.designmode.strategy;

/**
 * 算法可以自 由切换 这是策略模式本身定义的， 只要实现抽象策略， 它就成为策略家族的一个成员， 通过封 装角色对其进行封装， 保证对外提供“可自
 * 由切换”的策略。
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
		Strategy strategy=null;
		Bag zhaoyun=null;
		
		strategy=new BackDoor();
		zhaoyun=new Bag(strategy);
		zhaoyun.action();
		
		strategy=new GiveGreenLight();
		zhaoyun=new Bag(strategy);
		zhaoyun.action();
		
		strategy=new BlockEnemy();
		zhaoyun=new Bag(strategy);
		zhaoyun.action();
	}

}

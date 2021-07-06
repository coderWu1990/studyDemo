package com.wd.java.design.designmode.handler;

import java.util.Random;

/**
 * 责任链模式非常显著的优点是将请求和处理分开。 请求者可以不用知道是谁处理的， 处 理者可以不用知道请求的全貌（例如在J2EE项目 开发中，
 * 可以剥离出无状态Bean由责任链处 理） ， 两者解耦， 提高系统的灵活性。 
 * 16.3.2 责任链模式的缺点 责任链有两个非常显著的缺点： 一是性能问题，
 * 每个请求都是从链头遍历到链尾， 特别 是在链比较长的时候， 性能是一个非常大的问题。 二是调试不很方便， 特别是链条比较长， 环节比较多的时候，
 * 由于采用了类似递归的方式， 调试的时候逻辑可能比较复杂。
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

		// 定义三个请示对象
		Handler father = new Father();
		Handler husband = new Husband();
		Handler son = new Son();
		// 设置请示顺序
		father.setNext(husband);
		husband.setNext(son);
		// 随机挑选几个女性
		Random rand = new Random();
		for (int i = 0; i < 5; i++) {
			father.handlerMsg(new Women(rand.nextInt(4), "我要出去逛街"));
		}

	}
}

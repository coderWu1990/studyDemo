package com.wd.java.design.designmode.build;

public class Client {
	public static void main(String[] args) {
		Director director = new Director();
		// 1万辆A类型的奔驰车
		for (int i = 0; i < 10; i++) {
			director.getABenzModel().run();
		}
		for (int i = 0; i < 100; i++) {
			director.getBBenzModel().run();
		}
		// 1000万辆C类型的宝马车
		for (int i = 0; i < 10; i++) {
			director.getCBMWModel().run();
		}
	}
}

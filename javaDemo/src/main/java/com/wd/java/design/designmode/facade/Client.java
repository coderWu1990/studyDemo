package com.wd.java.design.designmode.facade;

public class Client {

	/**
	 * 门面模式注重“统一的对象”， 也就是提供一个访问子系统的接口， 除了这个接口不允许 有任何访问子系统的行为发生
	 * 减少系统的相互依赖
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PostOffice office = new PostOffice();
		office.sendLetter("生活愉快", "wd.com");
	}

}

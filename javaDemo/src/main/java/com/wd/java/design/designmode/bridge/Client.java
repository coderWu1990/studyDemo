package com.wd.java.design.designmode.bridge;

public class Client {

	/**
	 * 桥梁模式 将抽象和 实现解耦， 使得两者可以独立地变化
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HouseCorp houseCorp=new HouseCorp(new House());
		houseCorp.makeMoney();
		
		ShanZhaiCorp shanZhaiCorp=new ShanZhaiCorp(new Ipod());
		shanZhaiCorp.makeMoney();
	}

}

package com.wd.java.design.designmode.mode;

public class Client {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbsHummer hummer1=new HummerH1();
		hummer1.run();
		AbsHummer hummer2=new HummerH2();
		hummer2.run();
	}

}

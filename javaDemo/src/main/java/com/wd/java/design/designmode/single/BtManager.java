package com.wd.java.design.designmode.single;

public class BtManager {

	private BtManager(){
		
	}
	
	public static BtManager getInstance(){
		return Inner.instance;
	}
	
	private static class Inner{
		private static BtManager instance=new BtManager();
	}
}

package com.wd.java.design.designmode.mode;

public abstract class AbsHummer {

	protected abstract void start();
	
	protected abstract void stop();
	
	protected abstract void engineBoom();
	
	protected abstract void alarm();
	
	protected void run(){
		start();
		engineBoom();
		alarm();
		stop();
	}
}

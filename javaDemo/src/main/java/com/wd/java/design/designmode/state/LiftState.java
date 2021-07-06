package com.wd.java.design.designmode.state;

public abstract class LiftState {

	protected Context context;
	
	public void setContext(Context context) {
		this.context = context;
	}
	abstract void open();
	abstract void close();
	abstract void run();
	abstract void stop();
	
	
}

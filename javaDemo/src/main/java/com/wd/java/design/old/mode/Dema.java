package com.wd.java.design.old.mode;

public class Dema implements Iad{

	private Iad iad;
	
	public Dema(Iad iad){
		this.iad=iad;
	}
	
	@Override
	public void input() {
		System.out.println("Dema ad+100");
		iad.input();
	}

}

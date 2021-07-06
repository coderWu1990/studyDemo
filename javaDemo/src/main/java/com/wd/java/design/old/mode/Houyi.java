package com.wd.java.design.old.mode;

public class Houyi implements Iad{

	private Iad iad;
	
	public Houyi(Iad iad){
		this.iad=iad;
	}
	
	@Override
	public void input() {
		System.out.println("Hou yi ad+100");
		iad.input();
	}

}

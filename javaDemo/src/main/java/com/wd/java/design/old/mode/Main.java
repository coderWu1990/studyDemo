package com.wd.java.design.old.mode;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p=new Person();
		//p.input();
		
		//new Houyi(p).input();
		
		new Dema(new Houyi(p)).input();
		
	}

}

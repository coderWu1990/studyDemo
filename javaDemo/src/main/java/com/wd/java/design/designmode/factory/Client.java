package com.wd.java.design.designmode.factory;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Human human1=HumanFactory.createHuman(WhiteHuman.class);
		human1.getColor();
		human1.say();
		Human human2=HumanFactory.createHuman(YellowHuman.class);
		human2.getColor();
		human2.say();
	}

}

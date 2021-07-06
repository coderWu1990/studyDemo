package com.wd.java.algorithm.play.tema;

import java.util.Random;

public class AMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person p0 = new Person("zhu", 1000);
		Person p1 = new Person("wju", 1000);
		Person p2 = new Person("lih", 1000);
		Random random=new Random();
		for (int i = 1; i < 2; i++) {
			int a0=random.nextInt(50);
			int a1=random.nextInt(50);
			int a2=random.nextInt(50);
			int a3=random.nextInt(50);
			int a4=random.nextInt(50);
			p0.buy(a0, 50);
			p1.buy(a1, 50);
			p2.buy(a2, 50);
			p1.buy(a3, 50);
			p0.buy(a4, 50);
			Center.getInstance().kaiJ(i);
		}

	}

}

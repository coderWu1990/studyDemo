package com.wd.java.algorithm.play.zhipai;

import java.util.Scanner;

public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		wanP();
		//wan21();
		//wanD();
		
	}
	
	private static void wanD(){
		Ddz ddz=new Ddz();
		ddz.clearP();
		ddz.faP();
		ddz.addD(0);
		ddz.showAll();
	}

	private static void wan21() {

		Bjack bjack = new Bjack();
		bjack.clearP();
		for (int i = 0; i < bjack.getPlayerCount(); i++) {
			bjack.faDp();
			Scanner sc = new Scanner(System.in);
			System.out.print("init: ");
			bjack.showP(i);
			while (sc.hasNext()) {
				// 利用nextXXX()方法输出内容
				String str = sc.next();
				if ("y".equals(str)) {
					bjack.addP(i);
					boolean b = bjack.showP(i);
					if (b) {
						break;
					}
				} else {
					break;
				}
			}
			int ps = bjack.getTotalS(i);
			if (ps > 21) {
				System.out.println("died:" + ps);
			} else {
				System.out.println("alive:" + ps);
			}
		}
		System.out.println("game is over");

	}

	private static void wanP() {
		long t1 = System.currentTimeMillis();
		int count = 2;
		String[] all = new String[] { "P0", "P1", "P2", "P3", "P4" };// ,"P5","P6","P7","P8","P9"
		ZhiPai zhiPai = new JHua();// new JHua();new NiuNiu()
		zhiPai.setPlayerCount(all);
		for (int i = 0; i < count; i++) {
			zhiPai.faPai();
			zhiPai.showAllPai();
		}
		System.out.println("geshu:" + zhiPai.getGs() + "/"
				+ (all.length * count));
		System.out.println("耗时：" + (System.currentTimeMillis() - t1));
	}

}

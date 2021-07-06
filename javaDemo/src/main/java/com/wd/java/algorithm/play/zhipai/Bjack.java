package com.wd.java.algorithm.play.zhipai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bjack {
	
	private static final Player[] players = new Player[] { new Player("w1", 100),
		new Player("w2", 100), new Player("w3", 100),new Player("w4", 100),new Player("w5", 100) };
	private List<Integer> pp = new ArrayList<>();
	private int totalCount = 52;
	/** 当前第几张 */
	private int curCount = 0;

	public Bjack() {

	}

	public List<Integer> clearP() {
		pp.clear();
		Random random = new Random();
		while (pp.size() < totalCount) {
			int a = random.nextInt(totalCount);
			if (!pp.contains(a)) {
				pp.add(a);
			}
		}
//		System.out.println("pp.size="+pp.size());
//		for (int i = 0; i <totalCount; i++) {
//			System.out.print(" "+Player.transPai(pp.get(i)));
//		}
//		System.out.print("\n");
		return pp;
	}

	public void faDp() {
		curCount=0;
		for (int i =0 ; i < players.length; i++) {
			players[i].clearPoker();
		}
		for (int i =0 ; i < players.length*2; i++) {
			players[i%players.length].addP(pp.get(i));
			curCount++;
		}
	}
	
	public int getPlayerCount(){
		return players.length;
	}

	public void addP(int i) {
		//System.out.println("count="+curCount+" pai="+Player.transPai(pp.get(curCount)));
		players[i].addP(pp.get(curCount));
		curCount++;
	}

	public boolean showP(int i) {
		players[i].showPoke();
		return isOver(i);
	}

	private boolean isOver(int i) {
		int size=players[i].getmPoker().size();
		System.out.println("size="+size+" total="+getTotalS(i));
		boolean io = getTotalS(i) > 21 || size== 5;
		return io;
	}
	
	public int getTotalS(int i){
		int zs=0;
		for (int j = 0; j < players[i].getmPoker().size(); j++) {
			zs +=getPs(players[i].getmPoker().get(j));
		}
		return zs;
	}
	
	private int getPs(int p) {
		int s = p / 4;
		if (s < 9) {
			return s + 2;
		} else if (s < 12) {
			return 10;
		} else {
			return 1;
		}
	}

}

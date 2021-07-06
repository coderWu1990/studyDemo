package com.wd.java.algorithm.play.zhipai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ZhiPai {

	private List<Integer> pp = new ArrayList<>();
	private int totalCount = 52;
	private int oneCount = 3;
	private int playerNum = 5;
	private Player[] players = null;

	public boolean setPlayerCount(String[] allPlayer) {
		if (allPlayer == null || allPlayer.length < 1 || allPlayer.length > 10) {
			return false;
		}
		playerNum = allPlayer.length;
		players = new Player[playerNum];
		for (int i = 0; i < playerNum; i++) {
			players[i] = new Player(allPlayer[i], 100);
		}
		return true;
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
		return pp;
	}

	protected void initCount(int totalCount, int oneCount) {
		this.totalCount = totalCount;
		this.oneCount = oneCount;
	}

	public void faPai() {
		for (int i = 0; i < playerNum; i++) {
			players[i].clearPoker();
		}
		List<Integer> pp = clearP();
		for (int i = 0; i < playerNum * oneCount; i++) {
			players[i % playerNum].addP(pp.get(i));
		}
	}
	
	private int geshu=0;
	
	public void clearGs(){
		geshu=0;
	}
	
	public int getGs(){
		return geshu;
	}
	
	public void showAllPai() {
		calAllBill();
		// softPai();
		for (int i = 0; i < players.length; i++) {
			int type = getPaiType(players[i].getmPoker());
			// if(type==10){
			if(type<2){
				geshu++;
			}
			System.out.print(showPaiType(type));
			players[i].showPoke();
			// }
		}
	}

	private void calAllBill() {
		for (int i = 1; i < players.length; i++) {
			int m = calBill(players[0], players[i]);
			// System.out.println(players[i].getName()+"："+m);
		}

	}

	private void softPai() {
		for (int i = 0; i < players.length; i++) {
			for (int j = i + 1; j < players.length; j++) {
				if (!bigPai(players[i].getmPoker(), players[j].getmPoker())) {
					Player temp = players[i];
					players[i] = players[j];
					players[j] = temp;
				}
			}
		}
	}

	protected abstract int getPaiType(List<Integer> pai);

	protected abstract String showPaiType(int type);

	protected abstract boolean bigPai(List<Integer> p1, List<Integer> p2);

	protected abstract int calBill(Player p1, Player p2);
}

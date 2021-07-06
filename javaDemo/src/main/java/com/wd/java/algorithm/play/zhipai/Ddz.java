package com.wd.java.algorithm.play.zhipai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Ddz {
	private static final Player[] players = new Player[] { new Player("w1", 100),
		new Player("w2", 100), new Player("w3", 100) };
	private List<Integer> pp = new ArrayList<>();
	private int totalCount = 54;
	/** 当前第几张 */
	private int curCount = 0;
	
	public Ddz() {
		
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
	
	public void faP() {
		curCount=0;
		for (int i =0 ; i < players.length; i++) {
			players[i].clearPoker();
		}
		for (int i =0 ; i < players.length*17; i++) {
			players[i%players.length].addP(pp.get(i));
			curCount++;
		}
	}
	
	public void addD(int i){
		while(curCount<totalCount){
			players[i].addP(pp.get(curCount));
			curCount++;
		}
		
	}
	
	public void showAll(){
		for (int j = 0; j < players.length; j++) {
			Collections.sort(players[j].getmPoker(), new Comparator<Integer>() {

				@Override
				public int compare(Integer left, Integer right) {
					if(left<4||left>51){
						left=54+left;
					}
					if(right<4||right>51){
						right=54+right;
					}
					if(left<right){
						return 1;
					}else if(left>right){
						return -1;
					}else{
						return 0;
					}
					
				}
			});
			
			players[j].showPoke();
			System.out.println(""+players[j].getmPoker().size());
		}
		
	}
	
	public void autoPlay(){
		
	}
	
	
}

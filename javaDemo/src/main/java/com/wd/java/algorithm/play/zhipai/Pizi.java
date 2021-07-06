package com.wd.java.algorithm.play.zhipai;

import java.util.List;



public class Pizi extends ZhiPai{

	public Pizi() {
		initCount(55, 3);
	}
	
	@Override
	protected int getPaiType(List<Integer> pai) {
		return getTotalShu(pai);
	}

	@Override
	protected String showPaiType(int type) {
		return "dianshu="+type+"  ";
	}

	@Override
	protected boolean bigPai(List<Integer> p1, List<Integer> p2) {
		return getTotalShu(p1)>getTotalShu(p2);
	}

	private int getTotalShu(List<Integer> p){
		int s1 = getShu(p.get(0));
		int s2= getShu(p.get(1));
		int s3 = getShu(p.get(2));
		return s1+s2+s3;
	}
	
	private int  getShu(int p){
		int a=p/4;
		if(a<=12){
			return a+2;
		}else{
			return a+2+p%4;
		}
	}
	@Override
	public boolean setPlayerCount(String[] allPlayer) {
		// TODO Auto-generated method stub
		return super.setPlayerCount(allPlayer);
	}
	
	@Override
	protected int calBill(Player p1, Player p2) {
		return 0;
	}
}

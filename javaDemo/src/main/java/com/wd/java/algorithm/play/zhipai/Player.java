package com.wd.java.algorithm.play.zhipai;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Integer> mPoker = new ArrayList<Integer>();

	private int money = 100;

	private String name;

	private int curM = 0;

	private boolean isPlaying = false;

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public Player(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public int addCurM(int m) {
		curM += m;
		return curM;
	}

	public void culCurM() {
		money -= curM;
		curM = 0;
	}

	public List<Integer> getmPoker() {
		return mPoker;
	}

	public void addP(Integer p) {
		mPoker.add(p);
	}

	public void clearPoker() {
		mPoker.clear();
	}

	public void winM(int m) {
		money += m;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public void showPoke() {
		System.out.print(name + "(" + money + ")  :");
		for (Integer integer : mPoker) {
			System.out.print(transPai(integer) + "  ");
		}
		System.out.print("\n");
	}

	public static String transPai(int d) {
		if (d > 54) {
			return "无效";
		} else if (d == 54) {
			return "配牌";
		} else if (d == 53) {
			return "大  王    ";
		} else if (d == 52) {
			return "小  王    ";
		} else if (d < 0) {
			return "无效";
		}
		String head = "";
		String body = "";
		int shu = d / 4;
		int type = d % 4;
		switch (type) {
		case 0:
			head = "黑";
			break;
		case 1:
			head = "红";
			break;
		case 2:
			head = "方";
			break;
		case 3:
			head = "梅";
			break;
		default:
			break;
		}
		if (shu < 8) {
			body = "   " + (shu + 2);
		} else if (shu == 8) {
			body = "" + (shu + 2);
		} else if (shu == 9) {
			body = "   J";
		} else if (shu == 10) {
			body = "   Q";
		} else if (shu == 11) {
			body = "   K";
		} else if (shu == 12) {
			body = "   A";
		} else {
			body = "无效" + shu;
		}
		return head + body;
	}
}

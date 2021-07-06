package com.wd.java.algorithm.play.tema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Center {

	private static Center mInstance;

	private Center() {
	};

	public static Center getInstance() {
		if (mInstance == null) {
			mInstance = new Center();
		}
		return mInstance;
	}

	private static final int B_TM = 40;
	private static final int B_SX = 10;

	private List<Person> list = new ArrayList<Person>();

	private int mPool = 100000;

	public void addPerson(Person p) {
		if (!list.contains(p)) {
			list.add(p);
		}

	}

	public void kaiJ(int q) {
		Random random = new Random();
		int winNum = random.nextInt(50);
		System.out.println("第" + q + " 开：" + winNum);
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
			int totalMoney = 0;
			Map<Integer, Integer> map = p.getMap();
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				int num = entry.getKey();
				int money = entry.getValue();
				if (num == winNum) {
					totalMoney = money * B_TM;
				} else {
					totalMoney = totalMoney - money;
				}
			}
			p.addM(totalMoney);
			p.clear();
			mPool = mPool - totalMoney;
			System.out.println(p.getName() + " win " + totalMoney);
		}
		list.clear();
		System.out.println("池：" + mPool);

	}
}

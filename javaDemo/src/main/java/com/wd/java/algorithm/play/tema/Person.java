package com.wd.java.algorithm.play.tema;

import java.util.HashMap;
import java.util.Map;

public class Person {

	private int id;
	private String name;
	private int money;
	
	private Map<Integer,Integer> map=new HashMap<Integer, Integer>();
	
	
	public Person(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public void buy(int number,int money){
		System.out.println(name+" buy："+number+"<>"+money);
		Center.getInstance().addPerson(this);
		if(map.keySet().contains(number)){
			money=map.get(number)+money;
			System.out.println("重复："+number+"<>"+money);
		}
		map.put(number, money);
	}
	
	public void addM(int s){
		money+=s;
	}

	public Map<Integer, Integer> getMap() {
		return map;
	}
	
	public void clear(){
		map.clear();
	}
	
}

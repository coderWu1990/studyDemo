package com.wd.java.design.designmode.memento;

import java.util.HashMap;

public class Memento {

	private HashMap<String, Object> map;

	public Memento(HashMap<String, Object> map) {
		super();
		this.map = map;
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

}

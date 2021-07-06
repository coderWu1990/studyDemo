package com.wd.java.design.designmode.observer;

import java.util.Vector;

public abstract class Subject {
	private Vector<Observer> vector=new Vector<Observer>();
	void attach(Observer observer){
		vector.add(observer);
	};
	
	void detach(Observer observer){
		vector.remove(observer);
	};
	
	void notifyChange(){
		for(Observer o:vector){
			o.update();
		}
	};
}

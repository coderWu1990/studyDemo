package com.wd.java.design.designmode.memento.one;

public class Originator implements Cloneable {

	private String state;
	private Originator backup;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void createMemento() {
		backup = this.clone();
	}

	public void restoreMemento() {
		this.setState(backup.getState());
	}

	// 克隆当前对象
	@Override
	protected Originator clone() {
		try {
			return (Originator) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}

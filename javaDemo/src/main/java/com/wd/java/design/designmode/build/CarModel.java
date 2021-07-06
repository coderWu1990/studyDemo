package com.wd.java.design.designmode.build;

import java.util.ArrayList;

public abstract class CarModel {
	protected abstract void start();

	private ArrayList<String> sequence = new ArrayList<String>();

	protected abstract void stop();

	protected abstract void engineBoom();

	protected abstract void alarm();

	protected void run() {
		for (int i = 0; i < this.sequence.size(); i++) {
			String actionName = this.sequence.get(i);
			if (actionName.equalsIgnoreCase(" start")) {
				this.start(); // 启动汽车
			} else if (actionName.equalsIgnoreCase(" stop")) {
				this.stop(); // 停止汽车
			} else if (actionName.equalsIgnoreCase(" alarm")) {
				this.alarm(); // 喇叭开始叫了
			} else if (actionName.equalsIgnoreCase(" engine boom")) {
				// 如果是engine boom关键字
				this.engineBoom(); // 引擎开始轰鸣

			}
		}
	}

	final public void setSequence(ArrayList sequence) {
		this.sequence = sequence;
	}
}

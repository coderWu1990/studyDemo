package com.wd.java.ds.list.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Noodle> blockingQueue=new ArrayBlockingQueue<Noodle>(100);
		Producer p=new Producer("bzfan",blockingQueue);
		Consumer c1=new Consumer("wusong",blockingQueue);
		Consumer c2=new Consumer("bajie",blockingQueue);
		new Thread(p).start();
//		new Thread(c1).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(c1).start();
		new Thread(c2).start();
	}

}

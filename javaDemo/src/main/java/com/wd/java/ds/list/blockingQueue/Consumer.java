package com.wd.java.ds.list.blockingQueue;

import java.util.concurrent.BlockingQueue;

import com.wd.java.utils.TimeUtil;

public class Consumer implements Runnable{
	private int takeCount=0;
	private BlockingQueue<Noodle> blockingQueue;
	private String name;
	
	public Consumer(String name,BlockingQueue<Noodle> blockingQueue) {
		this.name=name;
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Noodle noodle=blockingQueue.take();
				noodle.setTakeName(name);
				noodle.setTakeTime(TimeUtil.getCurTime());
//				System.out.println("take:"+noodle.toString());
				takeCount++;
				System.out.println(name+"take count="+takeCount);
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	

}

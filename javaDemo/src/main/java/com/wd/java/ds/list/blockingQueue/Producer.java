package com.wd.java.ds.list.blockingQueue;

import java.util.concurrent.BlockingQueue;

import com.wd.java.utils.TimeUtil;

class Producer implements Runnable {
	private int num=0;
	private int saleCount=0;
	
	private BlockingQueue<Noodle> blockingQueue;
	private String name;
	
	public Producer(String name,BlockingQueue queue) {
		this.name=name;
		this.blockingQueue=queue;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Noodle noodle=new Noodle("mx"+num++,"$5");
				noodle.setProductName(name);
				noodle.setProductTime(TimeUtil.getCurTime());
				blockingQueue.put(noodle);
//				System.out.println("put:"+noodle);
				saleCount++;
				System.out.println("sale Count="+saleCount);
				if(saleCount==500){
					break;
				}
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
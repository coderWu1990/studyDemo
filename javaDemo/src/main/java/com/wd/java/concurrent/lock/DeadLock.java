package com.wd.java.concurrent.lock;
/**
 * 死锁实例
 * @author ZH-SW-Wudi
 *
 */
public class DeadLock {

	private static Object objA=new Object();
	private static Object objB=new Object();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (objA) {
					System.out.println("1 lock A");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (objB) {
						System.out.println("1 lock B");
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (objB) {
					System.out.println("2 lock B");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (objA) {
						System.out.println("2 lock A");
					}
				}
			}
		}).start();
	}

}

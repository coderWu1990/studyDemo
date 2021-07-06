package com.wd.java.concurrent.cas;
/**
 * sync关键字测试
 * @author ZH-SW-Wudi
 *
 */
public class SyncTest {

	public synchronized void doSysout(Thread thread) {
		System.out.println(thread.getName() + "开始执行");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(thread.getName() + "执行结束");
	}

	public static void main(String[] args) {
		final SyncTest test = new SyncTest();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				test.doSysout(Thread.currentThread());
			}
		}, "线程1");
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				test.doSysout(Thread.currentThread());
			}
		}, "线程2");
		thread1.start();
		thread2.start();

	}
}
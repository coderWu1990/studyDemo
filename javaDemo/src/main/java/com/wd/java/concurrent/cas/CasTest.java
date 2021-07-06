package com.wd.java.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasTest {
	static AtomicInteger a = new AtomicInteger();
	static int b;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						//casTest();
						comTest();
					}
				}
			}).start();
		}

	}

	private static void casTest() {
		try {
			System.out.println("cas="+Thread.currentThread().getName() + " :"
					+ a.incrementAndGet());
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void comTest() {
		try {
			System.out.println(Thread.currentThread().getName() + " :"
					+ (b=b+1));
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

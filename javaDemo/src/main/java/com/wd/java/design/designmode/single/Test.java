package com.wd.java.design.designmode.single;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import com.wd.java.design.designmode.single.WifiManager;
import com.wd.java.design.old.single.BluetoothManager;
import com.wd.java.design.old.single.MusicManager;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					WifiManager manager=WifiManager.getInstance(Thread.currentThread().getName());
					System.out.println(Thread.currentThread().getName()
							+ manager);
				}
			}).start();
		}
	}

	private static void test2() {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					BluetoothManager manager = BluetoothManager.getInstance();
					System.out.println(Thread.currentThread().getName()
							+ manager);
				}
			}).start();
		}
	}
	
	private static void test3() {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					MusicManager manager = MusicManager.getInstance();
					System.out.println(Thread.currentThread().getName()
							+ manager);
				}
			}).start();
		}
	}

}

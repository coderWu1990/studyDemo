package com.wd.java.design.old.single;

public class BluetoothManager {

	private BluetoothManager() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static BluetoothManager getInstance() {
		return Holder.mInstance;
	}

	private static class Holder {
		private static BluetoothManager mInstance=new BluetoothManager();
	}
}

package com.wd.java.design.old.single;

public class SettingsManager {

	private static SettingsManager instance;

	private SettingsManager() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SettingsManager getInstance() {
		if (instance == null) {
			instance = new SettingsManager();
		}
		return instance;
	}
}

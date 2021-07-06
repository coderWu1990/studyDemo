package com.wd.java.design.old.single;

public class MusicManager {

	private static MusicManager instance=new MusicManager();
	
	private MusicManager(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MusicManager getInstance(){
		return instance;
	}
}


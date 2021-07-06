package com.wd.java.basic.memory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OOMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		oom();
	}

	private static void oom() {
		Map<String, byte[]> map = new HashMap<String, byte[]>();
		byte[] bs = new byte[1024*1024];
		for (int i = 0; i < 10000; i++) {
			String d = new Date().toString();
			map.put(i + "rosen jiang", bs);
		}
	}

}

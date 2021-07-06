/**
 * 
 */
package com.wd.java.algorithm.track;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2020-12-16 下午5:16:57 <br/> 
 *
 */
public class TestTrack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long t1 = System.currentTimeMillis();
		AngleUtil.startCal();
		//AngleUtil.start();
		long t2 = System.currentTimeMillis();
		System.out.println("耗时=" + (t2 - t1));
	}

}

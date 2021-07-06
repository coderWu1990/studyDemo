package com.wd.java.algorithm.chance;

/**
 * 计算比赛概率
 */
public class Chance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getWin53Value(0.6f));
		System.out.println(getWin32Value(0.6f));
	}
	
	/**
	 * 五局三胜概率
	 * // p^3[6p^2-15p+10]
	 * @param f
	 * @return
	 */
	public static float getWin53Value(float f) {
		return f * f * f * (6 * f * f - 15 * f + 10);
	}

	/**
	 * 三局两胜概率
	 * // 3P^2-2p^3
	 * @param f
	 * @return
	 */
	public static float getWin32Value(float f) {
		return 3 * f * f - 2 * f * f * f;
	}

}

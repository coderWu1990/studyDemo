package com.wd.java.utils;

/**
 * 时区工具类
 */
public class TimeZoneUtil {
	/**
	 * 根据经度获取时区
	 * 
	 * @param currentLon
	 * @return
	 */
	public static int caculateTimeZone(double currentLon) {
		int timeZone;
		int shangValue = (int) (currentLon / 15);
		double yushuValue = Math.abs(currentLon % 15);
		if (yushuValue <= 7.5) {
			timeZone = shangValue;
		} else {
			timeZone = shangValue + (currentLon > 0 ? 1 : -1);
		}
		return timeZone;
	}
}

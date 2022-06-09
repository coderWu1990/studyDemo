package com.wd.java.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间工具类
 */
public class TimeUtil {

	public static String getCurTime1() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}

	public static String getCurTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
		return dateFormat.format(new Date());
	}

	/**
	 * 将字符串时间转为Long时间
	 * 
	 * @param time
	 *            yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static Long getLongTimeOfSSS(String time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss:SSS");
			Date date = sdf.parse(time);
			return date.getTime();
		} catch (Exception e) {
		}
		return 0L;
	}

	/**
	 * 将字符串时间转为Long时间
	 * 
	 * @param time
	 *            yyyy-MM-dd HH:mm:ss
	 */
	public static Long getLongTime(String time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(time);
			return date.getTime();
		} catch (Exception e) {
		}
		return 0L;
	}

	/**
	 * 将字符串时间转为Long时间
	 * 
	 * @param time
	 *            yyyy-MM-dd
	 */
	public static Long getLongTimeOfYMD(String time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(time);
			return date.getTime();
		} catch (Exception e) {
		}
		return 0L;
	}

	/**
	 * 将Long时间转成String时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static String getStringTimeOfSSS(Long time) {
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		return sdf.format(date);
	}

	/**
	 * 将Long时间转成String时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringTime(Long time) {
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 将Long时间转成String时间
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getStringTimeOfYMD(Long time) {
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 当前的时间(设备)
	 * 
	 * @return yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static String getDeviceTimeOfSSS() {
		String date = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss:SSS");
			date = df.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
			date = new Date().getTime() + "";// 当前时间的long字符串
		}
		return date;
	}

	/**
	 * 当前的时间(设备)
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDeviceTime() {
		String date = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = df.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
			date = new Date().getTime() + "";// 当前时间的long字符串
		}
		return date;
	}

	/**
	 * 当前的时间(年月日)
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getDeviceTimeOfYMD() {
		String date = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			date = df.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 当前的时间(年月)
	 * 
	 * @return yyyy-MM
	 */
	public static String getDeviceTimeOfYM() {
		String date = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
			date = df.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取某月最后一天(年月日)
	 * 
	 * @return yyyy-MM
	 */
	public static String getLastDayOfMonthOfYMD(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(cal.getTime());

		return lastDayOfMonth;
	}

	/**
	 * 获取某月最后一天(日)
	 */
	public static int getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		return lastDay;
	}

	public static String getUTCTime(int timestamp) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeZone(TimeZone.getDefault());
			calendar.setTimeInMillis((long)timestamp * 1000);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = sdf.format(calendar.getTime());
			return dateString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 毫秒转成时分秒
	 * @param time
	 * @return
	 */
	public static String getGapTime(long time){
		//这里想要只保留分秒可以写成"mm:ss"
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		//这里很重要，如果不设置时区的话，输出结果就会是几点钟，而不是毫秒值对应的时分秒数量了。
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
		return formatter.format(time);
	}

	public static String getGapTime2(long time){
		long hours = time / (1000 * 60 * 60);
		long minutes = (time-hours*(1000 * 60 * 60 ))/(1000* 60);
		long second = (time-hours*(1000 * 60 * 60 )-minutes*(1000 * 60 ))/1000;
		String diffTime="";
		if (hours<10){
			diffTime="0"+hours;
		}else {
			diffTime=""+hours;
		}
		if(minutes<10){
			diffTime=diffTime+":0"+minutes;
		}else{
			diffTime=diffTime+":"+minutes;
		}
		if(second<10){
			diffTime=diffTime+":0"+second;
		}else{
			diffTime=diffTime+":"+second;
		}
		return diffTime;
	}
}

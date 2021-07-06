package com.wd.java.algorithm.subject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 常用
 * 
 * @author ZH-SW-Wudi
 * 
 */
public class JavaMethod {

	/**
	 * ConcurrentModificationException异常例子
	 */
	public static void testEp_01() {
		int s = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println("s=" + s++);
			Integer integer = iterator.next();
			if (integer == 2) {
				list.remove(integer);
				// iterator.remove();//使用这个方式可以解决
			}

		}
	}

	/**
	 * 冒泡排序
	 */
	public static void bubbleSort_02() {
		int[] arrs = { 8, 5, 1, 9, 7, 2, 6, 4, 8, 3, 7 };
		for (int i = 0; i < arrs.length; i++) {
			for (int j = i + 1; j < arrs.length; j++) {
				if (arrs[i] > arrs[j]) {
					int temp = arrs[i];
					arrs[i] = arrs[j];
					arrs[j] = temp;
				}
			}
		}
		printArr(arrs);
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + ":" + arr[i]);
		}
	}

	/**
	 * 二分查找（需要在有序队列里面）
	 * 
	 * @param num
	 *            需要查询的数
	 * @return
	 */
	public static int getIndex_03(int num) {
		int[] arr = { 11, 22, 33, 34, 66, 89 };
		int min = 0;
		int max = arr.length - 1;
		int mid = (min + max) / 2;
		System.out.println("min: " + min + " mid: " + mid + " max: " + max);
		// 查找的算法
		int index = -1; // 如果算到最后，index人值没有改变，代表num在arr中不存在
		while (true) {
			if (arr[mid] == num) {// 找到查找的数
				index = mid;
				break;
			}
			if (arr[mid] > num) {// num 在左边
				max = mid - 1;
				mid = (min + max) / 2;
			}
			if (arr[mid] < num) {// num 在右边
				min = mid + 1;
				mid = (min + max) / 2;
			}
			if (min > max) { // 不符合逻辑
				break;// 退出循环
			}
		}
		return index;
	}

	/**
	 * md5加密
	 * 
	 * @param originString
	 * @return
	 */
	public static String encodeByMD5_04(String originString) {
		if (originString == null) {
			return null;
		}
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] results = md5.digest(originString.getBytes());
			StringBuffer resultSb = new StringBuffer();
			for (int i = 0; i < results.length; i++) {
				resultSb.append(byteToHexString_05(results[i]));
			}
			return resultSb.toString();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * 字节转换为16进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byteToHexString_05(byte b) {
		String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "A", "B", "C", "D", "E", "F" };
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 测试线程池 假如有一个工厂，工厂里面有10个工人，每个工人同时只能做一件任务。
	 * 　　因此只要当10个工人中有工人是空闲的，来了任务就分配给空闲的工人做； 　　当10个工人都有任务在做时，如果还来了任务，就把任务进行排队等待；
	 * 　　如果说新任务数目增长的速度远远大于工人做任务的速度，那么此时工厂主管可能会想补救措施，比如重新招4个临时工人进来；
	 * 　　然后就将任务也分配给这4个临时工人做；
	 * 　　如果说着14个工人做任务的速度还是不够，此时工厂主管可能就要考虑不再接收新的任务或者抛弃前面的一些任务了。
	 * 　　当这14个工人当中有人空闲时，而新任务增长的速度又比较缓慢
	 * ，工厂主管可能就考虑辞掉4个临时工了，只保持原来的10个工人，毕竟请额外的工人是要花钱的。
	 * 　　这个例子中的corePoolSize就是10，而maximumPoolSize就是14（10+4）。
	 */
	public static void testThreadPool_07() {
		/*
		 * corePoolSize： 线程池核心线程数 maximumPoolSize：线程池最大数 keepAliveTime： 空闲线程存活时间
		 * unit： 时间单位 workQueue： 线程池所使用的缓冲队列
		 */
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 200,
				TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());//new ArrayBlockingQueue<Runnable>(5)
		for (int i = 1; i <= 30; i++) {
			MyTask myTask = new MyTask(i);
			try {
				executor.execute(myTask);
			} catch (Exception e) {
				System.out.println("阻塞了task"+i);
				//System.out.println("e=" + e.getMessage());
			}

			printDate(i + "线程池中线程数目：" + executor.getPoolSize()
					+ "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行完成的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}

	static class MyTask implements Runnable {
		private int taskNum;

		public MyTask(int num) {
			this.taskNum = num;
		}

		@Override
		public void run() {
			printDate("正在执行task " + taskNum);
			try {
				Thread.currentThread().sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printDate("task " + taskNum + "执行完毕");
		}
	}

	public static void printDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:S");
		System.out.println(format.format(new Date()) + ": " + str);
	}

	/**
	 * 一个列表，依赖另一个列表排序
	 */
	public static void AbSort() {
		List<String> list_a = new ArrayList<String>();
		List<String> list_b = new ArrayList<String>();
		list_a.add(new String("A"));
		list_a.add(new String("B"));
		list_a.add(new String("C"));
		list_a.add(new String("D"));
		list_a.add(new String("E"));

		list_b.add(new String("C"));
		list_b.add(new String("A"));
		list_b.add(new String("D"));

		Iterator<String> iterator = list_a.iterator();
		while (iterator.hasNext()) {
			if (list_b.contains(iterator.next())) {
				iterator.remove();
			}
		}
		for (int i = 0; i < list_b.size(); i++) {
			System.out.println("b=" + list_b.get(i));
		}
		for (int i = 0; i < list_a.size(); i++) {
			System.out.println("a=" + list_a.get(i));
		}
	}

	/**
	 * 取最近的2的倍数
	 * 
	 * @param i
	 * @return
	 */
	public static int roundUpToPowerOfTwo(int i) {
		i--; // If input is a power of two, shift its high-order bit right
		// "Smear" the high-order bit all the way to the right
		i |= i >>> 1;
		// System.out.println("i="+i);
		i |= i >>> 2;
		// System.out.println("i="+i);
		i |= i >>> 4;
		// System.out.println("i="+i);
		i |= i >>> 8;
		// System.out.println("i="+i);
		i |= i >>> 16;
		// System.out.println("i="+i);
		return i + 1;
	}
	
	/**
	 * 递归算阶乘
	 * @param n
	 * @return
	 */
	public static int Factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return Factorial(n - 1) * n;
		}
	}

}

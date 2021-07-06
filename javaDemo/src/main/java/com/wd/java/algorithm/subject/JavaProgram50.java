package com.wd.java.algorithm.subject;

import java.util.Scanner;

/**
 * java编程50题
 * @author ZH-SW-Wudi
 *
 */
public class JavaProgram50 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// showPrime();
		// decNumber(4);
		// threeEye(85);
		// maxY(12, 24);
		// minB(3, 8);
		// change(45, 7896);
		//showCount();
		//getValue();
		//getWanShu();
		//calcBool();
		//rec(5);
	}
	
	/**
	 * 递归实现阶乘算法
	 * @param n
	 * @return
	 */
	public static long rec(int n) {// 定义函数实现递归
		long value = 0;
		System.out.println("n="+n);
		if (n == 1) {
			value = 1;
		} else {
			value = n * rec(n - 1);
		}
		System.out.println(value);
		return value;
	}
	
	/**
	 * 计算小球距离
	 */
	public static void calcBool(){
		float s=100f;
		float l=0f;
		for (int i = 0; i <10; i++) {
			s=s/2;
			l=l+s;
		}
		System.out.println("l="+l+" s="+s);
	}
	
	/**
	 * 1000以内的完数
	 */
	public static void getWanShu(){
		for (int i = 1; i < 1000; i++) {
			int b=0;
			for (int j = 1; j <= i/2; j++) {
				if(i%j==0){
					b+=j;
				}
			}
			if(b==i){
				System.out.println("完数："+i);
			}
		}
	}

	/**
	 * 求值
	 */
	public static void getValue() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入个位数字：");
		int single = input.nextInt();
		System.out.println("请输入最高位数：");
		int max = input.nextInt();
		int sum = 0, temp = 0;
		for (int i = 0; i < max; i++) {
			temp = single + temp; // 先把本次要加的值赋值给temp；
			single *= 10; // 每次把单数乘以10，向前进一位，加上之前的temp正好满足需要
			sum = sum + temp; // 把每次的temp相加起来就是要的结果
		}
		System.out.println("数字" + single + "公共有" + max + "个数相加的好结果为：" + sum);
	}

	/**
	 * 中英文字母、空格、数字和其它字符的个数
	 */
	public static void showCount() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一行字符串：");
		String str = input.nextLine();
		int digital = 0, character = 0, other = 0, blank = 0;
		char[] ch = str.toCharArray();// String的方法，将字符串转换为字符数组；
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 'a' && ch[i] <= 'z' || ch[i] >= 'A' && ch[i] <= 'Z')
				character++;
			else if (ch[i] >= '0' && ch[i] <= '9')
				digital++;
			else if (ch[i] == ' ')
				blank++;
			else
				other++;
		}
		System.out.println("字母个数：" + character);
		System.out.println("数字个数：" + digital);
		System.out.println("空格个数：" + blank);
		System.out.println("其他个数：" + other);
	}

	/**
	 * 交换两个数的值，不用中间变量
	 * 
	 * @param a
	 * @param b
	 */
	public static void change(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a=" + a + " b=" + b);
	}

	/**
	 * 最小公倍数
	 * 
	 * @param a
	 * @param b
	 */
	public static void minB(int a, int b) {
		int c = 0;
		for (int i = (a > b ? a : b); i <= a * b; i++) {
			// System.out.println("i="+i);
			if (i % a == 0 && i % b == 0) {
				c = i;
				break;
			}
		}
		System.out.println("c=" + c);
	}

	/**
	 * 最大公约数
	 * 
	 * @param a
	 * @param b
	 */
	public static void maxY(int a, int b) {
		int c = 0;
		for (int i = (a > b ? a : b); i > 0; i--) {
			System.out.println("i=" + i);
			if (a % i == 0 && b % i == 0) {
				c = i;
				break;
			}
		}
		System.out.println("c=" + c);
	}

	/**
	 * 三目运算符
	 * 
	 * @param num
	 */
	public static void threeEye(int num) {
		String a = num >= 90 ? "A" : num < 60 ? "C" : "B";
		System.out.println(a);
	}

	/**
	 * 将一个正整数分解质因数。例如：输入 90,打印出 90=2*3*3*5
	 * 
	 * @param num
	 */
	public static void decNumber(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append(num + "=");
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				num = num / i;
				sb.append(i + "*");
				i = 1;
			}
		}
		sb.append(num);
		System.out.println(sb.toString());
	}

	/**
	 * 打印水仙花数 （个十百位的三次方相加等于数的本身）
	 */
	public static void showFlower() {
		int b1, b2, b3;
		for (int m = 101; m < 1000; m++) {
			b3 = m / 100;
			b2 = m % 100 / 10;
			b1 = m % 10;
			if ((b3 * b3 * b3 + b2 * b2 * b2 + b1 * b1 * b1) == m) {
				System.out.println(m + "是一个水仙花数");
			}
		}
	}

	/**
	 * 显示100~200之间的素数
	 */
	public static void showPrime() {
		int count = 0;
		System.out.print("素数=");
		for (int i = 100; i < 201; i++) {
			if (isPrimeNumber(i)) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println("个数：" + count);
	}

	/**
	 * 判断一个数是否是素数
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isPrimeNumber(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {// Math.sqrt(num)
			if (num % i == 0) {
				// System.out.println("i="+i);
				return false;
			}
		}
		return true;
	}

	/**
	 * 菲波拉契数列：有一对兔子，从出生后第 3
	 * 个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
	 */
	public static void rabbit() {
		int s1 = 1, s2 = 1, s, month = 24;
		System.out.println("第1个月的兔子总数：\t" + 1);
		System.out.println("第2个月的兔子总数：\t" + 1);
		for (int i = 3; i <= month; i++) {
			// 每个月的兔子总数是前两个月的总和
			s = s2;
			s2 += s1;
			s1 = s;
			System.out.println("第" + i + "个月的兔子总数：\t" + s2);
		}
	}
}

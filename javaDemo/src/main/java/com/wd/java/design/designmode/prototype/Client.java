package com.wd.java.design.designmode.prototype;

import java.util.Random;

/**
 * ● 性能优良 原型模式是在内存二进制流的拷贝， 要比直接new一个对象性能好很多， 特别是要在一 个循环体内产生大量的对象时，
 * 原型模式可以更好地体现其优点。 
 * ● 逃避构造函数的约束 这既是它的优点也是缺点， 直接在内存中拷贝， 构造函数是不会执行的（参见13.4 节） 。
 * 优点就是减少了约束， 缺点也是减少了约束， 需要大家在实际应用时考虑
 * 
 * @author ZH-SW-Wudi
 * 
 */
public class Client {

	private static int MAX_COUNT = 6;

	public static void main(String[] args) {
		// 模拟发送邮件
		int i = 0;
		// 把模板定义出来， 这个是从数据中获得
		Mail mail = new Mail(new AdvTemplate());
		mail.setTail(" XX银行版权所有");
		while (i < MAX_COUNT) {
			// 以下是每封邮件不同的地方
			Mail cloneMail;
			try {
				cloneMail = (Mail) mail.clone();
				cloneMail.setAppellation(getRandString(5) + " 先生（女士） ");
				cloneMail.setReceiver(getRandString(5) + " @"
						+ getRandString(8) + " . com");
				// 然后发送邮件
				sendMail(cloneMail);
				i++;
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// 发送邮件
	public static void sendMail(Mail mail) {
		System.out.println("标题： " + mail.getSubject() + " \t收件人："
				+ mail.getReceiver() + " \t. . . 发送成功！ ");
	}

	// 获得指定长度的随机字符串
	public static String getRandString(int maxLength) {
		String source = "abcdefghij klmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		for (int i = 0; i < maxLength; i++) {
			sb.append(source.charAt(rand.nextInt(source.length())));
		}
		return sb.toString();
	}

}

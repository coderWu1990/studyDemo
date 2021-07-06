package com.wd.java.design.designmode.flyweight;

public class Client {
	/**
	 * 享元模式 使用共享对象可有效地支持大量的细 粒度的对象
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 初始化对象池
		for (int i = 0; i < 4; i++) {
			String subject = "科目 " + i;
			// 初始化地址
			for (int j = 0; j < 10; j++) {
				String key = subject + "考试地点" + j;
				SignInfoFactory.getInfo(key);
			}
		}
		SignInfo signInfo = SignInfoFactory.getInfo("科目 1考试地点1");
		test();
	}

	public static void test() {
		String str1 = "和谐";
		String str2 = "社会";
		String str3 = "和谐社会";
		String str4;
		str4 = str1 + str2;
		System.out.println(str3 == str4);
		str4 = (str1 + str2).intern();
		System.out.println(str3 == str4);

	}
}

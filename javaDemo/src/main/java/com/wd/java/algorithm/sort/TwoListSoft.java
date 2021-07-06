/**
 * 
 */
package com.wd.java.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-4-1 下午9:35:30 <br/>
 * 自己博客上面写的，写的很菜啊，要不要删呢
 */
public class TwoListSoft {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// An highlighted block
		List<A> list_a = new ArrayList<A>();
		List<A> list_b = new ArrayList<A>();
		// 初始化列表A
		list_a.add(new A("A", "1"));
		list_a.add(new A("B", "2"));
		list_a.add(new A("C", "3"));
		list_a.add(new A("D", "4"));
		list_a.add(new A("E", "5"));
		for (int i = 0; i < list_a.size(); i++) {
			System.out.println("a=" + list_a.get(i).getA());
		}
		// 初始化列表B
		list_b.add(new A("C", "3"));
		list_b.add(new A("A", "1"));
		list_b.add(new A("D", "4"));
		for (int i = 0; i < list_b.size(); i++) {
			System.out.println("b=" + list_b.get(i).getA());
		}
		// 排序过程
		for (int i = 0; i < list_b.size(); i++) {
			A b = list_b.get(i);
			for (int j = 0; j < list_a.size(); j++) {
				A a = list_a.get(j);
				if (b.getA().equals(a.getA())) {
					System.out.println("置顶：" + a.getA());
					list_a.remove(j);
					list_a.add(i, a);
				}
			}

		}
		// 输出排序后结果
		for (int i = 0; i < list_a.size(); i++) {
			System.out.println("aaaaaa=" + list_a.get(i).getA());
		}

	}

	private static class A {
		String a;
		String b;

		public A(String a, String b) {
			super();
			this.a = a;
			this.b = b;
		}

		public String getA() {
			return a;
		}

	}

}

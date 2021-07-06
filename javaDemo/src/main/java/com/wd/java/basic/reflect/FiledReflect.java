/**
 * 
 */
package com.wd.java.basic.reflect;

import java.lang.reflect.Field;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-4-19 下午7:32:16 <br/>
 * 
 */
public class FiledReflect {
	public static void main(String[] args) throws Exception {

		Point p1 = new Point(5, 39);

		Field fieldY = p1.getClass().getField("y");
		int y = (int) fieldY.get(p1);// 取对应p1对象的y字段的值，必须要有对象。
		System.out.println(y);

		// 对私有成员变量，可以进行暴力反射
		Field fieldX = p1.getClass().getDeclaredField("x");
		fieldX.setAccessible(true);// 暴力反射
		int x = (int) fieldX.get(p1);// 取对应p1对象的x字段的值
		System.out.println(x);
	}

}

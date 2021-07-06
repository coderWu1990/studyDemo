/**
 * 
 */
package com.wd.java.basic.annotation;

import java.lang.reflect.Method;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-4-20 下午8:02:17 <br/>
 * 
 */
public class TestAnnotation {
	public static void main(String[] args) {
		try {
			// 获取Student的Class对象
			Class stuClass = Student.class;
			// 说明一下，这里形参不能写成Integer.class，应写为int.class
			Method stuMethod = stuClass.getMethod("study", int.class);

			if (stuMethod.isAnnotationPresent(WdAnnotation.class)) {
				System.out.println("Student类上配置了WdAnnotation注解！");
				// 获取该元素上指定类型的注解
				WdAnnotation wdAnnotation = stuMethod
						.getAnnotation(WdAnnotation.class);
				System.out.println("name: " + wdAnnotation.name()
						+ ", age: " + wdAnnotation.age() + ", score: "
						+ wdAnnotation.score()[0]);
			} else {
				System.out.println("Student类上没有配置wdAnnotation注解！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

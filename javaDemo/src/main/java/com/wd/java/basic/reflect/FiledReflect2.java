/**
 * 
 */
package com.wd.java.basic.reflect;

import java.lang.reflect.Field;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-4-19 下午7:35:59 <br/> 
 *
 */
public class FiledReflect2 {
	public static void main(String[] args) throws Exception {
		
		Person p=new Person("zhangsan", 25, "Amao");		
		//得到字节码,通过字节码得到这个类的所有方法
		Field[] fields = p.getClass().getDeclaredFields();
			for(Field field:fields){
			//因为一个类的字节码在内存中只有一份，所以用==比较更专业，此处用==，不用equals（）
				if(field.getType()==String.class){
					field.setAccessible(true);//进行暴力反射
					String oldValue = (String) field.get(p);//获得字段的值
					String newValue =oldValue.replace("a", "A");
					field.set(p, newValue);
					System.out.println(p);
				}
			}
					
		}

}

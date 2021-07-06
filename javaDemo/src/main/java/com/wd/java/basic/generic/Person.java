/**
 * 
 */
package com.wd.java.basic.generic;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-4-20 上午10:40:27 <br/>
 * 
 */
public class Person {

	String name = "";
	int age = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

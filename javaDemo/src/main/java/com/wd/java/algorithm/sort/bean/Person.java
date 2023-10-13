package com.wd.java.algorithm.sort.bean;

/**
 * @author wudi
 * @desc
 * @time 2023-10-13 17:29
 */
public class Person {
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

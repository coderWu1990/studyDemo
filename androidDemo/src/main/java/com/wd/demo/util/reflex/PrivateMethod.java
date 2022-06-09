package com.wd.demo.util.reflex;

public class PrivateMethod {

    public int wan;

    private String getName() {
        return "private-getName";
    }

    private String getAge(int age) {
        return "age is " + age;
    }

    private String mName = "haha";

    public String getNa() {
        return mName;
    }
}

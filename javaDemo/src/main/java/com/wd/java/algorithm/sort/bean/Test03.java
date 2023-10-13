package com.wd.java.algorithm.sort.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Test03 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "ha"));
        personList.add(new Person(3, "zz"));
        personList.add(new Person(2, "ss"));
        personList.add(new Person(4, "gg"));
        personList.add(new Person(5, "zz"));
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                System.out.println("p1=" + p1 + " p2=" + p2);
                //填0，排序走了4次 填p1.age - p2.age，走了8次
                return p1.age - p2.age;
            }
        });
    }


}

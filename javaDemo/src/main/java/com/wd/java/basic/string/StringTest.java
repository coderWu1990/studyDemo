package com.wd.java.basic.string;

/**
 * @author ZH-SW-Wudi
 * @date: 2020-12-7 下午8:28:22 <br/>
 * 测试string的index和sub函数
 */
public class StringTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
//		testIndex();
        testSub();
    }

    private static void testIndex() {
        String org = "1234567";
        String key = "345";
        //输出-1
        System.out.println(org.indexOf(key, 3));

        //输出2
        System.out.println(org.indexOf(key, 2));

        //输出2
        System.out.println(org.indexOf(key));
    }

    private static void testSub() {
        String str = "abcde";
        //输出bcde
        System.out.println(str.substring(1));

        //输出bcd
        System.out.println(str.substring(1, 4));

        //输出e
        System.out.println(str.substring(4, str.length()));
    }

}

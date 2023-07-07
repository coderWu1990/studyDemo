package com.wudi.demo.aarun;

/**
 * @author wudi
 * @desc
 * @time 2023-05-18 15:00
 */
public class Test1 {
    public static void main(String[] args) {
        String aa="12345678";
        int seq=3;
        for (int i = 0; i < aa.length() / seq + 1; i++) {
            int l = seq;
            if (i == aa.length() / seq) {
                l = aa.length() % seq;
            }
            String sub = aa.substring(i * seq, i * seq + l);
            System.out.println("str" + i + " = " + sub);
        }
    }
}

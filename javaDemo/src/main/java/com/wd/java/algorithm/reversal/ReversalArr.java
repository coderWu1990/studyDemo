package com.wd.java.algorithm.reversal;

/**
 * @author wudi
 * @desc
 * @time 2022-01-13 18:51
 */
public class ReversalArr {
    /**
     * 反转数组
     * @param arr
     * @return
     */
    public static byte[] reversalArr(byte[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            byte temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}

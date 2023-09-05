package com.wd.jni;

/**
 * @author wudi
 * @desc
 * @time 2023-08-16 19:27
 */
public class Math {

    public static int sum(int a, int b) {
        return nativeSum(a, b);
    }

    public static String getStr() {
        return nativeStr();
    }

    private static native int nativeSum(int a, int b);

    private static native String nativeStr();
}

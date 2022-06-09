/**
 *
 */
package com.wd.demo.util.test;

import android.util.Log;
import android.util.LruCache;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-29 上午10:43:47 <br/> 
 *
 */
public class LruUtil {

    private static LruCache<Integer, String> lruCache = new LruCache<Integer, String>(3);

    public static void test1() {
        lruCache.put(1, "AA");
        lruCache.put(2, "BB");
        lruCache.put(3, "CC");
        lruCache.put(4, "DD");
        show();
    }

    public static void test2() {
        lruCache.get(2);
        show();
    }

    private static void show() {
        Log.i("wd", "" + lruCache.snapshot());
    }
}

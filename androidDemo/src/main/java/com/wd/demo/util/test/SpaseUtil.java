/**
 *
 */
package com.wd.demo.util.test;

import android.util.Log;
import android.util.SparseArray;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-4-15 下午8:08:28 <br/> 
 *
 */
public class SpaseUtil {

    private static SparseArray<String> mSparseArray = new SparseArray<String>();

    public static void put() {
        mSparseArray.put(1, "3");
        Log.i("wd", "put=" + mSparseArray.toString());
    }

    public static void get() {
        String str = mSparseArray.get(1);
        Log.i("wd", str + " get=" + mSparseArray.toString());
    }

    public static void del() {
        mSparseArray.delete(1);
        Log.i("wd", "del=" + mSparseArray.toString());
    }

}

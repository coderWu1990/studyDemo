package com.wd.demo.util;

import android.util.Log;

public class L {

    private final static String TAG = "demo1";

    private final static boolean debug = true;

    public static void i(String str) {
        if (debug) {
            Log.i(TAG, str);
        }
    }
}

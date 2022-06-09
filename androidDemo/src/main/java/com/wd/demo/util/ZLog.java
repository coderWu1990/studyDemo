/**
 *
 */
package com.wd.demo.util;

import android.util.Log;

import java.util.Arrays;

/**
 * log工具
 *
 * @author ZH-SW-Wudi
 * @date: 2020-12-25 下午5:58:47 <br/>
 *
 */
public class ZLog {
    public static boolean PRINT_LOG = true;
    private static String TAG = "default";

    public static void d(Object paramObject) {
        if (PRINT_LOG) {
            String str1 = getFunctionName();
            if (str1 != null) {
                String str2 = TAG;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str1);
                localStringBuilder.append(" - ");
                localStringBuilder.append(paramObject);
                Log.d(str2, localStringBuilder.toString());
                return;
            }
            Log.d(TAG, paramObject.toString());
        }
    }

    public static void e(Object paramObject) {
        if (PRINT_LOG) {
            String str1 = getFunctionName();
            if (str1 != null) {
                String str2 = TAG;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str1);
                localStringBuilder.append(" - ");
                localStringBuilder.append(paramObject);
                Log.e(str2, localStringBuilder.toString());
                return;
            }
            Log.e(TAG, paramObject.toString());
        }
    }

    private static String getFunctionName() {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread()
                .getStackTrace();
        Log.i("wddd", "ssddfd=" + Arrays.toString(arrayOfStackTraceElement));
        if (arrayOfStackTraceElement == null)
            return null;
        int i = arrayOfStackTraceElement.length;
        int j = 0;
        while (j < i) {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
            if ((localStackTraceElement.isNativeMethod())
                    || (localStackTraceElement.getClassName()
                    .equals(Thread.class.getName()))
                    || (localStackTraceElement.getClassName().equals(ZLog.class
                    .getName()))) {
                j++;
            } else {
                String str = localStackTraceElement.getFileName();
                if (str.length() >= 5)
                    str = str.substring(0, str.length() - 5);
                TAG = str;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[");
                localStringBuilder.append(localStackTraceElement
                        .getMethodName());
                localStringBuilder.append(":");
                localStringBuilder.append(localStackTraceElement
                        .getLineNumber());
                localStringBuilder.append("]");
                return localStringBuilder.toString();
            }
        }
        return null;
    }

    public static void i(Object paramObject) {
        if (PRINT_LOG) {
            String str1 = getFunctionName();
            if (str1 != null) {
                String str2 = TAG;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str1);
                localStringBuilder.append(" - ");
                localStringBuilder.append(paramObject);
                Log.i(str2, localStringBuilder.toString());
                return;
            }
            Log.i(TAG, paramObject.toString());
        }
    }

    public static void v(Object paramObject) {
        if (PRINT_LOG) {
            String str1 = getFunctionName();
            if (str1 != null) {
                String str2 = TAG;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str1);
                localStringBuilder.append(" - ");
                localStringBuilder.append(paramObject);
                Log.v(str2, localStringBuilder.toString());
                return;
            }
            Log.v(TAG, paramObject.toString());
        }
    }

    public static void w(Object paramObject) {
        if (PRINT_LOG) {
            String str1 = getFunctionName();
            if (str1 != null) {
                String str2 = TAG;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str1);
                localStringBuilder.append(" - ");
                localStringBuilder.append(paramObject);
                Log.w(str2, localStringBuilder.toString());
                return;
            }
            Log.w(TAG, paramObject.toString());
        }
    }
}

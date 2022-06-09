package com.wd.demo.util;

import android.app.Instrumentation;
import android.content.Context;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;

import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * 系统值相关的类
 *
 * @author ZH-SW-Wudi
 */
public class SystemUtil {

    /**
     * 通过反射获取系统prop的值
     *
     * @param context
     * @param key
     * @return
     * @throws IllegalArgumentException
     */
    public static String getProp(Context context, String key)
            throws IllegalArgumentException {
        String ret = "";
        try {
            ClassLoader cl = context.getClassLoader();
            @SuppressWarnings("rawtypes")
            Class SystemProperties = cl
                    .loadClass("android.os.SystemProperties");
            // 参数类型
            @SuppressWarnings("rawtypes")
            Class[] paramTypes = new Class[1];
            paramTypes[0] = String.class;
            Method get = SystemProperties.getMethod("get", paramTypes);
            // 参数
            Object[] params = new Object[1];
            params[0] = new String(key);
            ret = (String) get.invoke(SystemProperties, params);
        } catch (IllegalArgumentException iAE) {
            throw iAE;
        } catch (Exception e) {
            ret = "";
        }
        return ret;
    }

    public static String getProp(String key) {
        try {
            Class SystemProperties = Class.forName("android.os.SystemProperties");
            //获取方法
            Class[] paramTypes = new Class[1];
            paramTypes[0] = String.class;
            Method get = SystemProperties.getMethod("get", paramTypes);
            //参数
            Object[] params = new Object[1];
            params[0] = new String(key);
            return (String) get.invoke(SystemProperties, params);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 设置系统时间
     */
    public static void setSysTime() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 10);
        long time = c.getTimeInMillis();
        SystemClock.setCurrentTimeMillis(time);
    }

    /**
     * 发送系统按键
     */
    public static void sendBack() {
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 设置int类型系统值
     */
    public static void setSystemValue(Context context, String key, int value) {
        Log.i("wd", "key:" + key + "  value:" + value);
        Settings.System.putInt(context.getContentResolver(), key, value);
    }

    /**
     * 获取int类型系统值
     */
    public static int getSystemValue(Context context, String key, int def) {
        int value = Settings.System.getInt(context.getContentResolver(), key,
                def);
        Log.i("wd", "getSystemValue  key:" + key + ", def:" + def
                + ", value:" + value);
        return value;
    }
}

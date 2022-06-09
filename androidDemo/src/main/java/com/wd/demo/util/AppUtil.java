package com.wd.demo.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AppUtil {

    public static void startCarLifeService(Context context) {
        Log.d("wudi", "startCarLifeService");
        Intent intent = new Intent();
        intent.setAction("com.adayo.carlife.service");
        intent.setPackage("com.adayo.carlife.service");
        context.startService(intent);
    }

    /**
     * 通过包名，类名启动界面
     *
     * @param mContext
     * @param packageName
     * @param className
     */
    public static void startActivity(Context mContext, String packageName, String className) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName(packageName, className);
        intent.setComponent(cn);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}

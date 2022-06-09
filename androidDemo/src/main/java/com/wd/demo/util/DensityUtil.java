package com.wd.demo.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class DensityUtil {

    private static final String TAG = "DensityUtil";
    /**
     * 修改屏幕宽度的dp值
     */
    public static float fixedWidthDp = 360f;
    private static float appDensity;
    private static float appScaleDensity;
    private static int screenWidth;

    public static void setDensity(final Application application, float widthDp) {
        fixedWidthDp = widthDp;
        if (appDensity == 0) {
            DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
            appDensity = appDisplayMetrics.density;
            appScaleDensity = appDisplayMetrics.scaledDensity;
            screenWidth = appDisplayMetrics.widthPixels;
            int height = appDisplayMetrics.heightPixels;
            Log.d(TAG, "setDensity appDensity = " + appDensity);
            Log.d(TAG, "setDensity appScaleDensity = " + appScaleDensity);
            Log.d(TAG, "setDensity screenWidth = " + screenWidth);
            Log.d(TAG, "setDensity height = " + height);

            /** activity create时改变density*/
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                    setCustomDensity(activity);
                }

                @Override
                public void onActivityStarted(Activity activity) {

                }

                @Override
                public void onActivityResumed(Activity activity) {

                }

                @Override
                public void onActivityPaused(Activity activity) {

                }

                @Override
                public void onActivityStopped(Activity activity) {

                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                }

                @Override
                public void onActivityDestroyed(Activity activity) {

                }
            });

            /** 系统字体改变监听*/
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        appScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
    }

    public static void setCustomDensity(Context activity) {

        float targetDensity = screenWidth / fixedWidthDp;//修改后的密度因子
        float targetDensityDpi = targetDensity * 160;//修改后的密度
        float targetScaleDensity = appScaleDensity * (targetDensity / appDensity);//跟字体大小有关，一起缩放

        DisplayMetrics activityMetrics = activity.getResources().getDisplayMetrics();
        activityMetrics.density = targetDensity;
        activityMetrics.densityDpi = (int) targetDensityDpi;
        activityMetrics.scaledDensity = targetScaleDensity;

        Log.d(TAG, "setDensity targetDensity = " + targetDensity);
        Log.d(TAG, "setDensity targetDensityDpi = " + targetDensityDpi);
        Log.d(TAG, "setDensity targetScaleDensity = " + targetScaleDensity);
        Log.d(TAG, "setDensity width = " + activityMetrics.widthPixels);
        Log.d(TAG, "setDensity height = " + activityMetrics.heightPixels);
    }
}

package com.wd.demo.base;

import android.app.Application;
import android.content.Context;

import com.wd.demo.hook.HookActivity1;
import com.wd.demo.hook.HookUtil;

public class MyApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        HookUtil hookAmsUtil = new HookUtil(HookActivity1.class, this);
        hookAmsUtil.hookSystemHandler();
        hookAmsUtil.hookAms();

    }

    public static Context getContext() {
        return mContext;
    }

}

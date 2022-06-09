package com.wd.demo.base;

import android.app.Application;
import android.content.Context;

import com.wd.demo.hook.HookActivity1;
import com.wd.demo.hook.HookUtil;
import com.wd.demo.ui.LogMonitor;

public class MyApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
//        hookAms();
        monitorHandler();
    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * hook启动管理
     */
    private void hookAms(){
        HookUtil hookAmsUtil = new HookUtil(HookActivity1.class, this);
        hookAmsUtil.hookSystemHandler();
        hookAmsUtil.hookAms();
        monitorHandler();
    }

    /**
     * 监控handler
     */
    private void monitorHandler(){
        LogMonitor.getInstance().start();
    }

}

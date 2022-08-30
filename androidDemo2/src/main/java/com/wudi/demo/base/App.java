package com.wudi.demo.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wudi.demo.utils.FpsUtils;

/**
 * @author wudi
 * @desc
 * @time 2022-08-05 15:55
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        FpsUtils.getFps();
        ARouter.openLog();     // Print log
        ARouter.openDebug();
        ARouter.init(this);
    }
}

/**
 *
 */
package com.wd.demo.util;

import android.content.Intent;

import com.wd.demo.MainActivity;
import com.wd.demo.base.MyApp;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-16 下午4:21:10 <br/>
 *
 */
public class AppManager {

    private AppManager() {

    }

    public static AppManager getInstance() {
        return Inner.mInstance;
    }

    private static class Inner {
        private static AppManager mInstance = new AppManager();
    }

    public void startMainActivity() {
        Intent intent = new Intent(MyApp.getContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApp.getContext().startActivity(intent);
    }
}

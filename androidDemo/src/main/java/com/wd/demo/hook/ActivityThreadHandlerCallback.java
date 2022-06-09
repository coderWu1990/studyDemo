/**
 *
 */
package com.wd.demo.hook;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.reflect.Field;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-4-19 下午9:10:07 <br/>
 *
 */
public class ActivityThreadHandlerCallback implements Handler.Callback {

    private Handler handler;

    ActivityThreadHandlerCallback(Handler handler) {
        this.handler = handler;
    }

    @Override
    public boolean handleMessage(Message msg) {
        Log.i("HookUtil", "handleMessage");
        // 替换之前的Intent
        if (msg.what == 100) {
            Log.i("HookUtil", "lauchActivity");
            handleLauchActivity(msg);
        }

        handler.handleMessage(msg);
        return true;
    }

    private void handleLauchActivity(Message msg) {
        Object obj = msg.obj;// ActivityClientRecord
        try {
            Field intentField = obj.getClass().getDeclaredField("intent");
            intentField.setAccessible(true);
            Intent proxyInent = (Intent) intentField.get(obj);
            Intent realIntent = proxyInent.getParcelableExtra("oldIntent");
            if (realIntent != null) {
                proxyInent.setComponent(realIntent.getComponent());
            }
        } catch (Exception e) {
            Log.i("HookUtil", "lauchActivity falied");
        }

    }
}
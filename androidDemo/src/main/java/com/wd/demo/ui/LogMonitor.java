/**
 *
 */
package com.wd.demo.ui;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-17 下午9:02:56 <br/> 
 *
 */
public class LogMonitor {
    private static final long DELAY = 50L;
    private static final int MSG_ONE = 1;
    private Handler mHandler;

    private LogMonitor() {
        HandlerThread handlerThread = new HandlerThread("log");
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                super.handleMessage(msg);
                if (msg.what == MSG_ONE) {
                    StringBuilder sb = new StringBuilder();
                    StackTraceElement[] elements = Looper.getMainLooper().getThread().getStackTrace();
                    for (StackTraceElement e : elements) {
                        sb.append(e + "\n");
                    }
                    Log.i("wd", "MSG_ONE=" + sb.toString());
                }
            }
        };
    }

    public static LogMonitor getInstance() {
        return Inner.mInstance;
    }

    private static class Inner {
        private static LogMonitor mInstance = new LogMonitor();
    }


    public void start() {
        mHandler.sendEmptyMessageDelayed(MSG_ONE, DELAY);
    }

    public void remove() {
        mHandler.removeMessages(MSG_ONE);
    }

    public boolean isMonitor() {
        return mHandler.hasMessages(MSG_ONE);
    }

}

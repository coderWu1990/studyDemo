package com.wd.demo.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

public class SendIntervalUtil {

    private static HandlerThread mHandlerThread;
    private static Handler mHandler;

    static {
        mHandlerThread = new HandlerThread("send");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
    }

    /**
     * 发送串口指令(可以控制发送间隔)
     */
    public static void sendData(final String str) {
        mHandler.post(new MyRun() {
            @Override
            void doRun() {
                Log.i("wd", "发送：" + str + " " + Thread.currentThread().getName());
            }
        });
    }

    /**
     * 控制串口发送数据间隔不低于50s
     *
     * @author ZH-SW-Wudi
     */
    private static abstract class MyRun implements Runnable {
        @Override
        public void run() {
            doRun();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        abstract void doRun();
    }

}
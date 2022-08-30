package com.wudi.demo.utils;

import android.os.Build;
import android.util.Log;
import android.view.Choreographer;

/**
 * @author wudi
 * @desc
 * @time 2022-08-15 17:21
 */
public class FpsUtils {
    private static volatile long count = 0;
    public static void getFps() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i("test","当前帧率="+count);
                    count=0;
                }
            }
        }).start();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                count++;
                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }
}

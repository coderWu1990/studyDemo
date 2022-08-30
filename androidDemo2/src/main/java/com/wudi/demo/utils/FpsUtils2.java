package com.wudi.demo.utils;

import android.os.Build;
import android.util.Log;
import android.view.Choreographer;

/**
 * @author wudi
 * @desc
 * @time 2022-08-15 19:41
 */
public class FpsUtils2 {
    private static long mStartFrameTIme = 0;
    private static int mFrameCount = 0;
    private static final long MONITOR_INTERVAL = 160L;

    public static void getFps() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                if (mStartFrameTIme == 0) {
                    mStartFrameTIme = frameTimeNanos;
                }
                float interval = (frameTimeNanos - mStartFrameTIme) / 1000000.0f;
                if (interval > MONITOR_INTERVAL) {
                    double fps = ((double) mFrameCount * 1000L) / interval;
                    Log.e("test", "fps:" + fps);
                    mFrameCount = 0;
                    mStartFrameTIme = 0;
                } else {
                    ++mFrameCount;
                }
                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }
}

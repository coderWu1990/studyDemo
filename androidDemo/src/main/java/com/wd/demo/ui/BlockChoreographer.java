/**
 *
 */
package com.wd.demo.ui;

import android.view.Choreographer;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-17 下午9:18:47 <br/> 
 *
 */
public class BlockChoreographer {

    public static void start() {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {

            @Override
            public void doFrame(long l) {
                // TODO Auto-generated method stub
                if (LogMonitor.getInstance().isMonitor()) {
                    LogMonitor.getInstance().remove();
                }
                LogMonitor.getInstance().start();
                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }
}

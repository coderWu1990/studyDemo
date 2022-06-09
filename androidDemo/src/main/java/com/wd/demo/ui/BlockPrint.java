/**
 *
 */
package com.wd.demo.ui;

import android.os.Looper;
import android.util.Printer;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-17 下午8:32:25 <br/>
 *
 */
public class BlockPrint {

    public static void start() {
        Looper.getMainLooper().setMessageLogging(new Printer() {
            private static final String START = ">>>>> Dispatching";
            private static final String END = "<<<<< Finished";

            @Override
            public void println(String x) {
                if (x.startsWith(START)) {
//					System.out.println("开始"+x);
                    LogMonitor.getInstance().start();
                }
                if (x.startsWith(END)) {
//					System.out.println("结束"+x);
                    LogMonitor.getInstance().remove();
                }
            }
        });
    }
}

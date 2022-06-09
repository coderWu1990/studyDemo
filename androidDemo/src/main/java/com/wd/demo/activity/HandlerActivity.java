/**
 *
 */
package com.wd.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;

import com.wd.demo.R;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-4-6 上午9:59:17 <br/>
 *
 */
public class HandlerActivity extends Activity {

    private HandlerThread mHandlerThread;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandlerThread = new HandlerThread("test");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper()) {
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case 1:
                        Log.i("wd", "handleMessage =1");
                        circleSend();
                        break;

                    default:
                        break;
                }
            }

            ;
        };

        setContentView(R.layout.activity_handler);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("wd", "start");
                mHandler.sendEmptyMessage(1);
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("wd", "stop");
                mHandler.removeMessages(1);
            }
        });
    }


    private void circleSend() {
        Log.i("wd", "circleSend sleep");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("wd", "circleSend send");
        mHandler.sendEmptyMessageDelayed(1, 2000);
    }
}

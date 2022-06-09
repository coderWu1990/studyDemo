package com.wd.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.util.Log;
import android.view.View;

import com.wd.demo.hook.TargetActivity;
import com.wd.demo.util.WindowSizeUtil;
import com.wd.demo.util.ZLog;
import com.wd.demo.util.reflex.PrivateMethod;
import com.wd.demo.util.reflex.PublicMethod;
import com.wd.demo.util.test.SpaseUtil;
import com.wd.demo.widget.CustomView;
import com.wd.demo.widget.water.Water;
import com.wd.demo.widget.water.WaterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Context mContext;
    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomView = (CustomView) findViewById(R.id.custom);
        mContext = this;
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                doOnClick();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                doOnClick2();
            }
        });
        init();
    }

    private void init() {
        ZLog.i(Build.SERIAL);
//		testIdleHandler();
        // initWaterView();
//		startActivity();
    }

    private void startActivity() {
        startActivity(new Intent(this, TargetActivity.class));
    }

    private void doOnClick() {
        Log.i("wd", "doOnClick");
        startActivity();
//		LruUtil.test1();
//		reflex();
//		getSize();
//		clickTestIdleHandler();
//		Log.i("wd", SystemUtil.getProp("sys.usb.config"));
//		mCustomView.requestLayout();
        SpaseUtil.put();
    }

    private void doOnClick2() {
        Log.i("wd", "doOnClick2");
//		LruUtil.test2();
//		mCustomView.invalidate();
        SpaseUtil.del();
    }

    @Override
    protected void onPause() {
        Log.i("wd", "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("wd", "onStop");
        super.onStop();
        // AppManager.getInstance().startMainActivity();
    }

    @Override
    protected void onDestroy() {
        Log.i("wd", "onDestroy");
        super.onDestroy();
    }

    private void initWaterView() {
        WaterView mWaterView = (WaterView) findViewById(R.id.wv_water);
        List<Water> mWaters = new ArrayList<Water>();
        for (int i = 0; i < 10; i++) {
            mWaters.add(new Water((int) (i + Math.random() * 4), "item" + i));
        }
        mWaterView.setWaters(mWaters);
        // reset mWaterView.setWaters(mWaters);
    }

    private void reflex() {
        PrivateMethod pm = new PrivateMethod();
        Log.i("wd", "doOnClick1=" + pm.getNa());
        PublicMethod.setPriVar();
        Log.i("wd", "doOnClick2=" + pm.getNa());
        try {
            PublicMethod.setSomeFields(new PrivateMethod());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSize() {
        Log.i("wd", "" + WindowSizeUtil.getMaxHeight(mContext));
        Log.i("wd", "" + WindowSizeUtil.getMaxWidth(mContext));
        Log.i("wd", "" + WindowSizeUtil.getStatusBarHeight(mContext));
        Log.i("wd", "" + WindowSizeUtil.getNavigationBarHeight(mContext));
    }

    private void testIdleHandler() {
        Looper.myQueue().addIdleHandler(new IdleHandler() {

            @Override
            public boolean queueIdle() {
                Log.i("wd", "queueIdle " + Thread.currentThread().getName());
                return false;
            }
        });
    }

    private void clickTestIdleHandler() {
        // 添加第一个 IdleHandler
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            @Override
            public boolean queueIdle() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("wd", "IdleHandler1 queueIdle " + Thread.currentThread());
                return false;
            }
        });
        // 添加第二个 IdleHandler
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            @Override
            public boolean queueIdle() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("wd", "IdleHandler2 queueIdle");
                return false;
            }
        });
        Handler handler = new Handler();
        // 添加第一个Message
        Message message1 = Message.obtain(handler, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("wd", "message1");
            }
        });
        message1.sendToTarget();
        // 添加第二个Message
        Message message2 = Message.obtain(handler, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("wd", "message2");
            }
        });
        message2.sendToTarget();
    }

}

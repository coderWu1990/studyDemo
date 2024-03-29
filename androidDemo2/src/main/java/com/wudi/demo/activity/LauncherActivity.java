package com.wudi.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wd.jni.Math;
import com.wudi.demo.config.RouteConst;
import com.wudi.demo.utils.DnsUtils;

/**
 * @author wudi
 * @desc
 * @time 2022-08-05 17:46
 */
public class LauncherActivity extends AppCompatActivity {
    static {
        System.loadLibrary("jnitest");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startActivity(new Intent(this,SsidActivity.class));

//        ARouter.getInstance().build(RouteConst.APP_TEST).navigation();
        DnsUtils.testDns();
        Log.i("","sum="+Math.sum(122,12332));
        Log.i("","sum="+Math.getStr());
    }

}

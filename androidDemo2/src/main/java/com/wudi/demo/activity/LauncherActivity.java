package com.wudi.demo.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wudi.demo.config.RouteConst;

/**
 * @author wudi
 * @desc
 * @time 2022-08-05 17:46
 */
public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startActivity(new Intent(this,SsidActivity.class));

        ARouter.getInstance().build(RouteConst.APP_TEST).navigation();
    }
}

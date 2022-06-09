package com.wd.demo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 *
 */

public class TestDialog extends Dialog {

    public TestDialog(@NonNull Context context) {
        super(context);
        initView(context);

    }

    private void initView(Context context) {
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        // (下面不获取焦点-FLAG_NOT_FOCUSABLE，下面的可以获取到焦点-FLAG_NOT_TOUCH_MODAL，监听外部点击事件-FLAG_WATCH_OUTSIDE_TOUCH)
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        // 开始想使用悬浮窗方式，但是小米手机会有问题
        // params.type = WindowManager.LayoutParams.TYPE_TOAST;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = 300;
        params.gravity = Gravity.TOP;
        window.setAttributes(params);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setDimAmount(0);

        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.BLACK);
        textView.setText("这里是顶级view");
        textView.setTextSize(10);
        textView.setTextColor(Color.RED);

        setContentView(textView);
        setCancelable(false);// 返回键不消失
        hideSystemUI(textView);

    }

    // 盖在状态栏上
    public void hideSystemUI(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    // //沉浸式
    // public void hideSystemUI(View view) {
    // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
    // view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    // | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    // | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    // | View.SYSTEM_UI_FLAG_FULLSCREEN
    // | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    // | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    // );
    // }
    // }

}
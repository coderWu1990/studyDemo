package com.wd.demo.window;

/**
 *
 */

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;

import com.wd.demo.R;

public class WindowUtils {

    private static ImageView mView = null;
    private static WindowManager mWindowManager = null;
    private static Context mContext = null;
    private static volatile boolean isShow = false;

    public static void showWindow(final Context context) {
        if (isShow) {
            return;
        }
        Toast.makeText(context, "showPopupWindow1", Toast.LENGTH_SHORT).show();
        // 获取应用的Context
        mContext = context.getApplicationContext();
        // 获取WindowManager
        mWindowManager = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);

        mView = new ImageView(context);
        mView.setImageResource(R.drawable.ic_launcher);

        final LayoutParams params = new LayoutParams();

        // 类型
        params.type = LayoutParams.TYPE_SYSTEM_ALERT;

        // 设置flag
        // 如果设置了WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE，弹出的View收不到Back键的事件
        params.flags = params.flags
                | LayoutParams.FLAG_NOT_FOCUSABLE;
        // 不设置这个弹出框的透明遮罩显示为黑色
        params.format = PixelFormat.TRANSLUCENT;
        // FLAG_NOT_TOUCH_MODAL不阻塞事件传递到后面的窗口
        // 设置 FLAG_NOT_FOCUSABLE 悬浮窗口较小时，后面的应用图标由不可长按变为可长按

        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;

        params.gravity = Gravity.CENTER;
        mWindowManager.addView(mView, params);
        isShow = true;
    }

    public static void removeWindow() {
        if (mView != null && isShow) {
            mWindowManager.removeView(mView);
//			mWindowManager.removeViewImmediate(mView);
            isShow = false;
        }
    }

}
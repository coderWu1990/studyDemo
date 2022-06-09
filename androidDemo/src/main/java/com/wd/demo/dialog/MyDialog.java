package com.wd.demo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.WindowManager;

import com.wd.demo.R.layout;

public class MyDialog extends Dialog {

    public MyDialog(Context context) {

        super(context, 0);
        setContentView(layout.dialog_test);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        lp.flags |= WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                | WindowManager.LayoutParams.FLAG_TOUCHABLE_WHEN_WAKING;
        getWindow().setAttributes(lp);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }
}

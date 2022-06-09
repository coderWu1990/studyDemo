package com.wd.demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View {
    private static final String TAG = "custom";

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG, "CustomView");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        Log.i(TAG, "onMeasure width=" + width + " height=" + height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right,
                            int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG, "onLayout left=" + left + " top=" + top + " right=" + right + " bottom=" + bottom
        );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw");
    }
}

package com.wd.demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.wd.demo.util.test.PaintUtil;

public class MyView extends View {

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.i("wd", "MyView 构造");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        Log.i("wd", "onMeasure " + width + " " + height);
        int mode1 = MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = MeasureSpec.getMode(heightMeasureSpec);
        Log.i("wd", "mode " + mode1 + " " + mode2);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right,
                            int bottom) {
        Log.i("wd", "onLayout" + " left=" + left + " top=" + top + " right="
                + right + " bottom=" + bottom);
        super.onLayout(changed, left, top, 100, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("wd", "onDraw");
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(new RectF(0, 0, 100, 100), paint);
        canvas.drawLine(0, 50, 100, 50, paint);
        canvas.drawLine(50, 0, 50, 100, paint);
        // canvas.drawText("A", 50, 50, paint);

        String text = "A";
        paint.setTextSize(30);
        float width = PaintUtil.getTextWidth(text, paint);
        float height = PaintUtil.getTextHeight(text, paint);
        Log.i("wd", "onDraw" + width + "<>" + height);
        canvas.drawText("A", 50 - (width / 2), 50 + (height / 2), paint);
        canvas.drawCircle(50, 50, 20, paint);
    }

}

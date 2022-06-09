/**
 *
 */
package com.wd.demo.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 爱心图
 * @author ZH-SW-Wudi
 * @date: 2021-3-30 下午9:20:59 <br/>
 *
 */
public class HeartView extends View {

    /**
     * @param context
     * @param attrs
     */
    public HeartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private static final int PATH_WIDTH = 2;
    // 起始点
    private static final int[] START_POINT = new int[]{300, 270};
    // 爱心下端点
    private static final int[] BOTTOM_POINT = new int[]{300, 400};
    // 左侧控制点
    private static final int[] LEFT_CONTROL_POINT = new int[]{450, 200};
    // 右侧控制点
    private static final int[] RIGHT_CONTROL_POINT = new int[]{150, 200};
    private Paint mPaint;
    private Path mPath;


    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Style.STROKE);
        mPaint.setStrokeWidth(PATH_WIDTH);
        mPaint.setColor(Color.RED);

        mPath = new Path();
        mPath.moveTo(START_POINT[0], START_POINT[1]);
        mPath.quadTo(RIGHT_CONTROL_POINT[0], RIGHT_CONTROL_POINT[1],
                BOTTOM_POINT[0], BOTTOM_POINT[1]);
        mPath.quadTo(LEFT_CONTROL_POINT[0], LEFT_CONTROL_POINT[1],
                START_POINT[0], START_POINT[1]);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mPath, mPaint);

        canvas.drawCircle(RIGHT_CONTROL_POINT[0], RIGHT_CONTROL_POINT[1], 5,
                mPaint);
        canvas.drawCircle(LEFT_CONTROL_POINT[0], LEFT_CONTROL_POINT[1], 5,
                mPaint);
    }
}
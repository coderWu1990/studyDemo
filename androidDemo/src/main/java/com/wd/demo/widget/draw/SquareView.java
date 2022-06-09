/**
 *
 */
package com.wd.demo.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 缩放迷宫
 * @author ZH-SW-Wudi
 * @date: 2021-3-30 下午7:23:23 <br/> 
 *
 */
public class SquareView extends View {

    /**
     * @param context
     * @param attrs
     */
    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        drawSquare(canvas);

    }

    private Paint mPaint;

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 将画笔设置为空心
        mPaint.setStyle(Style.STROKE);
        // 设置画笔颜色
        mPaint.setColor(Color.WHITE);
        // 设置画笔宽度
        mPaint.setStrokeWidth(5);
    }

    /**
     * 绘制正方形
     *
     * @param canvas
     */
    private void drawSquare(Canvas canvas) {
        for (int i = 0; i < 20; i++) {
            // 保存画布
            canvas.save();
            float fraction = (float) i / 20;
            // 将画布以正方形中心进行缩放
            canvas.scale(fraction, fraction, 200, 200);
            canvas.drawRect(new Rect(0, 0, 400, 400), mPaint);
            // 画布回滚
            canvas.restore();
        }
    }


}

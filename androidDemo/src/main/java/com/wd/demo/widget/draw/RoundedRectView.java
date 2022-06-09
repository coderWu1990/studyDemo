/**
 *
 */
package com.wd.demo.widget.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 圆角矩形
 *
 * @author ZH-SW-Wudi
 * @date: 2021-4-1 下午2:26:31 <br/>
 *
 */
public class RoundedRectView extends View {

    /**
     * @param context
     * @param attrs
     */
    public RoundedRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        // 创建画笔
        Paint p = new Paint();
        p.setColor(Color.RED);// 设置红色
        // 画圆角矩形
        p.setStyle(Paint.Style.FILL);// 充满
        p.setAntiAlias(true);// 设置画笔的锯齿效果

        RectF oval3 = new RectF(80, 80, 200, 85);// 设置个新的长方形
        canvas.drawRoundRect(oval3, 25, 25, p);// 第二个参数是x半径，第三个参数是y半径
    }

}

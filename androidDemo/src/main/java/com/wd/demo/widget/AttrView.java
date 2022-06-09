/**
 *
 */
package com.wd.demo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.wd.demo.R;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-29 下午9:24:10 <br/>
 *
 */
public class AttrView extends View {

    public AttrView(Context context) {
        this(context, null);
        Log.i("wd", "AttrView1");
    }

    /**
     * @param context
     * @param attrs
     */
    public AttrView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Log.i("wd", "AttrView2");
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public AttrView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        Log.i("wd", "AttrView3");
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs,
                    R.styleable.AttrView);
            Drawable leftDrawable = array
                    .getDrawable(R.styleable.AttrView_title_left_icon);
            Drawable rightDrawable = array
                    .getDrawable(R.styleable.AttrView_title_right_icon);
            CharSequence titleText = array
                    .getString(R.styleable.AttrView_title_bar_title_text);
            int titleTextColor = array.getColor(
                    R.styleable.AttrView_title_bar_text_color, Color.BLACK);
            Log.i("wd", "titleText=" + titleText);
            Log.i("wd", "titleTextColor=" + Integer.toHexString(titleTextColor));
            // 如果不调用recycle，As会有提示
            array.recycle();
        }
    }

    /* (non-Javadoc)
     * @see android.view.View#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        canvas.drawCircle(50, 50, 20, new Paint());
    }

}

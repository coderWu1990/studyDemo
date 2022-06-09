/**
 *
 */
package com.wd.demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 单选，有指示线view
 * @author ZH-SW-Wudi
 * @date: 2021-3-5 下午3:00:21 <br/>
 *
 */
public class CheckOneView extends LinearLayout {

    private static final LayoutParams LAYOUT_PARAMS = new LayoutParams(
            0, LayoutParams.MATCH_PARENT, 1);

    private List<String> mDatas = new ArrayList<String>();
    private int mSelectPosition = 0;
    private Context mContext;

    private int indicatorHeight = 5;
    private int lineWidth = 30;
    private float defulatSize = 20;
    private float selectSize = 25;
    private int defulatColor = 0xFFA1A7AC;
    private int selectColor = 0xFF009AD3;

    private Paint rectPaint;

    public CheckOneView(Context context) {
        super(context);
        init(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public CheckOneView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        initPaint();
    }

    public void setData(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        mDatas.clear();
        mDatas.addAll(list);
        for (int i = 0; i < list.size(); i++) {
            addTextTab(i, list.get(i));
        }
    }

    private void addTextTab(final int position, String title) {
        TextView tex = new TextView(mContext);
        tex.setGravity(Gravity.CENTER);
        tex.setText(title);
        this.addView(tex, position, LAYOUT_PARAMS);
        tex.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setCurrentItem(position);
            }
        });
    }

    private void setCurrentItem(int position) {
        mSelectPosition = position;
        invalidate();
        notifyCheckListener(position);
    }

    private void updateTabStyles() {
        for (int i = 0; i < getDataSize(); i++) {
            View tex = this.getChildAt(i);
            if (tex instanceof TextView) {
                if (i == mSelectPosition) {
                    ((TextView) tex).setTextColor(selectColor);
                    ((TextView) tex).setTextSize(selectSize);
                } else {
                    ((TextView) tex).setTextColor(defulatColor);
                    ((TextView) tex).setTextSize(defulatSize);
                }

            }
        }
    }

    private void initPaint() {
        rectPaint = new Paint();
        rectPaint.setAntiAlias(true);
        rectPaint.setStyle(Style.FILL);
        rectPaint.setColor(selectColor);
    }

    private int getDataSize() {
        return mDatas == null ? 0 : mDatas.size();
    }

    private int getlineLeft() {
        int width = getWidth();
        int itemWidth = width / getDataSize();
        return mSelectPosition * itemWidth + (itemWidth - lineWidth) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getDataSize() == 0) {
            return;
        }
        int height = getHeight();
        int lineLeft = getlineLeft();
        canvas.drawRect(lineLeft, height - indicatorHeight, lineLeft
                + lineWidth, height, rectPaint);
        updateTabStyles();
    }

    private ICheckListener mListener;

    public void setOnCheckListener(ICheckListener listener) {
        mListener = listener;
    }

    public interface ICheckListener {
        void onItemCheck(int position);
    }

    private void notifyCheckListener(int position) {
        if (mListener != null) {
            mListener.onItemCheck(position);
        }
    }

}

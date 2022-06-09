package com.wd.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 限制文本长度，过长用点显示
 *
 * @author ZH-SW-Wudi
 */
public class BackTexView extends TextView {
    /**
     * 限制的最大长度
     */
    private static final int MAX_LENGTH = 24;
    /**
     * 前缀字符
     */
    private static final String PRE_FIX = "...";

    public BackTexView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start,
                                 int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        String str = text.toString();
        if (str == null) {
            return;
        }
        //有前缀的时候不处理
        if (str.indexOf(PRE_FIX) != 0) {
            if (str.length() > MAX_LENGTH) {
                str = str.substring(str.length() - MAX_LENGTH);
                this.setText(PRE_FIX + str);
            }
        }

    }


}

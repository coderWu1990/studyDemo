/**
 *
 */
package com.wd.demo.util.test;

import android.graphics.Paint;
import android.graphics.Rect;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-25 下午4:48:13 <br/> 
 *
 */
public class PaintUtil {
    /**
     * 获取字符串的宽度
     * @param text
     * @param Size
     * @return
     */
    public static float getTextWidth(String text, Paint paint) {
        return paint.measureText(text);
    }

    /**
     * 测量文字的高度
     * @param paint
     * @param textTemp
     * @return
     */
    public static float getTextHeight(String text, Paint paint) {
        float height = 0f;
        if (null == paint) {
            return height;
        }
        Rect rectFont = new Rect();
        paint.getTextBounds(text, 0, text.length(), rectFont);
        height = rectFont.height();
        return height;
    }
}

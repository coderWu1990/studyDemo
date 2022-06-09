package com.wd.demo.util;

import android.text.Html;

public class FontUtil {

    public static CharSequence getFontStr(String s1, String s2) {
        String text = "<font color='white'>" + s1 + "</font>"
                + "<font color='yellow'>(" + s2 + ")</font>";
        return Html.fromHtml(text);
    }

}

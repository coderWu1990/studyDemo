package com.wd.demo.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtil {
    private static final String NAME = "sp_name";

    public static void putValue(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(NAME,
                Context.MODE_PRIVATE);
        sp.edit().putString(key, value);
        sp.edit().apply();
        sp.edit().commit();
    }
}

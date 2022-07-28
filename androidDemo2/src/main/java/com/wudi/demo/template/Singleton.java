package com.wudi.demo.template;

import android.content.Context;
import android.view.KeyEvent;

/**
 * @author wudi
 * @desc
 * @time 2022-07-19 14:33
 */
public class Singleton {
    private static Singleton singleton;
    private Context context;
    private Singleton(Context context) {
        this.context = context;
    }

    public static Singleton newInstance(Context context) {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null){//双重检查锁定
                    singleton = new Singleton(context);
                }
            }
        }
        return singleton;
    }

    public static void clear(){
        mCallback=null;
    }

    private static KeyEvent.Callback mCallback;

    public static void setCallback(KeyEvent.Callback callback){
        mCallback=callback;
    }
}


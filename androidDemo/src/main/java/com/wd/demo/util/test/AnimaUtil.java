package com.wd.demo.util.test;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class AnimaUtil {
    public static void twinkleAnima(View view) {
        //闪烁  
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        view.setAnimation(alphaAnimation);
        alphaAnimation.start();
    }
}

/**
 *
 */
package com.wd.demo.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.demo.R;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-29 下午6:27:42 <br/>
 *
 */
public class AnimationActivity extends Activity {
    private ImageView mRefresh;
    private TextView mTex;
    //补间动画
    private Animation mRefreshAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation);
        mRefresh = (ImageView) findViewById(R.id.search_refresh);
        mTex = (TextView) findViewById(R.id.tex);
        startAnim();
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//				valueAnim();
//				test();
                test2();
            }
        });
    }

    public void stopAnim() {
        mRefreshAnim.reset();
        mRefresh.clearAnimation();
    }

    public void startAnim() {
        mRefreshAnim = AnimationUtils.loadAnimation(this,
                R.anim.anim_rotate_refresh);
        LinearInterpolator interpolator = new LinearInterpolator(); // 设置匀速旋转，在xml文件中设置会出现卡顿
        mRefreshAnim.setInterpolator(interpolator);
        if (mRefreshAnim != null) {
            mRefresh.startAnimation(mRefreshAnim); // 开始动画
        }
    }

    //属性动画
    private void valueAnim() {
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        anim.setDuration(300);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Object currentValue = animation.getAnimatedValue();
                Log.d("wd", "cuurent value is " + currentValue);
            }
        });
        anim.start();
    }

    //ObjectAnimator
    private void test() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTex, "alpha", 1f, 0f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    private void test2() {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(mTex, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(mTex, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(mTex, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
    }


}

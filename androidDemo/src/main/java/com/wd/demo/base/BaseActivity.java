/**
 * Copyright (c) 深圳市众鸿科技股份有限公司
 *
 * @file_name BaseActivity.java
 * @class com.zhonghong.bluetooth.base.BaseActivity
 * @create 下午3:02:18
 */
package com.wd.demo.base;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


/**
 *
 * <p>
 * </p>
 * 下午3:02:18
 *
 * @author ZH-SW-Wudi
 * @version 1.0.0
 */
public abstract class BaseActivity extends FragmentActivity {

    /**
     * 记录最后的
     */
    private Fragment mLastFragment;

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext = this;
    }

    /**
     * 这个如果不注释掉，会有问题，他会记忆碎片导致不刷新
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected abstract void initView();

    protected abstract void initData();

    /**
     * Fragment显示
     *
     * @param toFragment
     *            需要显示的fragment
     * @param tag
     */
    protected void switchFragment(Fragment toFragment, String tag, int resId) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (mLastFragment != null) {
            if (mLastFragment != toFragment) {
                // 先判断是否被add过
                if (toFragment.isAdded()) {
                    transaction.hide(mLastFragment).show(toFragment);
                } else {
                    transaction.hide(mLastFragment).add(resId, toFragment, tag);
                }
            }
        } else {
            if (!toFragment.isAdded()) {
                transaction.add(resId, toFragment, tag);
            }
        }
        mLastFragment = toFragment;
        transaction.commitAllowingStateLoss();
    }
}

/**
 * Copyright (c) 深圳市众鸿科技股份有限公司
 *
 * @file_name BaseFragment.java
 * @class com.zhonghong.bluetooth.base.BaseFragment
 * @create 下午12:26:21
 */
package com.wd.demo.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

/**
 *
 * <p>
 * </p>
 * 下午12:26:21
 *
 * @author ZH-SW-Wudi
 * @version 1.0.0
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;

    private Fragment mLastFragment;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        mContext = getActivity();
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract void initView(View view);

    protected abstract void initData();
}

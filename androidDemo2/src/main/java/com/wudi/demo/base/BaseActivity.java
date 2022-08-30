package com.wudi.demo.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author wudi
 * @desc 基类
 * @time 2022-07-25 17:41
 */
public abstract class BaseActivity<V extends ViewDataBinding> extends AppCompatActivity {
    private ViewModelProvider mActivityProvider;
    public V binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ARouter.getInstance().inject(this);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        setActivityOrientation();
        binding.setLifecycleOwner(this);
        initBinding();
        initViewModel();
        loadData();
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initBinding();

    protected abstract void initViewModel();

    protected abstract void loadData();

    public ViewModelProvider getActivityViewModelProvider() {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()));
        }
        return mActivityProvider;
    }

    /**
     * 设置页面方向
     */
    protected void setActivityOrientation() {
        try {
            // 强制竖屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

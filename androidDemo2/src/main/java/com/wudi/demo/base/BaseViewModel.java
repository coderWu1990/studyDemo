package com.wudi.demo.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;

/**
 * @author wudi
 * @desc
 * @time 2022-08-05 16:30
 */
public abstract class BaseViewModel extends AndroidViewModel {

    protected LifecycleOwner mLifecycleOwner;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(LifecycleOwner owner) {
        if (mLifecycleOwner == owner) {
            return;
        }
        mLifecycleOwner = owner;
        initRepository(owner);
    }

    /**
     * 初始化仓库
     * @param owner
     */
    protected abstract void initRepository(LifecycleOwner owner);
}

package com.wudi.demo.repository;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.wudi.demo.interfaces.Repository;

/**
 * 需要生命周期绑定的Repository
 * 一般用户activity和fragment中与生命周期相关的数据获取
 * 而application中的就不需要生命周期绑定了
 * @author di23.wu
 */
public abstract class LifecycleRepository implements Repository {
    protected LifecycleOwner mLifecycleOwner;

    public LifecycleRepository(LifecycleOwner owner) {
        this.mLifecycleOwner = owner;
    }

    protected <T> AutoDisposeConverter<T> bindLifecycle() {
        return AutoDispose.autoDisposable(
                AndroidLifecycleScopeProvider.from(mLifecycleOwner, Lifecycle.Event.ON_DESTROY)
        );
    }
}

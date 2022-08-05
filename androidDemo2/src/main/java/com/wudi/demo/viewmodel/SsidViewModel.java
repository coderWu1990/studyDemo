package com.wudi.demo.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.wudi.demo.base.BaseViewModel;
import com.wudi.demo.interfaces.CallBack;
import com.wudi.demo.repository.SsidRepository;

/**
 * @author wudi
 * @desc
 * @time 2022-08-05 16:53
 */
public class SsidViewModel extends BaseViewModel {
    private SsidRepository mRepository;
    private MutableLiveData<String> ssidInfo=new MutableLiveData<>();

    public SsidViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void initRepository(LifecycleOwner owner) {
        mRepository=new SsidRepository(owner);
    }

    public void loadSsidInfo(){
        mRepository.getSsidInfo(new CallBack<String>() {
            @Override
            public void onSuccess(String result) {
                ssidInfo.postValue(result);
            }

            @Override
            public void onFail(int code, String msg) {
                ssidInfo.postValue("");
            }
        });
    }

    public MutableLiveData<String> getSsidInfo() {
        return ssidInfo;
    }
}

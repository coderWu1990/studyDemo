package com.wudi.demo.repository;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;

import com.wudi.demo.interfaces.CallBack;

/**
 * @author wudi
 * @desc
 * @time 2022-08-05 17:02
 */
public class SsidRepository extends LifecycleRepository{

    public SsidRepository(LifecycleOwner owner) {
        super(owner);
    }

    public void getSsidInfo(CallBack<String> callBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("SsidActivity","onSuccess=");
                callBack.onSuccess("hahha");
            }
        }).start();
    }
}

package com.wudi.demo.activity;

import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.Observer;

import com.wudi.demo.R;
import com.wudi.demo.base.BaseActivity;
import com.wudi.demo.databinding.ActivitySsidBinding;
import com.wudi.demo.viewmodel.SsidViewModel;

/**
 * @author wudi
 * @desc
 * @time 2022-08-05 17:25
 */
public class SsidActivity extends BaseActivity<ActivitySsidBinding> {
    private SsidViewModel ssidViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ssid;
    }

    @Override
    protected void initBinding() {
        binding.tvSsid.setText("初始值");
    }

    @Override
    protected void initViewModel() {
        ssidViewModel=getActivityViewModelProvider().get(SsidViewModel.class);
        ssidViewModel.init(this);
        ssidViewModel.getSsidInfo().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i("SsidActivity","onChanged="+s);
                binding.tvSsid.setText("变化值:"+s);
            }
        });
    }

    @Override
    protected void loadData() {
        ssidViewModel.loadSsidInfo();
        startActivity(new Intent(this,DataBindActivity.class));
    }
}

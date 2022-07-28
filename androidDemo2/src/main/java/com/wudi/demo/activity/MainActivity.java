package com.wudi.demo.activity;

import com.wudi.demo.R;
import com.wudi.demo.base.BaseActivity;
import com.wudi.demo.bean.User;
import com.wudi.demo.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initBinding() {
        User user=new User();
        user.setName("孙悟空");
        user.setAge(112);
        binding.setUser(user);
    }

    @Override
    protected void initViewModel() {

    }

    @Override
    protected void loadData() {

    }
}
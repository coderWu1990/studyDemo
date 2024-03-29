package com.wudi.demo.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wudi.demo.R;
import com.wudi.demo.base.BaseActivity;
import com.wudi.demo.bean.User;
import com.wudi.demo.config.RouteConst;
import com.wudi.demo.databinding.ActivityMainBinding;

/**
 * @author di23.wu
 */
@Route(path = RouteConst.PATH_TWO_TEST)
public class DataBindActivity extends BaseActivity<ActivityMainBinding> {

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
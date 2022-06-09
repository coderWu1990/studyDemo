/**
 *
 */
package com.wd.demo.eventbus;

import com.wd.demo.util.ZLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-16 下午6:25:11 <br/>
 *
 */
public class EventTest {

    public void regist() {
        EventBus.getDefault().register(this);
    }

    public void unRegist() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(LoginSeccessEvent event) {
        ZLog.i("onReceive=" + event.getMsg());
    }
}

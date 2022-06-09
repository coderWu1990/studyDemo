/**
 *
 */
package com.wd.demo.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wd.demo.R;
import com.wd.demo.util.ZLog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-16 下午4:57:07 <br/>
 *
 */
public class EventActivity extends Activity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_main);

        EventBus.getDefault().register(this);// 在当前界面注册一个订阅者
        new EventTest().regist();
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplication(), LoginActivity.class);
                startActivity(i);

            }
        });
        textView = (TextView) findViewById(R.id.tv);

    }

    @Subscribe
    // 订阅事件注解 表示当接收接收到消息时运行此方法
    public void onEventMainThread(LoginSeccessEvent event) {

        String msg = event.getMsg(); // 通过event对象获取传递过来信息
        String password = event.getPassword();
        String username = event.getUsername();

        textView.setText(msg);
        ZLog.i("onEventMainThread=" + msg + "/" + username + "/" + password);

    }

    @Subscribe
    public void onEventAsync(LoginSeccessEvent event) {
        ZLog.i("onEventAsync");
    }

    @Subscribe
    public void onEventBackground(LoginSeccessEvent event) {
        ZLog.i("onEventBackground");
    }

    @Subscribe
    public void onEvent(LoginSeccessEvent event) {
        ZLog.i("onEvent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);// 销毁时取消注册,不再接收消息
    }

}

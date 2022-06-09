/**
 *
 */
package com.wd.demo.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wd.demo.R;

import org.greenrobot.eventbus.EventBus;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-16 下午5:01:11 <br/>
 *
 */
public class LoginActivity extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_login);

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginSeccessEvent event = new LoginSeccessEvent();
                event.setMsg("登录成功");
                event.setUsername("张三");
                event.setPassword("123456");
                EventBus.getDefault().post(event);// 此处发送

                close();
            }
        });

    }

    public void close() {
        this.finish();
    }

}

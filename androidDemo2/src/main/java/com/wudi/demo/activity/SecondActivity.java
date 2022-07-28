package com.wudi.demo.activity;

import android.os.Bundle;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.wudi.demo.R;
import com.wudi.demo.template.Singleton;

/**
 * @author wudi
 * @desc
 * @time 2022-07-19 14:35
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Singleton.newInstance(this.getApplicationContext());
        Singleton.setCallback(callback);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Singleton.clear();
        callback=null;
    }

    private KeyEvent.Callback callback=new KeyEvent.Callback() {
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            return false;
        }

        @Override
        public boolean onKeyLongPress(int keyCode, KeyEvent event) {
            return false;
        }

        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            return false;
        }

        @Override
        public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
            return false;
        }
    };
}

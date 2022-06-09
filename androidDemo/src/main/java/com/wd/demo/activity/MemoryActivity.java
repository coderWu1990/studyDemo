/**
 *
 */
package com.wd.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wd.demo.R;

import java.util.ArrayList;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-19 上午10:20:33 <br/> 
 *
 */
public class MemoryActivity extends Activity {
    private ArrayList<byte[]> list = new ArrayList<byte[]>();
    private byte[] bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        showMenory();
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //50M
                bs = new byte[50 * 1024 * 1024];
                list.add(bs);
                showMenory();
            }
        });
    }

    public void showMenory() {
        Log.i("memory", "maxMemory=" + Runtime.getRuntime().maxMemory());//输出最大可用内存
        Log.i("memory", "freeMemory=" + Runtime.getRuntime().freeMemory());//输出当前可用内存
        Log.i("memory", "totalMemory=" + Runtime.getRuntime().totalMemory());
    }

}

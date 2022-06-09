/**
 *
 */
package com.wd.demo.window;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wd.demo.R;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-4-7 下午8:40:40 <br/> 
 *
 */
public class WindowActivity extends Activity {

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("wd", "start");
                WindowUtils.showWindow(WindowActivity.this);
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("wd", "stop");
                WindowUtils.removeWindow();
            }
        });
    }
}

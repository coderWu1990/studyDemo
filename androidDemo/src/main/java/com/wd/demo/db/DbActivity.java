/**
 *
 */
package com.wd.demo.db;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wd.demo.R;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-26 下午3:11:04 <br/> 
 *
 */
public class DbActivity extends Activity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_db);
//		mDataHelper=new AreaDBHelper(mContext);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("wd", "onClick=");
//				mDataHelper.getNumArea("1308569");
                AreaDataManager.getInstance().init(mContext);
            }
        });
    }
}

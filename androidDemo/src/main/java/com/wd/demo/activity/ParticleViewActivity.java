/**
 *
 */
package com.wd.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.ScaleModifier;
import com.wd.demo.R;
import com.wd.demo.widget.draw.DynamicHeartView;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-29 下午9:45:32 <br/>
 *
 */
public class ParticleViewActivity extends Activity {

    private TextView mtex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view);
        mtex = (TextView) findViewById(R.id.tex);
        final DynamicHeartView view = (DynamicHeartView) findViewById(R.id.dyn_view);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("wd", "onClick=");
//				view.startPathAnim(2000);
                test();
            }
        });
    }

    private void test() {
        new ParticleSystem(this, 500, R.drawable.ic_launcher, 5000)
                .setAcceleration(0.00003f, 270)
                .addModifier(new ScaleModifier(0, 1.2f, 1000, 4000))
                .setFadeOut(5000)
                .setRotationSpeedRange(0, 180)
                .emit(mtex, 50);

    }
}

/**
 *
 */
package com.wd.demo.photo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.wd.demo.R;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-18 下午3:48:12 <br/>
 *
 */
public class GlideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ImageView view = (ImageView) findViewById(R.id.img);
        String path = "/storage/emulated/0/2816x2112-2层5jpg.JPG";
        // Glide.buildFileDescriptorModelLoader(MyGlideModule.class, this);
//		Glide.setup(new GlideBuilder(this).setDecodeFormat(DecodeFormat.PREFER_ARGB_8888));
//		Glide.with(this.getApplicationContext()).load(path).into(view);
    }

}

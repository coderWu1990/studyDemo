/**
 *
 */
package com.wd.demo.photo;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.GlideModule;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-18 下午4:25:50 <br/> 
 *
 */
public class MyGlideModule implements GlideModule {

    /* (non-Javadoc)
     * @see com.bumptech.glide.module.GlideModule#applyOptions(android.content.Context, com.bumptech.glide.GlideBuilder)
     */
    @Override
    public void applyOptions(Context arg0, GlideBuilder builder) {
        // TODO Auto-generated method stub
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
    }

    /* (non-Javadoc)
     * @see com.bumptech.glide.module.GlideModule#registerComponents(android.content.Context, com.bumptech.glide.Glide)
     */
    @Override
    public void registerComponents(Context arg0, Glide arg1) {
        // TODO Auto-generated method stub

    }

}

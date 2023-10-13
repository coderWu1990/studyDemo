package com.wd.demo.util;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wudi
 * @desc
 * @time 2023-10-09 20:22
 */
public class AssetUtil {
    /**
     *  读asset里面的文件，存在字节数组里面
     */
    public void readFile(Context context){
        try {
            InputStream inputStream = context.getAssets().open("cfg/output.pcm");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            byte[] total = outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

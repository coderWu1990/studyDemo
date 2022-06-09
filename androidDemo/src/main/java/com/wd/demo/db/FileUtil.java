/**
 *
 */
package com.wd.demo.db;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-30 下午5:32:56 <br/>
 *
 */
public class FileUtil {
    private static final String TAG = "FileUtil";
    private static final int ONE_M = 1 * 1024 * 1024;

    public static boolean copyFile(String fromPath, String destPath) {
        Log.i(TAG, "copyFile fromPath=" + fromPath + " destPath=" + destPath);
        File fromFile = new File(fromPath);
        if (!fromFile.exists()) {
            Log.i(TAG, "fromFile not exists");
            return false;
        }
        File destFile = new File(destPath);
        if (destFile.exists()) {
            if (destFile.length() > ONE_M) {
                Log.i(TAG, "destFile exists");
                return false;
            }
            destFile.delete();
        } else {
            Log.i(TAG, "destFile not exists1");
            destFile.getParentFile().mkdir();
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(fromFile);
            os = new FileOutputStream(destFile);
            // 文件写入
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            // 关闭文件流
            os.flush();
            Log.i(TAG, "copy success");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }

    public static String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);// 判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();// 获取跟目录
            return sdDir.toString();
        }
        return "";
    }

    private static final String DB = "/databases/";

    public static String getDbPath(Context context) {
        return context.getCacheDir().getParent() + DB;
    }

}

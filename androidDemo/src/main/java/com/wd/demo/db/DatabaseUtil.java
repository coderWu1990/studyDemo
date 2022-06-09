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
 * @date: 2021-3-26 下午3:56:21 <br/>
 *
 */
public class DatabaseUtil {

    public static final String DB = "/databases/";

    public static String getDataPath(Context context) {
        return context.getCacheDir().getParent();
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

    public static void copyAssetDb(Context context, String name) {
        String path = getDataPath(context) + DB;
        // 检查 SQLite 数据库文件是否存在
        Log.i("wd", path);
        if (!(new File(path + name)).exists()) {
            // 如 SQLite 数据库文件不存在，再检查一下 database 目录是否存在
            File f = new File(path);
            // 如 database 目录不存在，新建该目录
            if (!f.exists()) {
                f.mkdir();
            }
            try {
                // 得到 assets 目录下我们实现准备好的 SQLite 数据库作为输入流
                InputStream is = context.getAssets().open(name);
                // 输出流,在指定路径下生成db文件
                OutputStream os = new FileOutputStream(path + name);
                // 文件写入
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                // 关闭文件流
                os.flush();
                os.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.i("wd", "ok1");
    }

    public static void copySdcardDb(Context context, String name) {
        String sdPath = getSDPath() + File.separator + name;
        Log.i("wd", "copySdcardDb sdPath=" + sdPath);
        File sdFile = new File(sdPath);
        if (!sdFile.exists()) {
            return;
        }
        String path = getDataPath(context) + DB;
        // 检查 SQLite 数据库文件是否存在
        if (!(new File(path + name)).exists()) {
            // 如 SQLite 数据库文件不存在，再检查一下 database 目录是否存在
            File dbFile = new File(path);
            // 如 database 目录不存在，新建该目录
            if (!dbFile.exists()) {
                dbFile.mkdir();
            }
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(sdFile);
                os = new FileOutputStream(path + name);
                // 文件写入
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                // 关闭文件流
                os.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 关闭文件流
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
        }
        Log.i("wd", "ok");
    }

}

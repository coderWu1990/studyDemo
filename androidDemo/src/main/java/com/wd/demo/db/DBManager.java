/**
 *
 */
package com.wd.demo.db;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-31 下午9:49:31 <br/>
 *
 */

public class DBManager {
    public static SQLiteDatabase mDatabase = null;
    private static Context mContext;
    /**
     * 数据库名字
     */
    public static String DB_NAME = "ExternalDB.db";
    /**
     * 内存DB文件存储路径
     */
    public static String DB_PATH = "";
    private static int BUFFER_SIZE = 40000;

    /**
     * 单例模式：获取DBManager实例
     *
     * @param context
     * @return
     */
    public static SQLiteDatabase getInstance(Context context) {
        mContext = context;
        DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath()
                + "/" + mContext.getPackageName() + "/databases";
        if (mDatabase == null) {
            synchronized (DBManager.class) {
                mDatabase = openDatabase();
            }
        }
        return mDatabase;
    }

    /**
     * 获取数据库
     *
     * @return
     */
    public SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    /**
     * 设置数据库
     *
     * @param db
     */
    public void setDatabase(SQLiteDatabase db) {
        mDatabase = db;
    }

    /**
     * 关闭数据库
     */
    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    /**
     * 从本地读取DB文件 ，并加载到内存
     *
     * @param dB_PATH
     * @return
     */
    private static SQLiteDatabase openDatabase() {
        try {
            File file = new File(DB_PATH);
            // 如果内存中不存在，则开始导入
            if (!file.exists()) {
                file.mkdirs();
                AssetManager manager = mContext.getAssets();
                InputStream is = manager.open(DB_NAME);
                FileOutputStream fos = new FileOutputStream(DB_PATH + "/"
                        + DB_NAME);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            }
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DB_PATH
                    + "/" + DB_NAME, null);
            return db;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/**
 *
 */
package com.wd.demo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;

/**
 *
 * @author ZH-SW-Wudi
 * @date: 2021-3-31 下午3:35:46 <br/>
 *
 */
public class AreaDataManager {
    private static String NAME = "phone.db";
    private static volatile AreaDataManager mInstance;

    private AreaDataManager() {
    }

    public static AreaDataManager getInstance() {
        if (mInstance == null) {
            synchronized (AreaDataManager.class) {
                if (mInstance == null) {
                    mInstance = new AreaDataManager();
                }
            }
        }
        return mInstance;
    }

    private boolean isInit = false;
    private volatile boolean isCopyOk = false;
    private SQLiteDatabase db;
    private Context mContext;

    public void init(Context context) {
        if (isInit) {
            return;
        }
        mContext = context;
        String fromPath = FileUtil.getSDPath() + File.separator
                + NAME;
        String destPath = FileUtil.getDbPath(context) + NAME;
        new Thread(new CopyTask(fromPath, destPath)).start();
    }

    public class CopyTask implements Runnable {
        private String fromPath;
        private String destPath;

        public CopyTask(String fromPath, String destPath) {
            this.fromPath = fromPath;
            this.destPath = destPath;
        }

        @Override
        public void run() {
//			boolean flag = FileUtil.copyFile(fromPath, destPath);
            Log.i("FileUtil", "flag=" + toString());
            db = SQLiteDatabase.openDatabase(fromPath, null, SQLiteDatabase.OPEN_READONLY);
            getNumArea("1500205");
            isCopyOk = true;
            Log.i("FileUtil", "isCopyOk");
        }

    }

    public String getNumArea(String num) {
        long t1 = System.currentTimeMillis();
        try {
            Cursor cursor = db
                    .rawQuery(
                            "select * from regions left join phones on regions.id = phones.region_id where number=\""
                                    + num + "\"", null);
            if (cursor != null) {
                cursor.moveToFirst();
                String p = cursor.getString(cursor.getColumnIndex("province"));
                String c = cursor.getString(cursor.getColumnIndex("city"));
                Log.i("wd", "p=" + p + " c=" + c);
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        long t2 = System.currentTimeMillis();
        Log.i("wd", "耗时=" + (t2 - t1));
        return "";
    }

}

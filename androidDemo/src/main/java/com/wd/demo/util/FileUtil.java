package com.wd.demo.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 文件操作的工具类
 *
 * @author ZH-SW-Wudi
 */
public class FileUtil {

    private static final String PATH_VR = getSDPath() + "/vr";
    private static final String PATH_BAIDU = getSDPath() + "/baidu";

    /**
     * 获取sdcard路径
     *
     * @return
     */
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

    /**
     * 删除目录下所有文件
     *
     * @param dir
     */
    public static void deleteDirWithFile(File dir) {
        if (dir == null || !dir.exists() || !dir.isDirectory()) {
            return;
        }
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                // Log.i("wd", "delete:"+file.getPath());
                file.delete(); // 删除所有文件
            } else if (file.isDirectory()) {
                Log.i("wd", "isDirectory=" + file.getPath());
                if (PATH_VR.equals(file.getPath())
                        || PATH_BAIDU.equals(file.getPath())) {
                    Log.i("wd", "vr skip");
                    continue;
                }
                deleteDirWithFile(file); // 递规的方式删除文件夹
            }
        }
        dir.delete();// 删除目录本身
    }

    /**
     * tar.gz文件解压缩
     */
//	public static void doUnTarGz(File srcfile, String destpath)
//			throws IOException {
//		Log.i("wudi", "doUnTarGz:" + destpath);
//		byte[] buf = new byte[1024];
//		FileInputStream fis = new FileInputStream(srcfile);
//		long length = srcfile.length();
//		BufferedInputStream bis = new BufferedInputStream(fis);
//		GzipCompressorInputStream cis = new GzipCompressorInputStream(bis);
//		TarArchiveInputStream tais = new TarArchiveInputStream(cis);
//		TarArchiveEntry tae = null;
//		Log.i("wd", "lenth:" + srcfile.length());
//		while ((tae = tais.getNextTarEntry()) != null) {
//			File f = new File(destpath + "/" + tae.getName());
//			if (tae.isDirectory()) {
//				f.mkdirs();
//			} else {
//				/*
//				 * 父目录不存在则创建
//				 */
//				File parent = f.getParentFile();
//				if (!parent.exists()) {
//					parent.mkdirs();
//				}
//				Log.i("wudi", "开始解压");
//				FileOutputStream fos = new FileOutputStream(f);
//				BufferedOutputStream bos = new BufferedOutputStream(fos);
//				int len;
//				while ((len = tais.read(buf)) != -1) {
//					bos.write(buf, 0, len);
//					// Log.i("wudi", "解压中");
//				}
//				// Log.i("wd", "解压完成！");
//				// Log.i("wd", "进度:"+tais.getBytesRead()*100/l);
//				Log.i("wd", "进度:" + (length - fis.available()) * 100l / length);
//				// Log.i("wd", "尺寸:"+tais.getBytesRead()+"<>"+fis.available());
//				bos.flush();
//				bos.close();
//			}
//		}
//		Log.i("wudi", "全部解压完成！");
//		tais.close();
//	}

    /**
     * 文件保存在SD卡上
     *
     * @param name    文件名称
     * @param content 文件内容
     * @throws Exception
     */
    public void saveToSD(String name, String content) throws Exception {
        File file = new File(Environment.getExternalStorageDirectory(), name);
        FileOutputStream outStream = new FileOutputStream(file);
        // 写入文件
        outStream.write(content.getBytes());
        outStream.close();
    }

    /**
     * 保存数据到文件
     * @param context
     * @param bytes 自己流数据
     */
    public void saveDataToFile(Context context, byte[] bytes) {
        try {
            File file = new File(context.getFilesDir() + "/12.pcm");
            Log.i("test", "file=" + file.getPath());
            FileOutputStream outStream = new FileOutputStream(file);
            // 写入文件
            outStream.write(bytes);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

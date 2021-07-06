package com.wd.java.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 操作文件工具类
 */
public class FileUtil {

	/**
	 * 向文件里面写东西
	 * 
	 * @param value
	 */
	public static void writeFile(int value) {
		String PATH = "/sys/devices/platform/imx-i2c.0/i2c-0/0-001a/wm899_ctl";
		FileOutputStream outputStream;
		File file = new File(PATH);
		try {
			outputStream = new FileOutputStream(file);
			outputStream.write(String.valueOf(value).getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFile() {
		String srcDir = "D:\\naviuuidcfg.txt";
		File file = new File(srcDir);
		BufferedReader bin;
		try {
			bin = new BufferedReader(new InputStreamReader(new FileInputStream(
					file), "gbk"));
			String line = "";
			while ((line = bin.readLine()) != null) {
				StringBuffer sb=new StringBuffer();
				char[] array=line.toCharArray();
				for (int i = 0; i < array.length; i++) {
					if(0==array[i]){
						continue;
					}
					char temp=array[i];
					sb.append(temp);
					//System.out.print(ByteUtil.byteToHexString((byte)temp));
				}
				System.out.println(""+sb.toString());
			}
			bin.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

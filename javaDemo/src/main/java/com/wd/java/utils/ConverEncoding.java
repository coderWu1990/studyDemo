/**
 * Copyright (c) 深圳市众鸿科技股份有限公司
 * @file_name ConverEncoding.java
 * @class com.test.ConverEncoding
 * @create 下午4:04:43
 */
package com.wd.java.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 把gbk格式的文件乱码，转成utf-8的
 * <p>
 * </p>
 * 下午4:04:43
 * 
 * @author ZH-SW-Wudi
 * @version 1.0.0
 */
public class ConverEncoding {
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// String srcDir = "E:\\mining\\tools\\ictclas4j\\ictclas4j\\src";
		String srcDir = "E:\\Workspace\\GalleryDemo\\src";
		List<String> files = new ArrayList<String>();
		fetchFileList(srcDir, files, ".java");
		for (String fileName : files) {
			convert(fileName, "GBK", fileName, "UTF-8");
		}
	}

	public static void convert(String oldFile, String oldCharset,
			String newFlie, String newCharset) {
		BufferedReader bin;
		FileOutputStream fos;
		StringBuffer content = new StringBuffer();
		try {
			System.out.println(oldFile);
			bin = new BufferedReader(new InputStreamReader(new FileInputStream(
					oldFile), "gbk"));
			String line = null;
			while ((line = bin.readLine()) != null) {
				// System.out.println("content:" + content);
				content.append(line);
				content.append(System.getProperty("line.separator"));
			}
			bin.close();
			File dir = new File(newFlie.substring(0, newFlie.lastIndexOf("\\")));
			if (!dir.exists()) {
				dir.mkdirs();
			}
			fos = new FileOutputStream(newFlie);
			Writer out = new OutputStreamWriter(fos, newCharset);
			out.write(content.toString());
			out.close();
			fos.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fetchFileList(String strPath, List<String> filelist,
			final String regex) {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		Pattern p = Pattern.compile(regex);
		if (files == null)
			return;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				fetchFileList(files[i].getAbsolutePath(), filelist, regex);
			} else {
				String strFileName = files[i].getAbsolutePath().toLowerCase();
				Matcher m = p.matcher(strFileName);
				if (m.find()) {
					filelist.add(strFileName);
				}
			}
		}
	}
}
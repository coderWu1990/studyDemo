/**
 * 
 */
package com.wd.java.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-1-19 上午11:24:00 <br/>
 * 统计java代码个数和行数
 */
public class CountJavaLines {

	private static int i;// 代码总行数
	private static int j;// 文件个数

	public static void main(String[] args) throws IOException {
//		File file = new File("E:\\Workspace\\AAA_Demo");// 需要统计行数的文件夹路径
//		File file = new File("D:\\Android\\WorkPlace\\tclplus_android");// 需要统计行数的文件夹路径
		File file = new File("D:\\Android\\WorkPlace\\ConfigNetSdk");// 需要统计行数的文件夹路径
		traverseFiles(file);// 调用递归方法查看.java文件，用于统计行数
		System.out.println("Java文件个数：" + j);
		System.out.println("Java代码总行数：" + i);
	}

	public static void traverseFiles(File file) throws IOException {
		if (!file.exists()) {// 文件不存在
			return;
		}
		int count=0;
		if (!file.isDirectory()) {// 判断是否为文件
			String filename = file.getName();
			if (filename.endsWith(".java")) {// 判断是否是.java文件
				j++;
				BufferedReader bufferedReader = new BufferedReader(
						new FileReader(file));
				while (bufferedReader.readLine() != null) {
					i++;// 读取行数
					count++;
				}
				if (count>300) {
					System.out.println("文件名=" + filename + " 行数=" + count+" 路径="+file.getPath());
				}
				bufferedReader.close();
			} else {
				return;
			}
		}

		File[] files = file.listFiles();// 读取文件夹的子文件或子文件夹
		if (files == null || files.length == 0) {
			return;
		}

		for (File file2 : files) {// 如果是文件夹递归调用方法遍历文件
			traverseFiles(file2);
		}
	}
}

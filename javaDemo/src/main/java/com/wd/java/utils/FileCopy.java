package com.wd.java.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/**
 * 文件的四种拷贝方式
 * 
 * @author ZH-SW-Wudi
 * 
 */
public class FileCopy {

	/**
	 * 执行几个读和写操作try的数据,这是一个低效率的
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	private static void copyFileUsingFileStreams(File source, File dest)
			throws IOException {
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(source);
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		} finally {
			input.close();
			output.close();
		}
	}

	/**
	 * NIO包括transferFrom方法,根据文档应该比文件流复制的速度更快
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	private static void copyFileUsingFileChannels(File source, File dest)
			throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
	}

	private static void copyFileUsingApacheCommonsIO(File source, File dest)
			throws IOException {
		// FileUtils.copyFile(source, dest);
	}

	private static void copyFileUsingJava7Files(File source, File dest)
			throws IOException {
		// Files.copy(source.toPath(), dest.toPath());
	}
}

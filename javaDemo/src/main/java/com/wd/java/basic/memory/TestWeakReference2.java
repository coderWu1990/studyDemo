/**
 * 
 */
package com.wd.java.basic.memory;

import java.lang.ref.WeakReference;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-24 下午9:48:18 <br/>
 * 
 */
public class TestWeakReference2 {
	
	public static void main(String[] args) throws InterruptedException {
		// 创建弱引用
		WeakReference<G>[] srArr = new WeakReference[5];
		for (int i = 0; i < srArr.length; i++) {
			srArr[i] = new WeakReference(new G());
		}
		// 获取被清除部分
		int n = 0;
		for (int i = 0; i < srArr.length; i++) {
			if (srArr[i].get()==null) {
				srArr[i] = null;
				n++;
			}
		}
		System.out.println("第一次不GC,清除了" + n + "个");

		// 尝试请求一次GC
		System.gc();

		// 获取第二次被清除部分
		int m = 0;
		for (int i = 0; i < srArr.length; i++) {
			if (srArr[i] != null && srArr[i].get()==null) {
				srArr[i] = null;
				m++;
			}
		}
		System.out.println("第二次GC,清除了" + m + "个");
	}
}

// 为了占据内存
class G {
	private int[] big = new int[5*1024*1024];
}
/*
 * output （第二次清除个数有明显变动） 第一次GC,清除了965个 第一次GC,清除了16个
 */
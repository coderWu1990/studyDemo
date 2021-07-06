/**
 * 
 */
package com.wd.java.basic.memory;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-24 下午7:28:49 <br/>
 * 
 */
public class TestWeakReference {

	public static void main(String[] args) {

		//weak
		Map<Integer,WeakReference<byte[]>> map=new ConcurrentHashMap<>();
		for (int i = 0; i <10; i++) {
			byte[] ss=new byte[1024*1024];
			map.put(i, new WeakReference<byte[]>(ss));
		}
		//调gc，全部空了，不调还有三个
//		System.gc();
		for (int i = 0; i < 10; i++) {
			System.out.println("weak i="+i+" "+map.get(i).get());
		}
		
		//strong
//		Map<Integer,byte[]> strong=new ConcurrentHashMap<>();
//		for (int i = 0; i <10; i++) {
//			byte[] ss=new byte[1024*1024];
//			strong.put(i, ss);
//		}
//		
//		for (int i = 0; i < 10; i++) {
//			System.out.println("strong i="+i+" "+strong.get(i));
//		}
	}

}

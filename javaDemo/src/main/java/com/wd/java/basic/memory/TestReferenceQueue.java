/**
 * 
 */
package com.wd.java.basic.memory;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-24 下午9:59:35 <br/> 
 *
 */
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class TestReferenceQueue {
	public static void main(String[] args) throws InterruptedException {
		int _1M = 1024 * 1024;

		final ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
		
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					int cnt = 0;
					WeakReference<byte[]> k;
					//k.isEnqueued();
					while ((k = (WeakReference) referenceQueue.remove()) != null) {
						System.out.println((cnt++) + "回收了:" + k);
					}
				} catch (InterruptedException e) {
					// 结束循环
				}
			}
		});
		thread.setDaemon(true);
		thread.start();

		final Map<Integer, WeakReference<byte[]>> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			byte[] bytes = new byte[_1M];
			WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes, referenceQueue);
			map.put(i,weakReference);
		}
		System.out.println("map.size->" + map.size());
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				byte[] b1=map.get(1).get();
				System.out.println("b1="+b1);
				byte[] b9=map.get(9).get();
				System.out.println("b9="+b9);
			}
		}).start();
	}
}

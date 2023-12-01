/**
 * 
 */
package com.wd.java.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-4-13 下午5:25:14 <br/> 
 *
 */
public class SinglePool {
	private static ExecutorService mExecutorService;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mExecutorService=Executors.newFixedThreadPool(1);
		mExecutorService.execute(new MyThread("哈哈1"));
		mExecutorService.execute(new MyThread("哈哈2"));
	}
	
	private static class MyThread extends Thread{
		
		/**
		 * 
		 */
		public MyThread(String name) {
			// TODO Auto-generated constructor stub
			setName(name);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"当前线程id="+Thread.currentThread().getId()+" 运行开始");
//			super.run();
		}
	}

}

/**
 * 
 */
package com.wd.java.concurrent.pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.wd.java.utils.SysOutWithTime;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-4 上午9:34:36 <br/> 
 *
 */
public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutor executor=new ThreadPoolExecutor(2, 20, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		for (int i = 0; i < 30; i++) {
			executor.execute(new MyRunable("线程"+i));
			SysOutWithTime.print(executor.getActiveCount()+" "+executor.getCompletedTaskCount()+" "
					+executor.getQueue().size());
		}
		executor.shutdown();
		
	}
	
	public static class MyRunable implements Runnable{

		String name;
		
		public MyRunable(String name){
			this.name=name;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			SysOutWithTime.print(name+"执行");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SysOutWithTime.print(name+"执行完成");
			
		}
		
	}

}

/**
 * 
 */
package com.wd.java.concurrent.thread;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-4-1 下午8:19:19 <br/> 
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread myThread=new MyThread("haha");
		myThread.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(myThread.getName()+" "+myThread.getState());
		if(myThread!=null){
			//不能重新start，java.lang.IllegalThreadStateException
//			myThread.start();
		}
		//这样是ok的
		myThread=new MyThread("haha");
		myThread.start();
	}
	
	private static class MyThread extends Thread{
		private String name;
		/**
		 * 
		 */
		public MyThread(String name) {
			// TODO Auto-generated constructor stub
			super(name);
			this.name=name;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			System.out.println(getName()+"run over");
		}
	}

}

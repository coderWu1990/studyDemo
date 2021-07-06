/**
 * 
 */
package com.wd.java.design.designmode.single;

/**
 * 双重锁单例
 * @author ZH-SW-Wudi
 * @date: 2021-3-2 上午11:57:13 <br/> 
 *
 */
public class WifiManager {
	private static volatile WifiManager instance;
	
	private WifiManager(){
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static WifiManager getInstance(String name){
		if(instance==null){
//			SysOutWithTime.print(name+"线程进入");
			synchronized(WifiManager.class){
//				SysOutWithTime.print(name+"初始化");
				if(instance==null){
					instance=new WifiManager();
				}
			}
		}
		return instance;
	}

}

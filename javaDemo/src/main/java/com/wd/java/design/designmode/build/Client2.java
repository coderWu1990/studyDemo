/**
 * 
 */
package com.wd.java.design.designmode.build;

import com.wd.java.design.designmode.build.AppBuild;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-18 下午3:24:58 <br/> 
 *
 */
public class Client2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppBuild app=new AppBuild().setName("zs").setAge(30);
		System.out.println(app);
	}

}

/**
 * 
 */
package com.wd.java.ds.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-15 下午3:54:02 <br/> 
 *
 */
public class TestArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add(0, "a");
		list.add(0, "b");
		System.out.println(Arrays.toString(list.toArray()));
	}

}

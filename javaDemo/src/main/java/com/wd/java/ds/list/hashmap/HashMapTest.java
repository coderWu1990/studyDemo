/**
 * 
 */
package com.wd.java.ds.list.hashmap;

import java.util.HashMap;

/**
 * 
 * @author ZH-SW-Wudi
 * @date: 2021-3-4 上午9:31:57 <br/> 
 *
 */
public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tableSizeFor(25556395));
		testPut();
	}
	
	static void testPut(){
		HashMap<String, String> map=new HashMap<String, String>(1000);	
		String a=map.put("A", "zhangsan");
		System.out.println(a);
		String b=map.put("A", "wangsi");
		System.out.println(b);
		System.out.println(map);
	}
	
	static final int MAXIMUM_CAPACITY=Integer.MAX_VALUE;
	
	static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}

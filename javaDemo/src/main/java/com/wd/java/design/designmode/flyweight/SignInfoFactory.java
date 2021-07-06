package com.wd.java.design.designmode.flyweight;

import java.util.HashMap;

public class SignInfoFactory {

	private static HashMap<String, KeySignInfo> map=new HashMap<>();
	
	public static KeySignInfo getInfo(String key){
		KeySignInfo info=null;
		if(!map.containsKey(key)){
			info=new KeySignInfo();
			map.put(key, info);
			System.out.println("放入："+key);
		}else{
			info=map.get(key);
			System.out.println("直接取："+key);
		}
		return info;
	}
}

package com.wd.java.design.designmode.factory;

public class HumanFactory {

	public static <T extends Human> T createHuman(Class<T> cls){
		Human human=null;
		try {
			human=(Human) Class.forName(cls.getName()).newInstance();
		} catch (Exception e) {
			System. out. println( "人种生成错误！ " ) ;
		}
		return (T)human;
	}
}

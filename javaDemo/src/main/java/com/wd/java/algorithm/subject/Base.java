package com.wd.java.algorithm.subject;

public class Base {

	String baseName="base";
	
	Base(){
		callName();
	}
	
	public void callName(){
		System.out.println("Base="+baseName);
	}
	
	static class Sub extends Base{
		String baseName="Sub";
		
		public void callName(){
			System.out.println("Sub="+baseName);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Base b=new Sub();
		//b.callName();
	}

}

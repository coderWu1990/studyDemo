package com.wd.java.basic.equals;
/**
 * 常用的重写equels方法
 * @author ZH-SW-Wudi
 *
 */
public class OverrideEquals {

	String a="a";
	
	public OverrideEquals(String a) {
		super();
		this.a = a;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o){
			return true;
		}
		if(o instanceof OverrideEquals){
			OverrideEquals a=(OverrideEquals) o;
			return a.getA().equals(this.getA());
		}else{
			return false;
		}
	}

	
}

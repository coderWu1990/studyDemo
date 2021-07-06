package com.wd.java.design.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
	
	private Object target=null;

	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		if("doSomething".equals(method.getName())){
			System.out.println("做事了");
		}
		return method.invoke(this.target, args);
	}

}

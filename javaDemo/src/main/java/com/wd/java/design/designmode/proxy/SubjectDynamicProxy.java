package com.wd.java.design.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SubjectDynamicProxy{

	public static <T> T newProxyInstance(Subject subject){
		ClassLoader loader=subject.getClass().getClassLoader();
		Class<?>[] interfaces=subject.getClass().getInterfaces();
		InvocationHandler h=new MyInvocationHandler(subject);
		if(true){
			IAdvice advice=new BeforeAdvice();
			advice.exec();
		}
		return (T) Proxy.newProxyInstance(loader, interfaces, h);
	}
}

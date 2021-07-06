package com.wd.java.design.designmode.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	public static <T> T newInstance(IAction action){
		ClassLoader classLoader=action.getClass().getClassLoader();
		Class<?>[] interfaces=action.getClass().getInterfaces();
		return (T) Proxy.newProxyInstance(classLoader, interfaces, new MyInvocationHandler(action));
	}
	
	private static class MyInvocationHandler implements InvocationHandler{

		private Object object;
		
		public MyInvocationHandler(Object object){
			this.object=object;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			// TODO Auto-generated method stub
			if("action".equals(method.getName())){
				System.out.println("动态代理");
			}
			return method.invoke(object, args);
		}
		
	} 
}

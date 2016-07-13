package com.oocl.mnlbc.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BookCglib implements MethodInterceptor {
	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());

		enhancer.setCallback(this);
		return enhancer.create();
	}

//	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("Before");
		proxy.invokeSuper(obj, args);
		System.out.println("After");
		return null;
	}
}

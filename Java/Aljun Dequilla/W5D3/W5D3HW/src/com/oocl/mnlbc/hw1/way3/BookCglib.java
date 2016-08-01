package com.oocl.mnlbc.hw1.way3;

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
		// new Class[] { String.class }, new Object[] { new String("Book Sample
		// 2") }
		Object[] args = new Object[] { new String("Title"), new String("Author") };
		return enhancer.create(new Class[] { String.class }, args);
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("Before");
		proxy.invokeSuper(obj, args);
		System.out.println("After");
		return null;
	}

}
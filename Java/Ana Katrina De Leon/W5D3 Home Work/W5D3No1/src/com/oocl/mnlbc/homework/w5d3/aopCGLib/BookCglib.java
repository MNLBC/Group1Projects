package com.oocl.mnlbc.homework.w5d3.aopCGLib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class BookCglib implements MethodInterceptor {
	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create(new Class[] { String.class, String.class },
				new Object[] { new String("The Fault in our Stars"), new String("John Green") });
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Before Invoke");  
       proxy.invokeSuper(obj, args);  
       System.out.println("After Invoke");  
       return null;  
	}
}

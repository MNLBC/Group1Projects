package com.oocl.mnlbc.booking_2;

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
        return  enhancer.create(new Class[] {String.class}, new Object[] {new String("Noli Me Tnagere")}); 
    }  
  
      
    public Object intercept(Object obj, Method method, Object[] args,  
            MethodProxy proxy) throws Throwable {  
        System.out.println("Before Adding");  
        proxy.invokeSuper(obj, args);  
        System.out.println("After Adding");  
        return null;  
  
  
    }  
  
}  

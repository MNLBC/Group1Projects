package com.oocl.mnlbc.booking_3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;  


public class ProxyBook implements InvocationHandler {

	private Object target;
    public Object bind(Object target) {  
        this.target = target;  
        //Get proxy object
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), this); 
    } 
    
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object result=null;  
        System.out.println("Before Adding");  

        result=method.invoke(target, args);  
        
        System.out.println("After Adding");  
        return result;  
    } 
	
}

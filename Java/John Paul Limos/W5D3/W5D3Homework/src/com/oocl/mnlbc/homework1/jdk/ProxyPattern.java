package com.oocl.mnlbc.homework1.jdk;

public class ProxyPattern {
	public static void main(String[] args){
		ProxyBook proxy = new ProxyBook();  
		BookFacade bookProxy = (BookFacade) proxy.bind(new RealBook("Paper Towns"));
        bookProxy.addBook();
	}
}

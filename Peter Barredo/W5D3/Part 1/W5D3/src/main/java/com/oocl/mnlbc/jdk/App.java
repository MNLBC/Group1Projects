package com.oocl.mnlbc.jdk;

public class App {
	public static void main(String[] args) {
		ProxyBookFacade proxy = new ProxyBookFacade();  
        BookFacade bookProxy = (BookFacade) proxy.bind(new RealBookFacade("Hunger Games"));  
        
        bookProxy.addBook();
	}
}

package com.oocl.mnlbc.homework.aop.JDK;

public class ProxyPatternDemo {

	public static void main(String[] args) {

		ProxyBook proxy = new ProxyBook();
		BookFacade bookProxy = (BookFacade) proxy.bind(new RealBook("The Fault in our Stars", "John Green"));

		bookProxy.addBook();

	}
}
package com.oocl.mnlbc.homework.w5d3.aopJDK;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		ProxyBook proxy = new ProxyBook();
		BookFacade bookProxy = (BookFacade) proxy.bind(new RealBook("The Fault in Our Stars"));

		bookProxy.addBook();

	}

}

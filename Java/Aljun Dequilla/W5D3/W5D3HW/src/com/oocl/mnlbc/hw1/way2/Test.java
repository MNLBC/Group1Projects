package com.oocl.mnlbc.hw1.way2;

public class Test {

	public static void main(String[] args) {
		ProxyBook proxy = new ProxyBook();
		BookFacade bookProxy = (BookFacade) proxy.bind(new RealBook("title", "author"));

		bookProxy.addBook();
	}

}

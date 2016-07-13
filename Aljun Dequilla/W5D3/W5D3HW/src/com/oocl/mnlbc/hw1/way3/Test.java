package com.oocl.mnlbc.hw1.way3;

public class Test {

	public static void main(String[] args) {
		BookCglib cglib = new BookCglib();
		// ProxyBook proxyBook = new ProxyBook();
		// proxyBook.setFileName("test_10mb.jpg");
		ProxyBook proxyBook = new ProxyBook("title", "author");
		BookFacade book = (BookFacade) cglib.getInstance(proxyBook);
		book.addBook();
	}

}

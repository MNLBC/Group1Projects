package com.oocl.mnlbc.hw1.way1;

public class Test {
	public static void main(String[] args) {
		BookFacade book = new ProxyBook("title", "author");
		book.addBook();
	}
}

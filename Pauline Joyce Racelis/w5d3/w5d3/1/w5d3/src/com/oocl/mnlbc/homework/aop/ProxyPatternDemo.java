package com.oocl.mnlbc.homework.aop;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		ProxyBook book = new ProxyBook("The fault in our stars", "John Green");
		
		book.addBook();
		book.addBook();
	}

}

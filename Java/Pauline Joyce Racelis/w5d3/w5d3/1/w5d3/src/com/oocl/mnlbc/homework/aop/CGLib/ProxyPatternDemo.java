package com.oocl.mnlbc.homework.aop.CGLib;

public class ProxyPatternDemo {
	public static void main(String[] args) {
		BookCglib cglib = new BookCglib();
		BookFacade book = (BookFacade)cglib.getInstance(new RealBook());
		book.addBook();

	}
}

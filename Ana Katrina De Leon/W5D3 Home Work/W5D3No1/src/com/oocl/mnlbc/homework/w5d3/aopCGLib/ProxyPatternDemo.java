package com.oocl.mnlbc.homework.w5d3.aopCGLib;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		BookCglib cglib = new BookCglib();
		BookFacade book = (BookFacade) cglib.getInstance(new RealBook("The Fault in Our Stars"));
		book.addBook();
	}

}

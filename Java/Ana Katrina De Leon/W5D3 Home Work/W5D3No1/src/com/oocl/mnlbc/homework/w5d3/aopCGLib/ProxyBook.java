package com.oocl.mnlbc.homework.w5d3.aopCGLib;

public class ProxyBook implements BookFacade {

	private RealBook realBook;
	private String bookTitle;

	public ProxyBook(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void addBook() {
		if (realBook == null) {
			realBook = new RealBook(bookTitle);
		}
		realBook.addBook();
	}
}

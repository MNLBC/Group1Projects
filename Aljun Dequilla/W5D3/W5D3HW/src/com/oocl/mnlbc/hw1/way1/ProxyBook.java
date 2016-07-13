package com.oocl.mnlbc.hw1.way1;

public class ProxyBook implements BookFacade {

	private RealBook realBook;
	private String title;
	private String author;

	public ProxyBook(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public void addBook() {
		if (realBook == null) {
			realBook = new RealBook(title, author);
		}

	}

}

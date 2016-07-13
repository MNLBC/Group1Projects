package com.oocl.mnlbc.homework1.aop;

public class ProxyBook implements BookFacade{
	private RealBook realBook;
	private String bookName;

	public ProxyBook(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public void addBook() {
		if(realBook == null){
			realBook = new RealBook(bookName);

		}
		realBook.display();
	}

}

package com.oocl.mnlbc.booking_1;

public class ProxyBook implements BookFacade {

	private MyBook book;
	private String fileName;
	
	public ProxyBook(String fileName){
		this.fileName = fileName;
	}
	
	
	@Override
	public void addBook() {
		if(book == null){
			book = new MyBook(fileName);
		}
		book.display();
	}

}

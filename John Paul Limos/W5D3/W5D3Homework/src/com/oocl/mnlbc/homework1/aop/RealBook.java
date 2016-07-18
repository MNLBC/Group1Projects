package com.oocl.mnlbc.homework1.aop;

public class RealBook {
	private String bookName;

	public RealBook(String bookName) {
		this.bookName = bookName;

		addBook(bookName);
		loadFromDisk(bookName);
	}
	
	public void addBook(String bookName){
		System.out.println("Adding " + bookName);
	}
	
	public void display() {
		System.out.println("Displaying " + bookName);
	}

	private void loadFromDisk(String bookName) {
		System.out.println("Loading " + bookName);
	}
}

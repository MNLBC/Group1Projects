package com.oocl.mnlbc.homework1.jdk;

public class RealBook implements BookFacade {

	private String bookName;
	private RealBook realBook;

	public RealBook(String bookName) {
		this.bookName = bookName;
		loadFromDisc(bookName);
	}

	private void loadFromDisc(String bookName) {
		System.out.println("Loading " + bookName);
		
	}

	public void addBook() {
		this.bookName = bookName;
		display();
	}

	private void display() {
		System.out.println("Displaying " + bookName);
	}

}

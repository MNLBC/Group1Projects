package com.oocl.mnlbc.homework.w5d3.aopJDK;

public class RealBook implements BookFacade {
	private String bookTitle;

	public RealBook(String bookTitle){
	      this.bookTitle = bookTitle;
	      loadFromDisk(bookTitle);
	   }

	public void addBook() {
		System.out.println("Added " + bookTitle + " in the Library");
	}

	private void loadFromDisk(String bookTitle) {
		System.out.println("Searching for: " + bookTitle);
	}
}

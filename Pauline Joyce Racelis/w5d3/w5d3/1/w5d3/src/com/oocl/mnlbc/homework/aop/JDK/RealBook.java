package com.oocl.mnlbc.homework.aop.JDK;

import com.oocl.mnlbc.homework.aop.BookFacade;

public class RealBook implements BookFacade {

	private String bookTitle;
	private String bookAuthor;

	public RealBook(String bookTitle, String bookAuthor) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		loadFromDisk(bookTitle);
	}

	public void addBook() {
		System.out.println("Adding " + bookTitle + " by " + bookAuthor);
	}

	private void loadFromDisk(String bookTitle){
	      System.out.println("Adding! " + bookTitle + " by " + bookAuthor);
	   }
}

package com.oocl.mnlbc.homework.aop;

public class RealBook implements BookFacade{
	
	private String bookTitle;
	private String author;
	
	public RealBook(String bookTitle, String author){
	      this.bookTitle = bookTitle;
	      this.author = author;
	      loadFromDisk(bookTitle + " by " + author);
	   }

	   public void addBook() {
		  System.out.println("Added!" + "Book title " + bookTitle);
	      System.out.println("Author " + author);
	     
	   }

	   private void loadFromDisk(String bookTitle){
	      System.out.println("Adding! " + bookTitle + " "+ author);
	   }



}

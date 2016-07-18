package com.oocl.mnlbc.homework.aop.CGLib;

public class RealBook implements BookFacade {
	private String bookTitle;
	private String author;
	
	public RealBook(String bookTitle, String author){
	      this.bookTitle = bookTitle;
	      this.author = author;
	      loadFromDisk(bookTitle + " by " + author);
	   }

	   public RealBook() {
	}

	public void addBook() {
		  System.out.println("Book title " + bookTitle);
	      System.out.println("Author " + author);
	     
	   }

	   private void loadFromDisk(String fileName){
	      System.out.println("Adding! " + fileName);
	   }


}

package com.oocl.mnlbc.homework.aop;


public class ProxyBook implements BookFacade {
	
	private RealBook realBook;
	private String bookTitle;
	private String author;
	
	public ProxyBook(String bookTitle, String author){
		this.bookTitle = bookTitle;
		this.author = author;
	}
	
	public void addBook(){
		if(realBook == null){
	         realBook = new RealBook(bookTitle, author);
	      }
	      realBook.addBook();
	   }
}

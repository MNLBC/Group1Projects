package com.oocl.mnlbc.homework1.cglib;

public class RealBook implements BookFacade{

	public String bookname;
	
	public RealBook(String bookname){
		this.bookname = bookname;
		addToLibrary(bookname);
	}
	
	public void addBook(){
		System.out.println("Added " + bookname);
	}
	
	public void addToLibrary(String bookname){
		System.out.println("Adding " + bookname);
	}
}

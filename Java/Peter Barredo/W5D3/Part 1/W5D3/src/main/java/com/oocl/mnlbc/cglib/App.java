package com.oocl.mnlbc.cglib;

public class App {
	public static void main(String[] args) {
		BookCglib cglib=new BookCglib();  
        BookFacade book = (BookFacade)cglib.getInstance(new RealBookFacade("Hunger Games"));  
        book.addBook();
	}
}

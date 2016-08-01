package com.oocl.mnlbc.booking_2;

public class ProxyPatternBook {
	
	   public static void main(String[] args) {

		   //CGLib
		   BookCglib cglib=new BookCglib();  
	       BookFacade book=(BookFacade)cglib.getInstance(new MyBook("El Filibustirismo"));  
	       book.addBook();
	   }
}
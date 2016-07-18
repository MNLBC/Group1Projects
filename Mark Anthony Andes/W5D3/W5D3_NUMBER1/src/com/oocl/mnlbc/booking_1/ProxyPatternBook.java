package com.oocl.mnlbc.booking_1;

public class ProxyPatternBook {

	public static void main(String[] args) {

		 BookFacade book = new ProxyBook("The Flash.");

	      book.addBook();
	      System.out.println("");
	      
	      book.addBook(); 			
	}

}

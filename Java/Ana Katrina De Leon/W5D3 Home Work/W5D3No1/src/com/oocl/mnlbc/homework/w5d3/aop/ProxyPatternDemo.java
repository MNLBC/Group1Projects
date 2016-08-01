package com.oocl.mnlbc.homework.w5d3.aop;

public class ProxyPatternDemo {
	
	   public static void main(String[] args) {
	      BookFacade book = new ProxyBook("The Fault in Our Stars");

	      book.addBook(); 
	      System.out.println("");

	      book.addBook();  	
	   }
}
package com.oocl.mnlbc.booking_3;


public class ProxyPatterBook {
	
	   public static void main(String[] args) {
		   
		ProxyBook proxy = new ProxyBook();  
        BookFacade book = (BookFacade) proxy.bind(new MyBook("The Avengers"));  
        
        book.addBook();
 	
	   }
}
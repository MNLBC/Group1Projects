package com.oocl.mnlbc.homework1.cglib;

public class ProxyPattern {
	public static void main(String[] args){
		   BookCglib cglib=new BookCglib();  
	       BookFacade book=(BookFacade)cglib.getInstance(new RealBook("Paper Towns"));  
//	       book.addBook();
	}
}

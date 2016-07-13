package com.oocl.mnlbc.homework1.aop;

public class ProxyPattern {
	public static void main(String[] args){
		BookFacade book1 = new ProxyBook("Paper Towns");
		book1.addBook();
	}
}

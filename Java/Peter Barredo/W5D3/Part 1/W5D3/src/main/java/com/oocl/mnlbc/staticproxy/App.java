package com.oocl.mnlbc.staticproxy;

public class App {

	public static void main(String[] args) {
		BookFacade bookFacade = new ProxyBookFacade("Hunger Games");
		bookFacade.addBook();
		System.out.println("");
		bookFacade.addBook();
	}

}

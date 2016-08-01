package com.oocl.mnlbc.homework1.cglib;

import com.oocl.mnlbc.homework1.cglib.BookFacade;
import com.oocl.mnlbc.homework1.cglib.RealBook;

public class ProxyBook implements BookFacade{

	public RealBook realbook;
	public String bookname;
	
	public ProxyBook(String bookname){
		this.bookname = bookname;
	}

	@Override
	public void addBook() {
		if(realbook == null){
			realbook = new RealBook(bookname);
		}
		realbook.addBook();
	}
	
}

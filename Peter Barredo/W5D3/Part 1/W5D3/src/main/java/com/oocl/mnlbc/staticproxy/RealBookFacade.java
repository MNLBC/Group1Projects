package com.oocl.mnlbc.staticproxy;
/**
 * 
 * @author BARREPE
 *
 */
public class RealBookFacade implements BookFacade {
	
	private String title;
	
	public RealBookFacade(String title){
		this.title = title;
		read(title);
	}
	
	public void addBook() {
		System.out.println("Adding book" + this.title);
	}
	
	private void read(String title){
		System.out.println("Read" + title);
	}

}

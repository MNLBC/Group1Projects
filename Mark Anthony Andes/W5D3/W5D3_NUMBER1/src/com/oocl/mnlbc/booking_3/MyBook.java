package com.oocl.mnlbc.booking_3;

public class MyBook implements BookFacade {

	   private String fileName;

	   public MyBook(String fileName){
	      this.fileName = fileName;
	      loadFromDisk(fileName);
	   }


	   private void loadFromDisk(String fileName){
	      System.out.println("Addding " + fileName);
	   }

	public void addBook() {
		System.out.println("Reading " + fileName);
		
	}
}

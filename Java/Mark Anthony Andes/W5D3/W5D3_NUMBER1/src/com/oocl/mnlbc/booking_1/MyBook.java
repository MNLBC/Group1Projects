package com.oocl.mnlbc.booking_1;

public class MyBook {

	
	  private String fileName;

	   public MyBook(String fileName){
	      this.fileName = fileName;
	      loadFromDisk(fileName);
	   }

	   public void display() {
	      System.out.println("Reading " + fileName);
	   }

	   private void loadFromDisk(String fileName){
	      System.out.println("Adding " + fileName);
	   }
}

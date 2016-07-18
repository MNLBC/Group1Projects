package com.oocl.mnlbc.booking_2;

public class MyBook {//No implement Image

	   private String fileName;

	   public MyBook(String fileName){
	      this.fileName = fileName;
	      loadFromDisk(fileName);
	   }

	   public void display() {
	      System.out.println("Adding " + fileName);
	   }
	   
	   private void loadFromDisk(String fileName){
	      System.out.println("Reading " + fileName);
	   }
}

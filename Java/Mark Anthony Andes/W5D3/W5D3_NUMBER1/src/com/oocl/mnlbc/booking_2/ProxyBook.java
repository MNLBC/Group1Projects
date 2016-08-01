package com.oocl.mnlbc.booking_2;

public class ProxyBook implements BookFacade{

	   private MyBook realImage;
	   private String fileName;

	   public ProxyBook(String fileName){
	      this.fileName = fileName;
	   }

	public void addBook() {
		if(realImage == null){
	         realImage = new MyBook(fileName);
	      }
	      realImage.display();		
	}
}
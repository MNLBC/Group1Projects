package com.oocl.mnlbc.grp1;

public class App {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		Customer cust1 = new Customer(0, "Juan", "Dela Cruz", "09123456789", "jdcruz", "123", "type", "asd@asd.com");
		System.out.println("Created Customer: " + cust1.getFname() + " " + cust1.getLname());
		Warehouse wh = new Warehouse(5, 5, 5, 4);

		System.out.println("Customer View Products: ");
		displayWarehouseStocks(wh);
		
		//CUSTOMER BUY 3 Shampoo 
		cust1.addToChart(wh.getProducts().get(0), 3);
//		cust1.addToChart(wh.getProducts().get(1), 3);
		
		//display chart
		cust1.viewChart();
		
		cust1.removeToChart(wh.getProducts().get(0), 5);
		System.out.println("Removed");
		cust1.viewChart();
		
	}

	public static void displayWarehouseStocks(Warehouse w)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<? extends Warehouse> whClass = w.getClass();
		for (Product p : w.getProducts()) {
			System.out.println("Name: " + p.getProdName() 
							+ " Price: " + p.getPrice() 
							+ " Description: " + p.getDesc() 
							+ " Available Stock: " + whClass.getDeclaredField(p.getProdName()).get(w));
		}
	}
	
	public void success(){
		
	}
	
	public void notSuccessful(){
		
	}

}

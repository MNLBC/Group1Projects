package com.oocl.mnlbc.grp1;

import java.util.List;

public class App {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		Customer cust1 = new Customer(0, "Juan", "Dela Cruz", "09123456789", "jdcruz", "123", "type", "asd@asd.com",
				200.50);
		System.out.println("Created Customer: " + cust1.getFname() + " " + cust1.getLname());
		Warehouse wh = new Warehouse(5, 5, 5, 4);

		System.out.println("Customer View Products: ");
		displayWarehouseStocks(wh);

		// CUSTOMER BUY 3 Shampoo
		if(cust1.hasEnoughStocks(wh,wh.getProducts().get(2), 6))
			cust1.addToChart(wh.getProducts().get(2), 6);
		else{
			System.out.println("Insufficient Stocks.");	
			System.out.println("Canceling Transaction.");
			System.out.println("Done");
			System.out.println("Thank you!");
			return;
		}
		
		// cust1.addToChart(wh.getProducts().get(1), 5); //Not Successful
		
		// display chart
		cust1.viewChart();
//		cust1.removeToChart(wh.getProducts().get(0), 1); // remove from cart

		System.out.println("Removed");
		cust1.viewChart();
		// Click Order
		cust1.setOrderStatus("Order Comitted");
		System.out.println("Order is now committed..Displaying order status.. ");
		
		System.out.println(cust1.getOrderStatus());
		
		System.out.println("Customer Click Buy.");
		System.out.println("Processing credit card information...");

		if (!cust1.isValidToUpdate()) {
			System.out.println("Credit Balance exceeded the initial Balance Required");
			System.out.println("Canceling Transaction.");
			System.out.println("Done");
			System.out.println("Thank you!");
			return;
		}
		System.out.println("Credit card validation successful");
		System.out.println("Charging amount to credit card");
		cust1.updateCreditBalance();
		System.out.println("Processing Transaction...");
		System.out.println("Transaction Completed!");
		wh.updateWareHouse(cust1.getOrder());
		displayWarehouseStocks(wh);

	}

	public static void displayWarehouseStocks(Warehouse w)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<? extends Warehouse> whClass = w.getClass();
		for (Product p : w.getProducts()) {
			System.out.println("Name: " + p.getProdName() + " Price: " + p.getPrice() + " Description: " + p.getDesc()
					+ " Available Stock: " + whClass.getDeclaredField(p.getProdName()).get(w));
		}
	}




}

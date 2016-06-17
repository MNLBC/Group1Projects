package com.oocl.mnlbc.grp1;

import java.util.List;

public class Shopping {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		System.out.println("Entering user details for registration...");
		Customer cust1 = register("Juan", "Dela Cruz", "09123456789", "jdcruz", "123", "asd@asd.com");
		System.out.println("Created Customer: " + cust1.getFname() + " " + cust1.getLname());
		System.out.println("Registration Successful");

		System.out.println();

		System.out.println("User " + cust1.getUsername() + " has logged in.");
		System.out.println("Welcome to Valley Online Shop!");

		System.out.println();

		Warehouse wh = new Warehouse(5, 5, 5, 4);
		System.out.println("Customer View Products: ");
		displayWarehouseStocks(wh);

		// CUSTOMER BUY 3 Shampoo
		if (cust1.hasEnoughStocks(wh, wh.getProducts().get(0), 6)){
			cust1.addToChart(wh.getProducts().get(0), 6);
			System.out.println("User has added " + 6 + " " + wh.getProducts().get(0).getProdName() + " to Cart");
			
//			cust1.addToChart(wh.getProducts().get(1), 3);
//			System.out.println("User has added " + 3 + " " + wh.getProducts().get(1).getProdName() + " to Cart");
			
		}
		else {
			System.out.println("Insufficient Stocks.");
			System.out.println("Canceling Transaction.");
			System.out.println("Done");
			System.out.println("Thank you!");
			return;
		}

//		cust1.addToChart(wh.getProducts().get(1), 5); // Not Successful

		
		// Display Chart
		cust1.viewChart();

		cust1.removeToChart(wh.getProducts().get(0), 1); // remove from cart

		System.out.println();

		System.out.println("User Update Cart... ");
		System.out.println("Product: " + wh.getProducts().get(0).getProdName() + " Quantity: " + 1);
		System.out.println();

		cust1.viewChart();
		System.out.println();
		// Click Order
		cust1.setOrderStatus("Order Comitted");
		
		System.out.println("Order is now committed..Displaying order status.. ");

		System.out.println("Order Status: " + cust1.getOrderStatus());

		System.out.println();
		
		System.out.println("Customer Click Buy.");
		System.out.println("Processing credit card information...");

		if (!cust1.isValidToUpdate()) {
			System.out.println("Credit Balance exceeded the initial Balance Required");
			System.out.println();
			
			System.out.println("Canceling Transaction.");
			System.out.println("Done");
			System.out.println("Thank you!");
			return;
		}
		System.out.println("Credit card validation successful");
		System.out.println("Current Balance: " + cust1.getCreditBalance());
		System.out.println("Charging amount to credit card");
		cust1.setOrderStatus("Payment Success");
		cust1.updateCreditBalance();
		
		System.out.println();
		System.out.println("Order Status: " + cust1.getOrderStatus());
		System.out.println("Processing Transaction...");
		cust1.setOrderStatus("Delivery Out of Storage");
		wh.updateWareHouse(cust1.getOrder());
		
		System.out.println("Order Status: " + cust1.getOrderStatus());
		
		cust1.setOrderStatus("Ready to Receive");
		
		System.out.println();
		System.out.println("Order Status: " + cust1.getOrderStatus());

		
		
		System.out.println("Package Recieved by Customer " + cust1.getFname());
		
		System.out.println();
		cust1.setOrderStatus("Finished");
		System.out.println("Transaction Finished!");
		
		// displayWarehouseStocks(wh);

	}

	public static Customer register(String fname, String lname, String contact, String username, String password,
			String email) {
		return new Customer(0, fname, lname, contact, username, password, "customer", email, 200.50);
	}

	public static void displayWarehouseStocks(Warehouse w)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<? extends Warehouse> whClass = w.getClass();
		for (Product p : w.getProducts()) {
			System.out.println("Name: " + p.getProdName());
			System.out.println("Price: " + p.getPrice());
			System.out.println("Description: " + p.getDesc());
			System.out.println("Available Stock: " + whClass.getDeclaredField(p.getProdName()).get(w));
			System.out.println();
		}
	}

}

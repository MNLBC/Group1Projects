package com.oocl.mnlbc.grp1;

import java.util.List;

public class Shopping {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		// Registration
		System.out.println("Entering user details for registration...");
		Customer cust1 = register("Juan", "Dela Cruz", "09123456789", "jdcruz", "123", "asd@asd.com");
		System.out.println("Created Customer: " + cust1.getFname() + " " + cust1.getLname());
		System.out.println("Registration Successful");
		System.out.println();

		// User Login
		System.out.println("User " + cust1.getUsername() + " has logged in.");
		System.out.println("Welcome to Valley Online Shop!");
		System.out.println();

		// Warehouse Initialization
		Warehouse wh = new Warehouse(5, 5, 5, 4);
		System.out.println("Customer View Products: ");

		// Display Warehouse
		displayWarehouseStocks(wh);

		// Customer adds Product to Cart(Order)
		// Checking if Warehouse enough Stocks
		if (cust1.hasEnoughStocks(wh, wh.getProducts().get(0), 5)) {
			// 5 Shampoo
			cust1.addToCart(wh.getProducts().get(0), 5);
			System.out.println("User has added " + 5 + " " + wh.getProducts().get(0).getProdName() + " to Cart");
			System.out.println();

			// 3 Pencil
			// cust1.addToCart(wh.getProducts().get(1), 3);
			// System.out.println("User has added " + 3 + " " +
			// wh.getProducts().get(1).getProdName() + " to Cart");

			// Display Cart
			cust1.viewCart();
			System.out.println();
		} else {
			// Quantity in Cart is more than Warehouse
			System.out.println("Insufficient Stocks.");

			// Cancel Transaction
			System.out.println("Canceling Transaction.");
			System.out.println("Done");
			System.out.println("Thank you!");
			return;
		}

		// Not Successful
		// Exceeds Credit Limit
		// cust1.addToCart(wh.getProducts().get(1), 5);

		// Remove 1 Shampoo from Cart
		{
			System.out.println("User Update Cart... ");
			System.out.println("Product: " + wh.getProducts().get(0).getProdName() + " Quantity: " + 1);
			System.out.println();
			cust1.removeToCart(wh.getProducts().get(0), 1);

			cust1.viewCart();
			System.out.println();
		}

		// Click Order
		// Order Comitted
		cust1.setOrderStatus("Order Comitted");
		System.out.println("Order is now committed..Displaying order status.. ");
		System.out.println("Order Status: " + cust1.getOrderStatus());

		System.out.println();

		// Customer Clicks Buy
		System.out.println("Customer Click Buy.");
		System.out.println("Processing credit card information...");

		// Check Customer's Credit Balance
		if (!cust1.isValidToUpdate()) {
			// Exceeds Credit Balance
			System.out.println("Credit Balance exceeded the initial Balance Required");
			System.out.println();

			// Cancel Transaction
			System.out.println("Canceling Transaction.");
			System.out.println("Done");
			System.out.println("Thank you!");
			return;
		}

		// Successful in checking of Credit
		// Charging to Credit
		System.out.println("Credit card validation successful");
		System.out.println("Current Balance: " + cust1.getCreditBalance());
		System.out.println("Charging amount to credit card");
		cust1.setOrderStatus("Payment Success");
		cust1.updateCreditBalance();
		System.out.println("Order Status: " + cust1.getOrderStatus());

		// Delivery
		System.out.println();
		System.out.println("Processing Transaction...");
		cust1.setOrderStatus("Delivery Out of Storage");
		wh.updateWareHouse(cust1.getOrder());
		System.out.println("Order Status: " + cust1.getOrderStatus());

		// Product arrived
		cust1.setOrderStatus("Ready to Receive");
		System.out.println();
		System.out.println("Order Status: " + cust1.getOrderStatus());

		// Product Received by the Customer
		System.out.println("Package Recieved by Customer " + cust1.getFname());
		System.out.println();

		// Transaction Closes
		cust1.setOrderStatus("Finished");
		System.out.println("Transaction Finished!");
	}

	public static Customer register(String fname, String lname, String contact, String username, String password,
			String email) {
		// Returns Customer
		return new Customer(0, fname, lname, contact, username, password, "customer", email, 200.50);
	}

	public static void displayWarehouseStocks(Warehouse w)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		// Display Warehouse
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

package com.oocl.mnlbc.grp1;

public class App {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		Customer cust1 = new Customer(0, "Juan", "Dela Cruz", "09123456789", "jdcruz", "123", "type", "asd@asd.com",200.50);
		System.out.println("Created Customer: " + cust1.getFname() + " " + cust1.getLname());
		Warehouse wh = new Warehouse(5, 5, 5, 4);

		System.out.println("Customer View Products: ");
		displayWarehouseStocks(wh);

		// CUSTOMER BUY 3 Shampoo
		cust1.addToChart(wh.getProducts().get(0), 3);
		// cust1.addToChart(wh.getProducts().get(1), 3);
		// display chart
		cust1.viewChart();
		cust1.removeToChart(wh.getProducts().get(0), 5);
		
		System.out.println("Removed");
		cust1.viewChart();
		// Click Order
		System.out.println("Order is now committed");
		System.out.println("Customer Click Buy.");
		System.out.println("Processing credit card information...");
		if(!isValidCC(cust1.getCreditBalance())){
			System.out.println("Credit Balance exceeded the initial Balance Required");  
			return;
		}
		System.out.println("Credit card validation successful");
		System.out.println("Charging amount to credit card");
		
		
		cust1.updateCreditBalance();
		
		
		
		
		

	}

	public static void displayWarehouseStocks(Warehouse w)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<? extends Warehouse> whClass = w.getClass();
		for (Product p : w.getProducts()) {
			System.out.println("Name: " + p.getProdName() + " Price: " + p.getPrice() + " Description: " + p.getDesc()
					+ " Available Stock: " + whClass.getDeclaredField(p.getProdName()).get(w));
		}
	}


	public static boolean isValidCC(double creditBalance){
		
		if(creditBalance < 100){
			return false;
		}
		
		return true;
	}

}

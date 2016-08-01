package com.oocl.mnlbc.grp1;

import java.lang.reflect.Field;
import java.util.List;

public class Customer extends User {

	Order order = new Order("New", "Desc");
	private double creditBalance;

	public Customer(long id, String fname, String lname, String contact, String username, String password, String type,
			String email, double creditBalance) {
		super(id, fname, lname, contact, username, password, type, email);
		this.creditBalance = creditBalance;
	}

	public double getCreditBalance() {
		return creditBalance;
	}

	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}

	public void addToCart(Product product, int qty) {
		order.setProduct(product, qty);
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrderStatus(String status) {
		order.setStatus(status);
	}

	public String getOrderStatus() {
		return order.getStatus();
	}

	public boolean hasEnoughStocks(Warehouse wh, Product product, int qty)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		Field[] f = wh.getClass().getDeclaredFields();

		for (Field field : f)
			if (field.getName().equals(product.getProdName()))
				if (Integer.parseInt(field.get(wh).toString()) < qty)
					return false;
		return true;
	}

	public void removeToCart(Product product, int qt) {
		List<Product> products = order.getProducts();
		List<Integer> qty = order.getQty();

		// Getting index of Product
		int count = 0;
		for (Product prd : products) {
			if (prd.getProdName().equals(product.getProdName()))
				break;
			count++;
		}

		// Checking of Quantity in Cart
		if (qty.get(count) <= qt) {
			order.removeProductFromList(count);
		} else if (qty.get(count) > qt) {
			order.updateCartProductQty(count, qt);
		} else {
			System.out.println("ERROR!!!");
		}
	}

	public void viewCart() {
		List<Product> products = order.getProducts();
		List<Integer> qty = order.getQty();
		double total = 0;
		int count = 0;

		// Display Cart 
		System.out.println("View Cart");
		for (Product prod : products) {
			System.out.println("Product: " + prod.getProdName() + " Quantity: " + qty.get(count));
			double subTotal = qty.get(count) * prod.getPrice();
			total += subTotal;
			order.setTotal(total);
			count++;
		}
		System.out.println("Total Amount: " + total);
	}

	public void updateCreditBalance() {
		this.creditBalance = this.creditBalance + order.getTotal();
		System.out.println("Credit Balance: " + this.creditBalance);
	}

	public boolean isValidToUpdate() {
		double cbal = this.creditBalance + order.getTotal();
		if (cbal > 250)
			return false;
		else
			return true;

	}

}

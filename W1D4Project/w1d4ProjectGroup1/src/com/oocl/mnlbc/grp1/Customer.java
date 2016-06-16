package com.oocl.mnlbc.grp1;

import java.util.List;

public class Customer extends User{

	Order order = new Order("","Desc");
	
	public Customer(long id, String fname, String lname, String contact, String username, String password,
			String type, String email) {
		super(id, fname, lname, contact, username, password, type, email);

	}
	
	public void addToChart(Product product, int qty){
		order.setProduct(product, qty);
	}
	
	public void removeToChart(Product product, int qt){
		List<Product> products = order.getProducts();
		List<Integer> qty = order.getQty();
		
		int count=0;
		for (Product prd : products) {
			if(prd.getProdName().equals(product.getProdName())){
				break;
			}
			count++;
		}
		
		if(qty.get(count) == qt ){
			order.removeProductFromList(count);
		}else if(qty.get(count) > qt){ 
			order.updateChartProductQty(count, qt);
		}else{
			System.out.println("ERRORRR!!!");
		}
		
		
	}
	
	public void viewChart(){
		List<Product> products = order.getProducts();
		List<Integer> qty = order.getQty();
		double total = 0;
		int count = 0;
		for (Product prod : products) {
			System.out.println(prod.getProdName() + " " + qty.get(count));
			double subTotal = qty.get(count) * prod.getPrice();
			total += subTotal;
			count++;
			
			
		}
		
		System.out.println("Total Amount: " + total);
		
		
		
	}
	


	
}

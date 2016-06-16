package com.oocl.mnlbc.grp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {

	private String status;
	private String desc;
	private List<Product> products = new ArrayList<>();
	private List<Integer> qtys = new ArrayList<>();

	public Order(String status, String desc) {
		this.status = status;
		this.desc = desc;
	}
	
	public void setProduct(Product product, int qty){
		qtys.add(qty);
		products.add(product);
		
	}
	
	public List<Product> getProducts(){
		return this.products;
	}
	
	public List<Integer> getQty(){
		return this.qtys;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void removeProductFromList(int index){
		products.remove(index);
		qtys.remove(index);
	}
	
	public void updateChartProductQty(int index, int qty){
		qtys.set(index, qtys.get(index) - qty);
	}
	
	

}

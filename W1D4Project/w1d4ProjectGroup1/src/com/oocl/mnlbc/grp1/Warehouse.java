package com.oocl.mnlbc.grp1;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

	int shampoo ;
	int pencil ;
	int ballpen;
	int sando;
	List<Product> products;
	
	public Warehouse(int shampoo, int pencil, int ballpen, int sando) {
		this.shampoo = shampoo;
		this.pencil = pencil;
		this.ballpen = ballpen;
		this.sando = sando;
		
		products = new ArrayList<Product>();
		
		products.add(new Product("shampoo", 8, "Clear"));
		products.add(new Product("pencil",5, "s"));
		products.add(new Product("ballpen", 3, "d"));
		products.add(new Product("sando", 3, "a"));
		
	}
	
	public int getShampoo() {
		return shampoo;
	}
	public int getPencil() {
		return pencil;
	}
	public int getBallpen() {
		return ballpen;
	}
	public int getSando() {
		return sando;
	}
	public void setShampoo(int shampoo) {
		this.shampoo = shampoo;
	}
	public void setPencil(int pencil) {
		this.pencil = pencil;
	}
	public void setBallpen(int ballpen) {
		this.ballpen = ballpen;
	}
	public void setSando(int sando) {
		this.sando = sando;
	}
	
	
	public List<Product> getProducts(){
		return this.products;
	}
	
}

package com.oocl.mnlbc.grp1;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

	int shampoo;
	int pencil;
	int ballpen;
	int sando;
	List<Product> products;

	public Warehouse(int shampoo, int pencil, int ballpen, int sando) {
		// Initialization of Warehouse
		this.shampoo = shampoo;
		this.pencil = pencil;
		this.ballpen = ballpen;
		this.sando = sando;

		products = new ArrayList<Product>();

		products.add(new Product("shampoo", 8, "Clear"));
		products.add(new Product("pencil", 5, "Mongol"));
		products.add(new Product("ballpen", 3, "Panda"));
		products.add(new Product("sando", 3, "Bench"));

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

	public List<Product> getProducts() {
		return this.products;
	}

	public void updateWareHouse(Order order) {
		// Updating Warehouse after buying
		List<Product> products = order.getProducts();
		List<Integer> qty = order.getQty();
		int count = 0;
		for (Product p : products) {

			switch (p.getProdName()) {
			case "shampoo":
				this.shampoo = this.shampoo - qty.get(count);
				break;
			case "pencil":
				this.pencil = this.pencil - qty.get(count);
				break;
			case "ballpen":
				this.ballpen = this.ballpen - qty.get(count);
				break;
			case "sando":
				this.sando = this.sando - qty.get(count);
				break;

			default:
				break;
			}
			count++;
		}
	}

}

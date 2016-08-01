package com.oocl.mnlbc.num4;

/**
 * 
 * @author barrepe
 * @version 1
 */
public class Employee {
	private int id;
	private String first_name;
	private String last_name;
	private int mgrid;
	private double salary;
	
	public Employee(int id, String first_name, String last_name, int mgrid, double salary) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mgrid = mgrid;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getMgrid() {
		return mgrid;
	}
	public void setMgrid(int mgrid) {
		this.mgrid = mgrid;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}

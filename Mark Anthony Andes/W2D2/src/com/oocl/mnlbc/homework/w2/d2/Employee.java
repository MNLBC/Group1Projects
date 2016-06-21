package com.oocl.mnlbc.homework.w2.d2;

public class Employee {
	private int id;
    private String fisrtName;
    private String lastName;
    private String mgrid;
    private int salary;
    
    
	public Employee(String fisrtName, String lastName, String mgrid, int salary) {
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.mgrid = mgrid;
		this.salary = salary;
	}
	public Employee(int id, String fisrtName, String lastName, String mgrid, int salary) {
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.mgrid = mgrid;
		this.salary = salary;
	}
	
	public Employee(int id, String lastName) {
		this.id = id;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMgird() {
		return mgrid;
	}
	public void setMgird(String mgrid) {
		this.mgrid = mgrid;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

    
}

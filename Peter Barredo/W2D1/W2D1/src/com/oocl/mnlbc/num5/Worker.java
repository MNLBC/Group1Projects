package com.oocl.mnlbc.num5;
import java.util.Comparator;

public class Worker  implements Comparator<Worker>{
	private int id;
	private int age;
	private String name;
	private double salary;
	public Worker() { 
	}
	public Worker(String name, int age, double salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}
	public Worker (int id, String name, int age, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void work() {
		System.out.println(name + "is working");
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}
	@Override
	public int compare(Worker o1, Worker o2) {
		Worker w1 = (Worker) o1;
		Worker w2 = (Worker) o2;
		
		if(w1.getSalary() > w2.getSalary()){
			return -1;
		}
		if(w1.getSalary() < w2.getSalary()){
			return 1;
		}
		
		return 0;
	}
	
	
	
}

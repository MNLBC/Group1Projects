package com.oocl.mnlbc.num5;
import java.util.*;
/**
 * 
 * @author barrepe
 *
 */

public class App2 {
	public static void main(String[] args) {
		List<Worker> workerList = new ArrayList<Worker>();
		workerList.add(new Worker("Simon",20,10000));
		workerList.add(new Worker("Jame",25,13000));
		workerList.add(new Worker("Alex",22,12000));
		
		System.out.println("Name\tAge\tSalary");
		
		workerList.add(1,new Worker("Steven",24,15000));
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t" + worker.getAge() + "\t" + worker.getSalary());
		}
	}
}

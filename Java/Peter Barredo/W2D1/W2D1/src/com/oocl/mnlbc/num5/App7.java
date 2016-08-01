package com.oocl.mnlbc.num5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author barrepe
 *
 */

public class App7 {

	public static void main(String[] args) {
		List<Worker> workerList = new ArrayList<Worker>();
		
		workerList.add(new Worker("Simon",20,10000));
		workerList.add(new Worker("Jame",25,13000));
		workerList.add(new Worker("Alex",22,12000));
		
		workerList.sort(new Worker());
		
		for (Worker worker : workerList) {
			System.out.println("Name: "+ worker.getName() + "\tAge: " + worker.getAge() + "\t\tSalary: " + worker.getSalary());
		}
	}

}

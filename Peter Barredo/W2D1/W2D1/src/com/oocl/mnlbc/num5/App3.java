package com.oocl.mnlbc.num5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author barrepe
 *
 */

public class App3 {

	public static void main(String[] args) {
		List<Worker> workerList = new ArrayList<Worker>();
		workerList.add(new Worker("Simon",20,10000));
		workerList.add(new Worker("Jame",25,13000));
		workerList.add(new Worker("Alex",22,12000));
		
		System.out.println("Name\tAge\tSalary");
		
		Iterator<Worker> iter = workerList.iterator();
		while (iter.hasNext()) {
			Worker worker = iter.next();
			if(worker.getName().equals("Alex")){
				iter.remove();
			}
			
		}
		
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t" + worker.getAge() + "\t" + worker.getSalary());
		}
		
	}

}

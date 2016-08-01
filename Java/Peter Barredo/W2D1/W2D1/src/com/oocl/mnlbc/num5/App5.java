package com.oocl.mnlbc.num5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author barrepe
 *
 */

public class App5 {
	public static void main(String[] args) {
		List<Worker> workerList = new ArrayList<Worker>();
		workerList.add(new Worker("Simon",20,10000));
		workerList.add(new Worker("Jame",25,13000));
		workerList.add(new Worker("Alex",22,12000));
		
		Iterator<Worker> iter = workerList.iterator();
		while (iter.hasNext()) {
			Worker worker = iter.next();
			worker.work();
			
		}
	}
}

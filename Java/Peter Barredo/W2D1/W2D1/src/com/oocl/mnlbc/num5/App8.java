package com.oocl.mnlbc.num5;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * 
 * @author barrepe
 *
 */
public class App8 {

	public static void main(String[] args) {
		
		Map<String, Worker > workerMap = new HashMap<String, Worker>();
		
		workerMap.put("1", new Worker(1,"Simon",20,10000));
		workerMap.put("2", new Worker(2,"Jame",25,13000));
		workerMap.put("3", new Worker(3,"Alex",22,12000));
		
		//1
		System.out.println("=====================================");
		Iterator it = workerMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Worker w = (Worker) pair.getValue();
	        System.out.println("Worker Id: " + w.getId() + " Name: " + w.getName() + " Age: " + w.getAge() +  " Salary: " + w.getSalary());
	    }	
	    
	    //2
	    System.out.println("=====================================");
	    for (Map.Entry<String, Worker> entry : workerMap.entrySet()) {
	    	Worker w = entry.getValue();
	    	System.out.println("Worker Id: " + w.getId() + " Name: " + w.getName() + " Age: " + w.getAge() +  " Salary: " + w.getSalary());
	    }
	    
	    //3
	    System.out.println("=====================================");
	    
	    for (String key : workerMap.keySet()) {
	        Worker w = workerMap.get(key);
	        System.out.println("Worker Id: " + w.getId() + " Name: " + w.getName() + " Age: " + w.getAge() +  " Salary: " + w.getSalary());
	    }

	}

}

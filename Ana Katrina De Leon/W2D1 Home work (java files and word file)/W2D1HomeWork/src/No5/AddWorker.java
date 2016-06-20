package No5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AddWorker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Worker worker = new Worker();
		List<Worker> list = new ArrayList<Worker>();
		
		list.add(new Worker("Simon", 20, 10000));
		list.add(new Worker("Jame", 25, 13000));
		list.add(new Worker("Alex", 22, 12000));
		
		System.out.println("1) Create a List and add three workers");
		System.out.println("Name\t\t\tAge\t\t\tSalary");
		for (Worker worker2 : list) {
			System.out.println(worker2.getName() + "\t\t\t" + worker2.getAge() + "\t\t\t" + worker2.getSalary());
		}
		
		System.out.println("2) Add one worker before Jame ( Steven, 24, 15000)");
		list.add(1, new Worker("Steven", 24, 15000));
		System.out.println("Name\t\t\tAge\t\t\tSalary");
		for (Worker worker2 : list) {
			System.out.println(worker2.getName() + "\t\t\t" + worker2.getAge() + "\t\t\t" + worker2.getSalary());
		}
		
		System.out.println("3) & 4) Remove Alex and print worker's info");
		list.remove(3);
		System.out.println("Name\t\t\tAge\t\t\tSalary");
		for (Worker worker2 : list) {
			System.out.println(worker2.getName() + "\t\t\t" + worker2.getAge() + "\t\t\t" + worker2.getSalary());
		}
		
		System.out.println("5) Use of iterator");
		
		Iterator workerIterator = list.iterator();
		 System.out.println("Name\t\t\tAge\t\t\tSalary");
		while (workerIterator.hasNext()) {
		    Object key = workerIterator.next();
		    System.out.println(((Worker) key).getName() + "\t\t\t" + ((Worker) key).getAge() + "\t\t\t" + ((Worker) key).getSalary());
		}
		
		System.out.println("7) Sort the all the workers from high to low by salary ");
		Collections.sort(list);
		for (Worker worker2 : list) {
			System.out.println("Name: " + worker2.getName() + "\t\t\t" + "Salary: " + worker2.getSalary());
		}

		System.out.println("8) Map");
		Map<String, Worker> workMap = new HashMap<String, Worker>();
		int id = 0;
		for (Worker worker2 : list) {
			workMap.put(Integer.toString(id + 1), worker2);
			worker2.setId(Integer.toString(id + 1));
			id++;
		}
		for (Entry<String, Worker> e: workMap.entrySet()){
			String keyId = e.getKey();
			Worker info = e.getValue();
			System.out.println("Worker ID: " + keyId + " Name: " + info.getName() + " Age: " + info.getAge() + " Salary: " + info.getSalary());
		}
		
		System.out.println();
		for(String keyId: workMap.keySet()){
			Worker info = workMap.get(keyId);
			System.out.println("Worker ID: " + keyId + " Name: " + info.getName() + " Age: " + info.getAge() + " Salary: " + info.getSalary());
		}
			
		System.out.println();
		Iterator<Worker> w = list.iterator();
		while(w.hasNext()) {
			Worker wkr = (Worker) w.next();
			System.out.println("Worker ID: " + wkr.getId() + " Name: " + wkr.getName() + " Age: " + wkr.getAge() + " Salary: " + wkr.getSalary());
		}
	}

}

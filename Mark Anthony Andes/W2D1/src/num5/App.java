package num5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class App {
	
	public static void main(String[] args) {	
	
	List<Worker> wList = new ArrayList<>();	
	wList.add(new Worker("Simon", 20, 10000));
	wList.add(new Worker("Jame", 25, 13000));
	wList.add(new Worker("Alex", 22, 12000));
	
	
	System.out.println("Name \t\t\t Age \t\t\t Salary");
	for (Worker worker : wList) {
		System.out.println(worker.getName() + "\t\t\t" + worker.getAge() + "\t\t\t" + worker.getSalary());
	}
	
	wList.add(1, new Worker("Steven", 24, 15000));
	
	System.out.println();
	System.out.println("-----Added Steven-----");
	System.out.println("Name \t\t\t Age \t\t\t Salary");
	for (Worker worker : wList) {
		System.out.println(worker.getName() + "\t\t\t" + worker.getAge() + "\t\t\t" + worker.getSalary());
	}
	
	wList.remove(3);	
	System.out.println();
	System.out.println("-----Removed Alex-----");
	System.out.println("Name \t\t\t Age \t\t\t Salary");
	for (Worker worker : wList) {
		System.out.println(worker.getName() + "\t\t\t" + worker.getAge() + "\t\t\t" + worker.getSalary());
	}
	
	
	//Using Iterator
	System.out.println();
	System.out.println("\t---Using Iterator---");
	System.out.println("Name \t\t\t Age \t\t\t Salary");
	Iterator<Worker> iterator = wList.iterator();
	while (iterator.hasNext()) {
		Object key = iterator.next();
		System.out.println(((Worker)key).getName() + "\t\t\t"+  ((Worker)key).getAge()+ "\t\t\t"+  ((Worker)key).getSalary() );
		
	}
	
	
	System.out.println();
	System.out.println("\t---Sorted Salary---");
	Collections.sort(wList);
	for (Worker worker : wList) {
		System.out.println("Name:"+worker.getName() +"\tSalary" + worker.getSalary());
	}
	
	System.out.println();
	System.out.println("\t---Added ID--- 01");
	Map <Integer , Worker>hashMap = new HashMap<Integer , Worker>();
	int counter =0;
	for (Worker worker : wList) {
		hashMap.put(counter, worker);
		counter++;
	}
	
	
	
	for (Entry<Integer, Worker> e: hashMap.entrySet()){
		int keyId = e.getKey();
		Worker info = e.getValue();
		System.out.println("Worker ID: " + keyId + " Name: " + info.getName() + " Age: " + info.getAge() + " Salary: " + info.getSalary());
	}
	
	System.out.println();
	System.out.println("\t---Added ID--- 02");
	Set<?> set  = hashMap.entrySet();
	Iterator<?> i = set.iterator();
	while(i.hasNext()){
		Map.Entry map = (Map.Entry)i.next();
		System.out.println("Worker ID: " + map.getKey() + " Name: " + hashMap.get(map.getKey()).getName() + "Age: "+hashMap.get(map.getKey()).getAge()  + "Salary: "+hashMap.get(map.getKey()).getSalary()); 
	}
	
	System.out.println();
	System.out.println("\t---Added ID--- 03");
	for(Integer keyId: hashMap.keySet()){
		Worker info = hashMap.get(keyId);
		System.out.println("Worker ID: " + keyId + " Name: " + info.getName() + " Age: " + info.getAge() + " Salary: " + info.getSalary());
		}
	
	}
}

package w2d1_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<Worker> list = new ArrayList<Worker>();

		list.add((new Worker("Simon", 20, 10000)));
		list.add((new Worker("Jame", 25, 13000)));
		list.add((new Worker("Alex", 22, 12000)));

		// Add Steven
		list.add(1, (new Worker("Steven", 24, 15000)));

		// Display the workers
		System.out.println("Name\t\t" + "Age\t\t" + "Salary\t\t");
		for (Worker w : list) {

			System.out.println(w.getName() + "\t\t" + w.getAge() + "\t\t" + w.getSalary());
		}
		// Remove Alex
		Iterator<Worker> itr = list.iterator();
		while (itr.hasNext()) {
			Worker w = (Worker) itr.next();
			if (w.getName().contains("Alex")) {
				itr.remove();
			}

		}
		System.out.println("\nAfter Removing Alex..\n");
		System.out.println("Name\t\t" + "Age\t\t" + "Salary\t\t");
		for (Worker w2 : list) {

			System.out.println(w2.getName() + "\t\t" + w2.getAge() + "\t\t" + w2.getSalary());
		}
		
		System.out.println("");
		Iterator<Worker> itr2 = list.iterator();
		while (itr2.hasNext()){
			Worker w2 = (Worker) itr2.next();
			w2.work();
		}
		
		Collections.sort(list);
		
		System.out.println();
		for (Worker w3: list){
			System.out.println(w3.getName() + " " + w3.getSalary());
		}
		
		Map<String, Worker> workMap = new HashMap<String, Worker>();
		int c = 0;
		for (Worker w4 : list) {
		workMap.put(Integer.toString(c + 1), w4);
		w4.setId(Integer.toString(c + 1));
		c++;
		}

		System.out.println("\nHashMap");
		for (Entry<String, Worker> entry : workMap.entrySet()) {
		String key = entry.getKey();
		Worker value = entry.getValue();
		System.out.println("ID: " + key + "\t\tName: " + value.getName() + "\t\tAge: " + value.getAge()
		+ "\t\tSalary: " + value.getSalary());

		}
		System.out.println();
		for (String key : workMap.keySet()) {
		Worker value = workMap.get(key);
		System.out.println("ID: " + key + "\t\tName: " + value.getName() + "\t\tAge: " + value.getAge()
		+ "\t\tSalary: " + value.getSalary());
		}
		System.out.println();

		for (Worker w : workMap.values()) {
		System.out.println("ID: " + w.getId() + "\t\tName: " + w.getName() + "\t\tAge: " + w.getAge()
		+ "\t\tSalary: " + w.getSalary());
		}
		
		
		

	}

}

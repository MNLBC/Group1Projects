import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App {
	public static void main(String[] args) {

		List<Worker> workerList = new ArrayList<Worker>();
		workerList.add(new Worker("Simon", 20, 10000));
		workerList.add(new Worker("Jame", 25, 13000));
		workerList.add(new Worker("Alex", 22, 12000));
		workerList.add(1, new Worker("Steven", 24, 15000));
		System.out.println("1 and 2 output all workers and info and add worker jame");
		System.out.println("Name\t\tAge\t\tSalary");
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t\t" + worker.getAge() + "\t\t" + worker.getSalary());
		}
		System.out.println("============================ 3. remove worker alex and 4. display info using for loop");

		// remove alex
		Iterator<Worker> wIterator = workerList.iterator();
		while (wIterator.hasNext()) {
			Worker workerIterator = wIterator.next();
			if (workerIterator.getName().equals("Alex")) {
				wIterator.remove();
			}
		}
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t\t" + worker.getAge() + "\t\t" + worker.getSalary());
		}
		System.out.println("============================ 5. calling worker method");

		// use iterator to run the worker's method work
		Iterator<Worker> wIterator2 = workerList.iterator();
		while (wIterator2.hasNext()) {
			Worker workerIterator = wIterator2.next();
			workerIterator.work();
		}

		System.out.println("============================ 6.Overwrite equals TEST");
		Worker Steven = new Worker("Simon", 20, 10000);
		Worker Steven2 = new Worker("Simon", 20, 10000);
		if(Steven.equals(Steven2)){
			System.out.println("Objects are equal");
		}else
			System.out.println("Objects are not equal");
		
		System.out.println("============================ 7. sorting based on salary");

		// sort workers by salary
		Collections.sort(workerList);
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t\t" + worker.getSalary());
		}

		System.out.println("============================ 8. output hashmap");
		Map<String, Worker> stringWorker = new HashMap<String, Worker>();
		int ctr = 0;
		for (Worker worker : workerList) {
			stringWorker.put(Integer.toString(ctr), worker);
			worker.setId(Integer.toString(ctr));
			ctr++;
		}
		for (Entry<String, Worker> entry : stringWorker.entrySet()) {
			String key = entry.getKey();
			Worker value = entry.getValue();
			System.out.println("ID: " + key + "\t\tName: " + value.getName() + "\t\tAge: " + value.getAge()
					+ "\t\tSalary: " + value.getSalary());

		}
		System.out.println();
		for (String key : stringWorker.keySet()) {
			Worker value = stringWorker.get(key);
			System.out.println("ID: " + key + "\t\tName: " + value.getName() + "\t\tAge: " + value.getAge()
					+ "\t\tSalary: " + value.getSalary());
		}
		System.out.println();
		Iterator<Worker> wL = workerList.iterator();
		while (wL.hasNext()) {
			Worker worker = (Worker) wL.next();
			System.out.println("ID: " + worker.getId() + "\t\tName: " + worker.getName() + "\t\tAge: "
					+ worker.getAge() + "\t\tSalary: " + worker.getSalary());
		}
	}
}

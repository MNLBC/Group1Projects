package num2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
//import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test {

	public static void main(String args[]) {
//		List<String> list = new ArrayList<String>();

//		List<String> list = new LinkedList<String>();
		
		Vector<String> list = new Vector<String>();
		list.add("Hello");
		list.add("World");
		list.add(1, "Learn");
		list.add(1, "Java");
		printList(list);
	}

	public static void printList(List<String> list) { 
// 1
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		for (Object o : list) {
			System.out.println(o);
		}
		System.out.println();
		Iterator<String> itor = list.iterator();
		while (itor.hasNext()) {
			System.out.println(itor.next());
		}
	}

}

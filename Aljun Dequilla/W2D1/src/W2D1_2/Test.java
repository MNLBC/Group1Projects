package W2D1_2;

import java.util.*;

public class Test {
	public static void main(String args[]) {
		List<String> list = new Vector<String>();
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
		for (Object o : list) {
			System.out.println(o);
		}
		Iterator<String> itor = list.iterator();
		while (itor.hasNext()) {
			System.out.println(itor.next());
		}
	}
}

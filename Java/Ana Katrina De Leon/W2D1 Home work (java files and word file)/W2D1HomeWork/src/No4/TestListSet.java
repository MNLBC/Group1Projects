package No4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestListSet {
	public static void main (String[] args){
		List list = new ArrayList();
		list.add("Hello");
		list.add("Learn");
		list.add("Hello");
		list.add("Welcome");
		Set set = new HashSet();
		set.addAll(list);
		System.out.println(set.size());

	}
}

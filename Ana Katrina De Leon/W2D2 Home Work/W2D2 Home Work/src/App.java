
public class App {

	public static void main(String[] args) {
		JDBCOperation.deleteAll();
	    
	    JDBCOperation.insert(new Employee(1,"rose", "Tyler", 4, 1500));
	    JDBCOperation.insert(new Employee(2,"Matha", "Jones", 4, 2200));
	    JDBCOperation.insert(new Employee(3,"Donna", "Noble", 4, 1300));
	    JDBCOperation.insert(new Employee(4,"Doctor", "Who",  0, 5500));
	    JDBCOperation.insert(new Employee(5,"Jack", "Harkness", 1, 3500));
	    
	    //4.1)Insert Alex Lee
	    JDBCOperation.insert(new Employee(6,"Alex", "Lee", 1, 4500));
	    JDBCOperation.getAll();
//	    
	    //4.2) Modify last name to Tate
	    JDBCOperation.update(new Employee(2, "Matha", "Tate", 4, 2200));
	    JDBCOperation.getAll();
	    
	}

}

package w2d2;


public class JDBCOperation {
	public static void main(String args[]) {
		JDBC.getAll();
		
		//ADD
		JDBC.insert(new Employee(6,"Lee","Alex",1,4500));
		JDBC.getAll();
//		
		JDBC.update("Tate","Jones");
		JDBC.getAll();
	}

}

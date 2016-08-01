package com.oocl.mnlbc.homework.w2.d2;

public class App {

		public static void main(String[] args) {
			
			JDBCOperation.deleteAll();
			JDBCOperation.insert(new Employee(1,"rose", "Tyler", "4", 1500));
			JDBCOperation.insert(new Employee(2,"Matha", "Jones", "4", 2200));
			JDBCOperation.insert(new Employee(3,"Donna", "Noble", "4", 1300));
			JDBCOperation.insert(new Employee(4,"Doctor", "Who", " ", 5500));
			JDBCOperation.insert(new Employee(5,"Jack", "Harkness", "1", 3500));
			System.out.println("\t---Display all Recordes---");
			JDBCOperation.getAll();
			
			System.out.println();
			System.out.println("\t---Added Employee Alex Lee---");
			JDBCOperation.insert(new Employee(6,"Alex", "Lee", "1", 4500));
			JDBCOperation.getAll();
			
			System.out.println();
			System.out.println("---Update Employee Matha Jones to  Matha Tate---");
			JDBCOperation.updateLastName(new Employee(2, "Tate"));
			JDBCOperation.getAll();
			
			
			
		}
}

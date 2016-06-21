package com.oocl.mnlbc.num4;

import java.util.List;

public class App {

	public static void main(String[] args) {
		DBConnect con = new DBConnect();
		
		//Adding employee alex
		/*Employee alex = new Employee(6,"Alex","Lee",1,4500);
		con.insertToDB(alex);*/
		
		/*Employee empResult = con.findEmployeeByLastname("Jones");
		con.updateRecordLastName(empResult, "Tate");*/
		
		List<Employee> allEmployee =  con.getAllEmployee();
		System.out.println("ID\tFIRST_NAME\tLAST_NAME\tMGRID\tSALARY");
		for (Employee employee : allEmployee) {
			System.out.println(employee.getId() + "\t" + employee.getFirst_name() + "\t\t" + employee.getLast_name() + "\t\t" + employee.getMgrid() + "\t" + employee.getSalary() );
		}
	}

}

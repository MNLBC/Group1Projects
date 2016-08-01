package w2d2;

public class Employee {
		private int id;
		private String First_Name;
	    private String Last_Name;
	  	private int MGRID;
	  	private int Salary;
		public Employee(int id, String first_Name, String last_Name, int mGRID, int salary) {
			this.id = id;
			First_Name = first_Name;
			Last_Name = last_Name;
			MGRID = mGRID;
			Salary = salary;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirst_Name() {
			return First_Name;
		}
		public void setFirst_Name(String first_Name) {
			First_Name = first_Name;
		}
		public String getLast_Name() {
			return Last_Name;
		}

		public void setLast_Name(String last_Name) {
			Last_Name = last_Name;
		}
		public int getMGRID() {
			return MGRID;
		}
		public void setMGRID(int mGRID) {
			MGRID = mGRID;
		}
		public int getSalary() {
			return Salary;
		}
		public void setSalary(int salary) {
			Salary = salary;
		}
		
}
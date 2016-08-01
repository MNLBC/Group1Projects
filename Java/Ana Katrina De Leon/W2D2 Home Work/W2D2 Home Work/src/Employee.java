
public class Employee {
    private int Id;
    private String FirstName;
    private String LastName;
    private int Mgrid;
    private int Salary;
    
	public Employee(String firstName, String lastName, int mgrid, int Salary) {
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Mgrid = mgrid;
		this.Salary = Salary;
	}
	
	public Employee(int id, String firstName, String lastName, int mgrid, int Salary) {
		this.Id = id;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Mgrid = mgrid;
		this.Salary = Salary;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getMgrid() {
		return Mgrid;
	}

	public void setMgrid(int mgrid) {
		Mgrid = mgrid;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int Salary) {
		this.Salary = Salary;
	}

    
}

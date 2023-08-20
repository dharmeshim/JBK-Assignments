package employeesystem;

public class Manager extends Employee {

	private String department;

	public Manager(int id, String name, String department) {
		super(id, name);
		this.department = department;

	}

	public void getDetails() {
		System.out.println("Employee ID : " + getId() + "\nEmployee name : " + getName() + "\nManager of " + department
				+ " department");
	}

}

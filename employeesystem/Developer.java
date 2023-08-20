package employeesystem;

public class Developer extends Employee {

	private String programmingLanguage;

	public Developer(int id, String name, String programmingLanguage) {
		super(id, name);
		this.programmingLanguage = programmingLanguage;
	}

	public void getDetails() {
		System.out.println("Employee ID : " + getId() + "\nEmployee name : " + getName()
				+ "\nDeveloper Programming Language : " + programmingLanguage);
	}

}

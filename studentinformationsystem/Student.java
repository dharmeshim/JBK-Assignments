package studentinformationsystem;

public class Student {
	
	private String name;
	private int age;
	private int studentID;
	private static int IdGenrate=100;
	
	public Student() {
		name = "Unknown";
		age = 0;
		studentID = IdGenrate++;
	}
	
	
	public Student(String name, int age) {
		this.name = name;
		this.age= age;
		studentID = IdGenrate++;
		
		
	}
	
	public int getID() {
		return studentID;
	}
	
	public void getDetails() {
		System.out.println("Student name : "+name
				+"\nStudent age : "+age
				+"\nStudent ID : "+studentID);
	}

}

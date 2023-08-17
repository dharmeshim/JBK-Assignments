package staticinstance;

public class Main {
	
	public static void main(String[] args) {
		Student student1Student = new Student(1, "AA");
		student1Student.enrollStudent();
		student1Student.dropStudent();
		
		
		
		
		System.out.println(student1Student.getTotalStudent());
		
	}
	

}

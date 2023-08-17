package staticinstance;

public class Student {
	private int studentId;
	private String studentName;
	private static int totalStudent = 0;
	
	
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		totalStudent++;
	}
	
	public void enrollStudent() {
		totalStudent++;
		System.out.println("Student "+studentName+" enrolled successfuly");

	}
	public void dropStudent() {
		totalStudent--;
		System.out.println("Student "+studentName+" droped successfuly");

		
	}

	public int getTotalStudent() {
		return totalStudent;
	}

	public void setTotalStudent(int totalStudent) {
		Student.totalStudent = totalStudent;
	}	
		
		
	}
	
	
	
	
	



package oopconcepts;

public class MainProgram {
	public static void main(String[] args) {

		Book book1 = new Book("Ikigai: The Japanese Secret", 100, "Francesc miralles");
		book1.displayInfo();

		DVD dvd1 = new DVD("Documentry movie", 102, 2.10);
		dvd1.displayInfo();

		StudentMember student1 = new StudentMember(1000);
		student1.borrowItem(book1);

		FacultyMember faculty1 = new FacultyMember(2000);
		faculty1.borrowItem(dvd1);

	}

}

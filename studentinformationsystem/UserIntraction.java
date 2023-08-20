package studentinformationsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class UserIntraction {

	public static void main(String[] args) {

		ArrayList<Student> students = new ArrayList<>();

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("\n1. Add with default\n2. Input Values\n3. Find Student\n4. Exit");

			System.out.print("Enter your choice: ");
			int choice = scan.nextInt();

			if (choice == 1) {
				Student student = new Student();
				students.add(student);
				System.out.println("**Added**");
				student.getDetails();

			}

			else if (choice == 2) {
				Student student = parameteredStudent(scan);
				students.add(student);
				System.out.println("**Added**");
				student.getDetails();

			}

			else if (choice == 3) {
				getStudentDetails(students, scan);
			}

			else if (choice == 4) {
				break;
			}

			else {
				System.out.println("Invalid");
			}
		}

	}

	public static Student parameteredStudent(Scanner scan) {

		String name;
		int age;
		System.out.println("\nEnter student name : ");
		scan.nextLine();
		name = scan.nextLine();

		System.out.println("Enter student age : ");
		age = scan.nextInt();

		return new Student(name, age);

	}

	public static void getStudentDetails(ArrayList<Student> students, Scanner scan) {
		System.out.println("Enter Student ID : ");
		int id = scan.nextInt();
		for (Student student : students) {
			if (student.getID() == id) {
				student.getDetails();
				break;
			}

		}

	}
}

package employeesystem;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeHierarchy {
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("\n1. Create Manager\n2. Create Developer\n3. Get Employee Details\n4. Exit");

			System.out.print("Enter your choice: ");
			int choice = scan.nextInt();

			if (choice == 1) {
				Manager manager = createManager(scan);
				employees.add(manager);
				System.out.println("**Added**");
				manager.getDetails();
			}

			else if (choice == 2) {
				Developer developer = createDeveloper(scan);
				employees.add(developer);
				System.out.println("**Added**");
				developer.getDetails();
			}

			else if (choice == 3) {
				displayEmployeeDetails(employees, scan);
			}

			else if (choice == 4) {
				System.out.println("Exit!");
				break;
			}

			else {
				System.out.println("Invalid choice. Please choose again.");
			}
		}
	}

	public static Manager createManager(Scanner scan) {

		int id;
		String name;
		String department;

		System.out.print("Enter manager's ID: ");
		id = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter manager's name: ");
		name = scan.nextLine();
		System.out.print("Enter manager's department: ");
		department = scan.nextLine();
		return new Manager(id, name, department);
	}

	public static Developer createDeveloper(Scanner scan) {
		System.out.print("Enter developer's ID: ");
		int id = scan.nextInt();
		scan.nextLine();

		System.out.print("Enter developer's name: ");
		String name = scan.nextLine();
		System.out.print("Enter developer's programming language: ");
		String programmingLanguage = scan.nextLine();
		return new Developer(id, name, programmingLanguage);
	}

	public static void displayEmployeeDetails(ArrayList<Employee> employees, Scanner scan) {
		System.out.println("Enter employee ID : ");
		int id = scan.nextInt();
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				employee.getDetails();
				break;
			}

		}
	}
}

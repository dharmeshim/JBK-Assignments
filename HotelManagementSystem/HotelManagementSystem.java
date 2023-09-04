package exceptionHandling.hotelManagementSystem;

import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Hire Employee");
            System.out.println("2. Fire Employee");
            System.out.println("3. Assign Task");
            System.out.println("4. List All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter employee name: ");
                    String employeeName = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    String employeeID = scanner.nextLine();
                    Employee employee = new Employee(employeeID, employeeName);
                    employeeManagement.hireEmployee(department, employee);
                } else if (choice == 2) {
                    System.out.print("Enter department: ");
                    String fireDepartment = scanner.nextLine();
                    System.out.print("Enter employee ID to fire: ");
                    String fireEmployeeID = scanner.nextLine();
                    employeeManagement.fireEmployee(fireDepartment, fireEmployeeID);
                } else if (choice == 3) {
                    System.out.print("Enter department: ");
                    String taskDepartment = scanner.nextLine();
                    System.out.print("Enter task to assign: ");
                    String task = scanner.nextLine();
                    employeeManagement.assignTask(taskDepartment, task);
                } else if (choice == 4) {
                    System.out.println("List of All Employees:");
                    employeeManagement.listAllEmployees();
                } else if (choice == 5) {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (java.util.InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a valid option.");
                scanner.nextLine();
            } catch (DuplicateEmployeeException | InvalidTaskAssignmentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}

/*Problem Statement - 3
simple example of a school management system program in Java. This program
uses the Collection Framework to manage student and teacher records. It allows
users to add students and teachers, display their details, and exit the program.*/

package school;

import java.util.ArrayList;
import java.util.Scanner;

public class School {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSchool Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Display Students");
            System.out.println("4. Display Teachers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter student name: ");
                    String studentName = scanner.nextLine();

                    System.out.print("Enter student age: ");
                    int studentAge = scanner.nextInt();

                    System.out.print("Enter student roll number: ");
                    int rollNumber = scanner.nextInt();

                    students.add(new Student(studentName, studentAge, rollNumber));
                    System.out.println("\nStudent added successfully.");
                    break;

                case 2:
                    System.out.print("\nEnter teacher name: ");
                    String teacherName = scanner.nextLine();

                    System.out.print("Enter teacher age: ");
                    int teacherAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter teacher subject: ");
                    String teacherSubject = scanner.nextLine();

                    teachers.add(new Teacher(teacherName, teacherAge, teacherSubject));
                    System.out.println("\nTeacher added successfully.");
                    break;

                case 3:
                    System.out.println("\nStudents:");
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;

                case 4:
                    System.out.println("\nTeachers:");
                    for (Teacher teacher : teachers) {
                        System.out.println(teacher);
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

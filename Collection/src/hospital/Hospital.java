package hospital;

import java.util.HashMap;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        HashMap<Integer, Patient> patientMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. All Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();

                    patientMap.put(id, new Patient(id, name, age));
                    System.out.println("\nPatient added successfully.");
                    break;

                case 2:
                    System.out.println("\nView patient*");
                    System.out.print("\nEnter patient ID : ");
                    int Id = scanner.nextInt();
                    if (patientMap.containsKey(Id)) {
                        System.out.println("Patient Details: " + patientMap.get(Id));
                    }
                    else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3:
                    System.out.println("\nSearch patient");
                    System.out.print("Enter patient ID to search: ");
                    int searchId = scanner.nextInt();
                    if (patientMap.containsKey(searchId)) {
                        System.out.println("Patient found");
                    }
                    else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 4:
                    System.out.println("\nPatients:");
                    for (Patient patient : patientMap.values()) {
                        System.out.println(patient);
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

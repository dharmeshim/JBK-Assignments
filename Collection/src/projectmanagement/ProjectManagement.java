package projectmanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProjectManagement {
    public static void main(String[] args) {
        Map<Integer, Project> projects = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nProject Management System");
            System.out.println("1. Add Project");
            System.out.println("2. Assign Team Member");
            System.out.println("3. View Project Details");
            System.out.println("4. List Projects");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Add project*\n");
                    System.out.print("Enter project ID: ");
                    int projectId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter project name: ");
                    String projectName = scanner.nextLine();

                    projects.put(projectId, new Project(projectId, projectName));
                    System.out.println("\nProject added successfully.");
                    break;

                case 2:
                    System.out.println("Add Team Members*\n");
                    System.out.print("Enter project ID : ");
                    int assignProjectId = scanner.nextInt();
                    scanner.nextLine();

                    if (projects.containsKey(assignProjectId)) {
                        System.out.print("Enter team member name: ");
                        String teamMemberName = scanner.nextLine();

                        System.out.print("Enter team member ID: ");
                        int teamMemberId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter team member department: ");
                        String teamMemberDepartment = scanner.nextLine();

                        Members teamMember = new Members(teamMemberName, teamMemberId, teamMemberDepartment);
                        projects.get(assignProjectId).addTeamMember(teamMember);
                        System.out.println("\nTeam member assigned successfully.");
                    }
                    else {
                        System.out.println("Project not found.");
                    }
                    break;

                case 3:

                    System.out.println("View Project*\n");

                    System.out.print("Enter project ID to view details: ");
                    int viewProjectId = scanner.nextInt();

                    if (projects.containsKey(viewProjectId)) {
                        System.out.println("Project Details: " + projects.get(viewProjectId));
                    }
                    else {
                        System.out.println("Project not found.");
                    }
                    break;

                case 4:
                    System.out.println("Projects List:");
                    for (Project project : projects.values()) {
                        System.out.println(project);
                    }
                    break;

                case 5:
                    System.out.println("BYE!!.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

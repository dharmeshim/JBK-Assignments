package employeesystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main obj = new Main();
        ArrayList<Employee> list = obj.addEmployees();
        obj.viewEmployees(list);
        obj.findEmployee(list);

    }
    private ArrayList<Employee> addEmployees() {

        ArrayList<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee(1, "Arav", 10000, 25);
        Employee employee2 = new Employee(2, "Aravind", 15000, 24);
        Employee employee3 = new Employee(3, "Anand", 10070, 26);
        Employee employee4 = new Employee(4, "Abinav", 10400, 28);
        Employee employee5 = new Employee(5, "Abishek", 17000, 29);
        Employee employee6 = new Employee(6, "Andartic", 12000, 35);


        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);

        return employees;

    }

    private void viewEmployees(ArrayList<Employee> employees){
        for (Employee employee: employees) {
            System.out.println(employee);
        }

    }

    private void findEmployee(ArrayList<Employee> employees) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee ID");
        int employeeID = scanner.nextInt();
        boolean isFound = false;

        for (Employee employee: employees) {
            if(employee.getID()==employeeID){
                System.out.println(employee);
                isFound=true;
            }
        }
        if (!isFound){
            System.out.println("employee not found");
        }

    }



}
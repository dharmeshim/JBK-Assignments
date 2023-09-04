package exceptionHandling.hotelManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManagement {

    private Map<String, List<Employee>> employeesByDepartment;

    public EmployeeManagement() {
        employeesByDepartment = new HashMap<>();
    }

    public void hireEmployee(String department, Employee employee) throws DuplicateEmployeeException {
        List<Employee> departmentEmployees = employeesByDepartment.computeIfAbsent(department, k -> new ArrayList<>());
        if (departmentEmployees.contains(employee)) {
            throw new DuplicateEmployeeException("Employee with ID " + employee.getEmployeeID() + " already exists in the " + department + " category.");
        }
        departmentEmployees.add(employee);

        System.out.println("Hired " + employee.getEmployeeName() + " as a " + department + " employee.");
    }
    public void assignTask(String department, String task) throws InvalidTaskAssignmentException {
        List<Employee> employees = employeesByDepartment.get(department);
        if (employees != null && !employees.isEmpty()) {
            Employee employee = employees.get(0);
            System.out.println("Assigned task to " + employee.getEmployeeName() + ": " + task);
        } else {
            throw new InvalidTaskAssignmentException("No employees found in the " + department + " category.");
        }
    }


    public void fireEmployee(String department, String employeeID) {
        List<Employee> employees = employeesByDepartment.get(department);
        if (employees != null) {
            for (Employee employee : new ArrayList<>(employees)) {
                if (employee.getEmployeeID().equals(employeeID)) {
                    employees.remove(employee);
                    System.out.println("Fired " + employee.getEmployeeName() + " from the " + department + " category.");
                    return;
                }
            }
        }
        System.out.println("Employee with ID " + employeeID + " not found in the " + department + " category.");
    }

    public void listAllEmployees() {
        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment.entrySet()) {
            String department = entry.getKey();
            List<Employee> employees = entry.getValue();
            System.out.println("Department: " + department);
            for (Employee employee : employees) {
                System.out.println("Employee Name: " + employee.getEmployeeName());
                System.out.println("Employee ID: " + employee.getEmployeeID());
                System.out.println();
            }
        }
    }

}

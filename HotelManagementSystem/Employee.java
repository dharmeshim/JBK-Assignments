package exceptionHandling.hotelManagementSystem;

public class Employee {

    private String employeeID;
    private String employeeName;

    Employee(String employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
    }

    public void employeeDetail() {
        System.out.println("Employee Name : " + employeeName + "\nEmployee ID : " + employeeID);
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

}

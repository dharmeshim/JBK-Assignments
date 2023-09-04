package exceptionHandling.hotelManagementSystem;

public class Maintenance extends Employee {
    Maintenance(String employeeID, String employeeName) {
        super(employeeID, employeeName);
    }

    @Override
    public void employeeDetail() {
        super.employeeDetail();
        System.out.println("Working in Maintenance section");
    }

    public void maintenance() {
        System.out.println(getEmployeeName() + "Now maintening this..");
    }
}

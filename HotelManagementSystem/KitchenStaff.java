package exceptionHandling.hotelManagementSystem;

public class KitchenStaff extends Employee {

    KitchenStaff(String employeeID, String employeeName) {
        super(employeeID, employeeName);
    }

    @Override
    public void employeeDetail() {
        super.employeeDetail();
        System.out.println("Working in Kitchen Staff section");
    }

    public void cooking() {
        System.out.println(getEmployeeName() + " is cooking");
    }
}

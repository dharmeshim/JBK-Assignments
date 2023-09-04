package exceptionHandling.hotelManagementSystem;

public class Desk extends Employee {

    Desk(String employeeID, String employeeName) {
        super(employeeID, employeeName);
    }
    @Override
    public void employeeDetail() {
        super.employeeDetail();
        System.out.println("Working in Front Desk section");
    }

    public void checkInGuest() {
        System.out.println("Front Desk " + getEmployeeName() + " is checking the Guest");
    }

}

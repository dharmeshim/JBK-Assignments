package exceptionHandling.hotelManagementSystem;

public class HouseKeeping extends Employee {

    HouseKeeping(String employeeID, String employeeName) {
        super(employeeID, employeeName);
    }

    @Override
    public void employeeDetail() {
        super.employeeDetail();
        System.out.println("Working in House Keeping section");
    }

    public void cleanRoom() {
        System.out.println("HouseKeeping " + getEmployeeName() + " is cleaning");
    }
}

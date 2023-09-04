package exceptionHandling.hotelManagementSystem;

public class DuplicateEmployeeException extends Exception {
    public DuplicateEmployeeException(String message) {
        super(message);
    }
}


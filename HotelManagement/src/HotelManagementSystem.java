import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("Hotel Management System");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Check Room Availability");
            System.out.println("3. Display Reservation Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Making a reservation
                    try {
                        System.out.print("Enter guest name: ");
                        String guestName = scanner.nextLine();

                        System.out.print("Enter guest gender: ");
                        String guestGender = scanner.nextLine();
                        System.out.print("Enter guest age: ");
                        int guestAge = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter reservation start date (yyyy-MM-dd): ");
                        String startDateStr = scanner.nextLine();
                        Date startDate = dateFormat.parse(startDateStr);

                        System.out.print("Enter reservation end date (yyyy-MM-dd): ");
                        String endDateStr = scanner.nextLine();
                        Date endDate = dateFormat.parse(endDateStr);

                        System.out.print("Enter room number: ");
                        int roomNumber = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            hotel.makeReservation(new Guest(guestName, guestGender, guestAge), startDate, endDate, roomNumber);
                            System.out.println("Reservation successful.");
                        } catch (InvalidReservationException | RoomNotFoundException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                    } catch (ParseException e) {
                        System.err.println("Error: Invalid date format.");
                    }
                    break;

                case 2:
                    // Checking room availability
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    boolean isAvailable = hotel.isRoomAvailable(roomNumber);
                    if (isAvailable) {
                        System.out.println("Room is available.");
                    } else {
                        System.out.println("Room is not available.");
                    }
                    break;

                case 3:
                    // Display Reservation Details
                    System.out.print("Enter room number: ");
                    int roomNum = scanner.nextInt();
                    scanner.nextLine();

                    hotel.displayReservationDetails(roomNum);
                    break;

                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

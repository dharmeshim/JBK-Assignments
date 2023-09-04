import java.util.*;

public class Hotel {
    private Map<Integer, Room> roomMap;
    private List<Reservation> reservations;
    private int nextReservationId = 1;

    public Hotel() {
        roomMap = new HashMap<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 1; i <= 100; i++) {
            RoomType roomType = (i <= 50) ? RoomType.STANDARD : (i <= 80) ? RoomType.DELUXE : RoomType.SUITE;
            roomMap.put(i, new Room(i, roomType, false));
        }
    }

    public void makeReservation(Guest guest, Date startDate, Date endDate, int roomNumber)
            throws InvalidReservationException, RoomNotFoundException {
        Room room = roomMap.get(roomNumber);

        if (room == null || room.isReserved()) {
            throw new RoomNotFoundException("Room not found or already reserved.");
        }

        Reservation reservation = new RoomReservation(generateReservationId(), guest, startDate, endDate, roomNumber);
        reservations.add(reservation);
        room.setReserved(true);
    }

    public boolean isRoomAvailable(int roomNumber) {
        Room room = roomMap.get(roomNumber);
        return room != null && !room.isReserved();
    }

    public void displayReservationDetails(int roomNumber) {
        for (Reservation reservation : reservations) {
            if (reservation instanceof RoomReservation) {
                RoomReservation roomReservation = (RoomReservation) reservation;
                if (roomReservation.getRoomNo() == roomNumber) {
                    System.out.println("Room " + roomNumber + " is booked by guest " + reservation.getGuest().getName());
                    System.out.println("Reservation Dates: " + reservation.getStartDate() + " to " + reservation.getEndDate());
                    return;
                }
            }
        }
        System.out.println("Room " + roomNumber + " is not booked.");
    }

    private int generateReservationId() {
        return nextReservationId++;
    }
}

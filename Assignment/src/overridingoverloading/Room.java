package overridingoverloading;

import java.util.Date;

public class Room {

	private int roomNumber;
	private int capacity;
	private double pricePerNight;

	public Room(int roomNumber, int capacity, double pricePerNight) {
		this.capacity = capacity;
		this.roomNumber = roomNumber;
		this.pricePerNight = pricePerNight;
	}

	public void checkAvailability() {
		if (capacity > 0) {
			System.out.println(capacity + " rooms available");
		} else {
			System.out.println("Room are already reserved");
		}
	}

	public void reservation() {
		if (capacity > 0) {
			capacity--;
			roomNumber++;
			System.out.println(roomNumber + " reserved successful");
		} else {
			System.out.println("rooms are already reserved");
		}
	}

	public void reservation(Date checkIn, Date checkOut) {
		if (capacity>0) {
			capacity--;
			roomNumber++;
			System.out.println(roomNumber + " reserved successful for " + checkIn + " to " + checkOut);
		} else {
			System.out.println("room is already reserved");
		}
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + "  is recently reserved at cost of "+pricePerNight+". :: "+capacity+" rooms are available " ;
	}

}

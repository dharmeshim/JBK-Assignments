package overridingoverloading;

import java.util.Date;

public class HotelReservation {
	public static void main(String[] args) {
		Room room1 = new Room(100,5, 100);
		room1.checkAvailability();
		
		room1.reservation();
		room1.reservation();
		room1.reservation(new Date(), new Date() );

		System.out.println(room1.toString());

	}
}
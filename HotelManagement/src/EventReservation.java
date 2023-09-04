import java.util.Date;

public class EventReservation extends Reservation {
    private int eventNumber;
    private String eventName;

    public EventReservation(int reservationId, Guest guest, Date stratDate, Date endDate, String eventName, int eventNumber) {
        super(reservationId, guest, stratDate, endDate);
        this.eventName = eventName;
        this.eventNumber = eventNumber;
    }


}

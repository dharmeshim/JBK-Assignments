import java.util.Date;
public class SpaReservation extends Reservation {
    private String spaType;
    public SpaReservation(int reservationId, Guest guest, Date stratDate, Date endDate, String spaType) {
        super(reservationId, guest, stratDate, endDate);
        this.spaType = spaType;
    }
}

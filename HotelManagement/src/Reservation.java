import java.util.Date;

public class Reservation {

    private int reservationId;
    private Guest guest;
    private Date startDate;
    private Date endDate;

    public Reservation(int reservationId, Guest guest, Date stratDate, Date endDate) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.startDate = stratDate;
        this.endDate = endDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStratDate(Date stratDate) {
        this.startDate = stratDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}

import java.util.Date;

public class RoomReservation extends Reservation{

    private int roomNo;
    private RoomType roomType;

    public RoomReservation(int reservationId, Guest guest, Date stratDate, Date endDate, int roomNo) {
        super(reservationId, guest, stratDate, endDate);
        this.roomNo = roomNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
enum RoomType{
    STANDARD, DELUXE, SUITE
}

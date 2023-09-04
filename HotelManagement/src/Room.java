public class Room {
    private int roomNumber;
    private RoomType roomType;
    private boolean isReserved;

    public Room(int roomNumber, RoomType roomType, boolean isReserved) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isReserved = isReserved;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

}

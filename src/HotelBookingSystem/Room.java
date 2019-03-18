package HotelBookingSystem;

public class Room {

    private int roomId;
    private static int count = 0;
    private String type;

//Single, double , family, business


    Room(String type) {
        this.roomId = count;
        this.type = type;
        count++;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room: id = " + roomId + " type = " + type;
    }
}

package assignment;

public class Hotel {

    private String hotelName;
    private Room[] rooms;

    public Hotel(String hotelName, String[] roomTypes) {
        this.hotelName = hotelName;
        rooms = new Room[roomTypes.length];
        for (int i = 0; i < roomTypes.length; i++) {
            rooms[i] = new Room(i, roomTypes[i]);
        }
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getTotalRooms() {
        return rooms.length;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(hotelName);
        for (Room room : rooms) {
            string.append(" ").append(room.toString());
        }
        return string.toString();
    }
}

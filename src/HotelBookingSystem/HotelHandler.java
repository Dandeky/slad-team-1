package HotelBookingSystem;

public class HotelHandler {

    private boolean imported = false;
    private String hotelName;
    private String[] rooms;

    HotelHandler(String hotelName) {
        this.hotelName = hotelName;
    }

    public void importFiles() {

    }

    public void saveFiles() {

    }

    public String[] getRooms() {
        return rooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public boolean isImported() {
        return imported;
    }
}

package assignment;

public class HotelHandler {

    private boolean imported = false;
    private String hotel;

    HotelHandler(String hotel) {
        this.hotel = hotel;
        imported = true;
    }

    public String getHotel() {
        return hotel;
    }

    public boolean isImported() {
        return imported;
    }
}

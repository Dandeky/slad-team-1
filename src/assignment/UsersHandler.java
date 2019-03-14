package assignment;

public class UsersHandler {

    private boolean imported = false;
    private String hotel;

    UsersHandler(String hotel) {
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
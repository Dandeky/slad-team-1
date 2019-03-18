package HotelBookingSystem;

public class Staff extends User {

    private boolean adminPer;

    Staff(String firstName, String lastName, int tel, String username, String password, boolean adminPer) {
        super(firstName, lastName, tel, username, password);
        this.adminPer = adminPer;
    }

    public boolean getAdminPer() {
        return adminPer;
    }

    public void setAdminPer(boolean adminPer) {
        this.adminPer = adminPer;
    }
}

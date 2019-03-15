package assignment;

public class Staff extends User {

    private boolean adminPer;

    Staff(int id, String firstName, String lastName, int tel, String username, String password, boolean adminPer) {
        super(id, firstName, lastName, tel, username, password);
        this.adminPer = adminPer;
    }

    public boolean getAdminPer() {
        return adminPer;
    }

    public void setAdminPer(boolean adminPer) {
        this.adminPer = adminPer;
    }
}


package HotelBookingSystem;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private int tel;
    private String username;
    private String password;
    private static int count = 0;

    User(String firstName, String lastName, int tel, String username, String password) {
        this.id = count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.username = username;
        this.password = password;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTel() {
        return tel;
    }

    public String getUsername() {
        return username;
    }

    public int getIdByUsername() {
        // TODO: Make function
        return -1;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

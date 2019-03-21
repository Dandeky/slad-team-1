package HotelBookingSystem;

import java.util.Arrays;
import java.util.Date;

public class Booking {

    private int bookingId;
    private static int count = 0;
    private int userId;
    private int[] rooms; // [0] = Single [1] = Double [2] = Fam [3] = Business
    private Date startDate;
    private Date endDate;
    private boolean[] extras; // [0] = Gym [1] = Breakfast [2] = Wifi
    private double price;

    Booking(int userId, int[] roomIds, Date startDate, Date endDate, boolean[] extras) {
        this.bookingId = count;
        this.userId = userId;
        this.rooms = roomIds;
        this.startDate = startDate;
        this.endDate = endDate;
        this.extras = extras;
        count++;
    }

    /*
    Types: Single, Double, Fam, Bisuness
    Prices: ...
     */
    // TODO: Write the price logic for calcPrice()
    public double calcPrice() {
        price = 10.01;
        return price;
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getPrice() {
        return price;
    }

    public int[] getRooms() {
        return rooms;
    }

    public int getUserId() {
        return userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isGym() {
        return extras[0];
    }

    public boolean isBreakfast() {
        return extras[1];
    }

    public boolean isWifi() {
        return extras[2];
    }

    public boolean isInDate() {
        Date currentDate = new Date();
        return ((startDate.before(currentDate) && endDate.after(currentDate))
                || currentDate.equals(startDate) || currentDate.equals(endDate));
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRoomIds(int[] roomIds) {
        this.rooms = roomIds;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setExtras(boolean[] extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Booking: id = " + bookingId + " userId = " + userId + " rooms = " + Arrays.toString(rooms)
                + " startDate = " + startDate + " endDate = " + endDate + " extras = " + Arrays.toString(extras);
    }
}

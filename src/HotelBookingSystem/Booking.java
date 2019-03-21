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
    double singlePrice = 67.70;
    double doublePrice = 123.40;
    double famPrice = 156.30;
    double busiPrice = 180.50;
    double gymPrice = 35.50;
    double breakPrice = 25.30;
    double wifiPrice = 14.50;

    Booking(int userId, int[] roomIds, Date startDate, Date endDate, boolean[] extras) {
        this.bookingId = count;
        this.userId = userId;
        this.rooms = roomIds;
        this.startDate = startDate;
        this.endDate = endDate;
        this.extras = extras;
        count++;
    }

    public double calcPrice() {
        double price = 0;
        price += rooms[0] * singlePrice;
        price += rooms[1] * doublePrice;
        price += rooms[2] * famPrice;
        price += rooms[3] * busiPrice;
        if (extras[0]){
            price += gymPrice;
        }
        if (extras[1]) {
            price += breakPrice;
        }
        if (extras[2]) {
            price += wifiPrice;
        }
        return price;
    }

    public int getBookingId() {
        return bookingId;
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

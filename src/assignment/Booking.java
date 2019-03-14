package assignment;

import java.util.Date;

public class Booking {

    private int userId;
    private int roomId;
    private Date startDate;
    private Date endDate;
    private double price;

    Booking(int userId, int roomId, Date startDate, Date endDate) {
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /*
    Types: Single, Double, Fam, Bisuness
    Prices: ...
     */
    public double calcPrice() {
        price = 10.01;
        return price;
    }

    public double getPrice() {
        return price;
    }

    public int getRoomId() {
        return roomId;
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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

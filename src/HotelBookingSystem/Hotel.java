package HotelBookingSystem;

import java.awt.print.Book;
import java.util.Date;

public class Hotel {

    private String hotelName;
    private Room[] rooms;
    private Booking[] bookings;

    public Hotel(String hotelName, String[] roomTypes) {
        this.hotelName = hotelName;
        rooms = new Room[roomTypes.length];
        for (int i = 0; i < roomTypes.length; i++) {
            rooms[i] = new Room(roomTypes[i]);
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

    public Booking[] getBookings() {
        return bookings;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    // TODO: Add function getAvailableRooms() returns int[]
    // TODO: Add function makeBooking(int userId, int[] roomId, Date startDate, Date endDate, boolean[] extras) returns void

    public void makeBooking(int userId, int[] roomIds, Date startDate, Date endDate, boolean[] extras) {
        if (bookings != null) {
            Booking[] tmp = bookings;
            bookings = new Booking[bookings.length + 1];
            System.arraycopy(tmp, 0, bookings, 0, tmp.length);
            bookings[tmp.length] = new Booking(userId, roomIds, startDate, endDate, extras);
        } else {
            bookings = new Booking[1];
            bookings[0] = new Booking(userId, roomIds, startDate, endDate, extras);
        }
    }

    public void deleteBooking(int bookingId) {
        if (hasBooking(bookingId)) {
            Booking[] tmp = new Booking[bookings.length - 1];
            for (int i = 0, k = 0; i < bookings.length; i++) {
                if (bookings[i].getBookingId() != bookingId) {
                    tmp[k++] = bookings[i];
                }
            }
            bookings = tmp;
        }
    }

    private boolean hasBooking(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(hotelName);
        string.append("\n Rooms:: \n");
        for (Room room : rooms) {
            string.append(" ").append(room.toString());
            string.append("\n");
        }
        string.append("\n Bookings:: \n");
        for (Booking booking : bookings) {
            string.append(" ").append(booking.toString());
            string.append("\n");
        }
        return string.toString();
    }
}

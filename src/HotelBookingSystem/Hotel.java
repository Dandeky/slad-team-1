package HotelBookingSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Hotel {

    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public Hotel(String hotelName, String[] roomTypes) {
        this.hotelName = hotelName;
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        for (String roomType : roomTypes) {
            rooms.add(new Room(roomType));
        }
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getTotalRooms() {
        return rooms.size();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int[] getCurrentRoomsBooked() {
        int[] currRoomsArr = new int[4];
        ArrayList<Booking> currBookings = new ArrayList<Booking>();
        for (Booking booking : bookings) {
            if (booking.isInDate()) {
                currBookings.add(booking);
            }
        }
        for (Booking booking : currBookings) {
            for (int i = 0; i < booking.getRooms().length; i++) {
                currRoomsArr[i] = currRoomsArr[i] + booking.getRooms()[i];
            }
        }
        return currRoomsArr;
    }

    public int[] getCurrentAvailRooms() {
        int[] roomTypes = getAllRooms();
        int[] currRoomsBooked = getCurrentRoomsBooked();
        for (int i = 0; i < roomTypes.length; i++) {
            roomTypes[i] = roomTypes[i] - currRoomsBooked[i];
        }
        return roomTypes;
    }

    public int[] getAllRooms() {
        int[] roomTypes = new int[4];
        for (Room room : rooms) {
            switch (room.getType()) {
                case "Single":
                    roomTypes[0]++;
                    break;
                case "single":
                    roomTypes[0]++;
                    break;
                case "Double":
                    roomTypes[1]++;
                    break;
                case "double":
                    roomTypes[1]++;
                    break;
                case "Family":
                    roomTypes[2]++;
                    break;
                case "family":
                    roomTypes[2]++;
                    break;
                case "Business":
                    roomTypes[3]++;
                    break;
                case "business":
                    roomTypes[3]++;
                    break;
            }
        }
        return roomTypes;
    }

    private Room getRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public Booking getBookingById(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void makeBooking(int userId, int[] roomIds, Date startDate, Date endDate, boolean[] extras) {
        bookings.add(new Booking(userId, roomIds, startDate, endDate, extras));
    }

    public void deleteBookingById(int bookingId) {
        if (hasBooking(bookingId)) {
            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).getBookingId() == bookingId) {
                    bookings.remove(i);
                    deleteBookingById(bookingId);
                    break;
                }
            }
        }
    }

    public void deleteAllBookings() {
        bookings.clear();
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

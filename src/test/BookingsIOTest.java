package test;

import HotelBookingSystem.Booking;
import HotelBookingSystem.HotelHandler;

import java.util.Date;

public class BookingsIOTest {
    public static void main(String[] args) {

        int[] rooms = new int[]{5,10,15,20};
        boolean[] extras = new boolean[]{true, false, true};
        java.util.Date currentDate = new Date();

        Booking booking = new Booking(3, rooms, currentDate, currentDate, extras);
        HotelHandler.saveBooking(booking);

    }
}
package test;

import HotelBookingSystem.Hotel;
import HotelBookingSystem.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelTest {

    public static void main(String[] args) throws ParseException {

        String[] types = new String[100];

        for (int i = 0; i < types.length; i++) {
            if (i % 4 == 0) {
                types[i] = "single";
            } else if (i % 4 == 1) {
                types[i] = "double";
            } else if (i % 4 == 2) {
                types[i] = "family";
            } else {
                types[i] = "business";
            }
        }

        Hotel testHotel = new Hotel("Test Hotel", types);
//
//        for (int i = 0; i < testHotel.getTotalRooms(); i++) {
//            System.out.println(testHotel.getRooms()[i]);
//        }
//
//        testHotel.deleteBooking(3);
//
//        System.out.println("\n" + "----------------------------" + "\n");
//
//        for (int i = 0; i < testHotel.getTotalRooms(); i++) {
//            System.out.println(testHotel.getRooms()[i]);
//        }

        int[] rooms = new int[4];
        rooms[0] = 1;
        rooms[1] = 2;
        rooms[2] = 3;
        rooms[3] = 4;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateStart = dateFormat.parse("1/1/2000");
        Date dateEnd1 = dateFormat.parse("1/1/2001");
        Date dateEnd2 = dateFormat.parse("1/1/2020");

        boolean[] booleans = new boolean[3];
        booleans[0] = true;
        booleans[2] = true;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                testHotel.makeBooking(1, rooms, dateStart, dateEnd1, booleans);
            } else {
                testHotel.makeBooking(1, rooms, dateStart, dateEnd2, booleans);
            }

        }

//
//        testHotel.deleteBookingById(3);
//        testHotel.deleteBooking(4);
//        testHotel.deleteBooking(8);

//        System.out.println(testHotel.toString());

        for (int room : testHotel.getAllRooms()) {
            System.out.println(room);
        }
        System.out.println("----------");
        for (int roomId : testHotel.getCurrentRoomsBooked()) {
            System.out.println(roomId);
        }
        System.out.println("----------");
        for (int typeCount : testHotel.getCurrentAvailRooms()) {
            System.out.println(typeCount);
        }


//        System.out.println("Booking id 0 is in date? -> " + testHotel.getBookings().get(0).isInDate());


    }
}
package test;

import HotelBookingSystem.Hotel;

import java.util.Date;

public class HotelTest {

    public static void main(String[] args) {

        String[] types = new String[10];

        for (int i = 0; i < types.length; i++) {
            if (i % 2 == 0) {
                types[i] = "single";
            } else {
                types[i] = "double";
            }
        }
//
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
        Date dateStart = new Date(2000, 10, 11);
        Date dateEnd = new Date(2000, 11, 10);
        boolean[] booleans = new boolean[3];
        booleans[0] = true;
        booleans[2] = true;
        for (int i = 0; i < 10; i++) {
            testHotel.makeBooking(1, rooms, dateStart, dateEnd, booleans);
        }


        System.out.println(testHotel.toString() + "\n\nRemove booking id 3 -> \n\n");

        testHotel.deleteBooking(3);
        testHotel.deleteBooking(4);
        testHotel.deleteBooking(8);

        System.out.println(testHotel.toString());

        testHotel.getBookings()[]

    }
}
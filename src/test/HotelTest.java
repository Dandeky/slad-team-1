package test;

import assignment.Hotel;

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
        Hotel testHotel = new Hotel("Test Hotel", types);
        for (int i = 0; i < testHotel.getTotalRooms(); i++) {
            System.out.println(testHotel.getRooms()[i]);
        }


    }

}

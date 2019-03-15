package test;

import HotelBookingSystem.Restaurant;

public class RestaurantTest {

    public static void main(String[] args) {
        int[] tableNumbers = new int[10];
        for (int i = 0; i < tableNumbers.length; i++) {
            if (i % 2 == 0) {
                tableNumbers[i] = 2;
            } else {
                tableNumbers[i] = 5;
            }
        }

        Restaurant testResaurant = new Restaurant("Test Restaurant", tableNumbers);

        for (int i = 0; i < testResaurant.getTotalTables(); i++) {
            System.out.println(testResaurant.getTables()[i].toString());
        }

        System.out.println("\n\n\n" + testResaurant.toString());

    }

}

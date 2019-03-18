package test;

import HotelBookingSystem.UsersHandler;

import java.security.NoSuchAlgorithmException;

public class UsersIOTest {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            UsersHandler.saveUserToFile("Dadanm0n", "password");
        }
//
//        UsersHandler.deleteAllUsers();

    }
}
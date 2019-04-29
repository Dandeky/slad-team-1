package test;

import HotelBookingSystem.User;
import HotelBookingSystem.UsersHandler;

public class UsersIOTest {
    public static void main(String[] args) {

//        for (int i = 0; i < 10; i++) {
//            UsersHandler.saveUserToFile("Dadanm0n" + i, "password", "0");
//            UsersHandler.saveUserToFile("Dandeky" + i, "password2", "1");
//        }

//        UsersHandler.deleteUser("Dandeky0");

//        UsersHandler.deleteAllUsers();

//        System.out.println(UsersHandler.verifyLogin("Dandeky", "password2"));

        int[] result = UsersHandler.verifyLogin("Dadanm0n1", "password");
        for (int r : result) {
            System.out.print(r);
        }

//        UsersHandler.deleteUser("Dadanm0n");

    }
}
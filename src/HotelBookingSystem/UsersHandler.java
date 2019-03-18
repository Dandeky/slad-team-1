package HotelBookingSystem;

import javax.sound.midi.SysexMessage;
import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UsersHandler {

    private static final String fileName = "Users.txt";
    private static String[][] contents;

    public static void saveUserToFile(String username, String password) {

        String line;
        int linesCount = -1;
        String[] lineParts;
        int iterator = 0;

        try {
            linesCount = (int) Files.lines(Paths.get(fileName)).count();
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            contents = new String[linesCount + 1][2];

            while ((line = bufferedReader.readLine()) != null) {
                lineParts = line.split(" ");
                contents[iterator][0] = lineParts[0];
                contents[iterator][1] = lineParts[1];
                iterator++;
            }
            contents[linesCount][0] = username;
            contents[linesCount][1] = password;
        } catch (IOException e) {
            System.out.println("IO Exception occurred when reading users file");
        }


        if (linesCount != -1) {
            try {
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < (linesCount + 1); i++) {
                    bufferedWriter.write(contents[i][0]);
                    bufferedWriter.write(" ");
                    bufferedWriter.write(contents[i][1]);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("IO Exception occurred when writing to users file.");
            }
        }
    }

    public static void deleteUser(String username) {

        String line;
        int linesCount = -1;
        String[] lineParts;
        int iterator = 0;

        try {
            linesCount = (int) Files.lines(Paths.get(fileName)).count();
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            contents = new String[linesCount + 1][2];
System.out.println(linesCount);
            while ((line = bufferedReader.readLine()) != null) {
                lineParts = line.split(" ");
                if (!lineParts[0].equals(username)) {
                    contents[iterator][0] = lineParts[0];
                    contents[iterator][1] = lineParts[1];
                }
                iterator++;
            }
        } catch (IOException e) {
            System.out.println("IO Exception occurred when reading users file");
        }

//        if (linesCount != -1) {
//            try {
//                FileWriter fileWriter = new FileWriter(fileName);
//                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//                for (int i = 0; i < (linesCount + 1); i++) {
//                    bufferedWriter.write(contents[i][0]);
//                    bufferedWriter.write(" ");
//                    bufferedWriter.write(contents[i][1]);
//                    bufferedWriter.newLine();
//                }
//                bufferedWriter.close();
//            } catch (IOException e) {
//                System.out.println("IO Exception occurred when writing to users file.");
//            }
//        }
    }

    public static void deleteAllUsers() {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("IO Exception occurred when writing to users file.");
        }
    }


    public static boolean verifyLogin(String username, String password) {

        String line;
        String[] lineParts;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                lineParts = line.split(" ");
                if (lineParts[0].equals(username) && lineParts[1].equals(password)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            System.out.println("IO Exception occurred when reading users file");
        }
        return false;
    }
}
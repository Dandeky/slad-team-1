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


//    static boolean verifyLogin(String username, String password) {
    //TODO: import users file
    // Check username
    // Hash password and check
    // If both true, return true, else false
//    }

}

//public class Test {
//    public static void main(String [] args) {
//
//        // The name of the file to open.
//        String fileName = "temp.txt";
//
//        // This will reference one line at a time
//        String line = null;
//
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader =
//                    new FileReader(fileName);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader =
//                    new BufferedReader(fileReader);
//
//            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            // Always close files.
//            bufferedReader.close();
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println(
//                    "Unable to open file '" +
//                            fileName + "'");
//        }
//        catch(IOException ex) {
//            System.out.println(
//                    "Error reading file '"
//                            + fileName + "'");
//            // Or we could just do this:
//            // ex.printStackTrace();
//        }
//    }
//}
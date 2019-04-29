package HotelBookingSystem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelHandler {

    private static final String hotelFileName = "Hotel.txt";
    private static final String bookingsFileName = "Bookings.txt";
    private static String[][] contents;

    public static Hotel getHotel() throws IOException, ParseException {

        String lineHotel;
        String[] linePartsHotel;
        String name;
        int[] rooms = new int[4];

        FileReader fileReaderHotel = new FileReader(hotelFileName);
        BufferedReader bufferedReaderHotel = new BufferedReader(fileReaderHotel);

        lineHotel = bufferedReaderHotel.readLine();
        linePartsHotel = lineHotel.split("\t");

        name = linePartsHotel[0];
        rooms[0] = Integer.parseInt(linePartsHotel[1]);
        rooms[1] = Integer.parseInt(linePartsHotel[2]);
        rooms[2] = Integer.parseInt(linePartsHotel[3]);
        rooms[3] = Integer.parseInt(linePartsHotel[4]);

        fileReaderHotel.close();
        bufferedReaderHotel.close();

        Hotel hotel = new Hotel(name, rooms);

        String lineBookings;
        int linesCount = -1;
        String[] linePartsBookings;
        int iterator = 0;

        try {
            linesCount = (int) Files.lines(Paths.get(bookingsFileName)).count();
            FileReader fileReader = new FileReader(bookingsFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            contents = new String[linesCount][5];

            while ((lineBookings = bufferedReader.readLine()) != null) {
                linePartsBookings = lineBookings.split("\t");
                contents[iterator][0] = linePartsBookings[0];
                contents[iterator][1] = linePartsBookings[1];
                contents[iterator][2] = linePartsBookings[2];
                contents[iterator][3] = linePartsBookings[3];
                contents[iterator][4] = linePartsBookings[4];
                iterator++;
            }

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("IO Exception occurred when reading users file");
        }


        for (int i = 0; i < contents.length; i++) {

            String[] contentParts;
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");

            int userId = Integer.parseInt(contents[i][0]);
            int[] roomsBookings = new int[4];
            contentParts = contents[i][1].split(" ");
            for (int j = 0; j < contentParts.length; j++) {
                roomsBookings[j] = Integer.parseInt(contentParts[j]);
            }
            Date startDate = formatter.parse(contents[i][2]);
            Date endDate = formatter.parse(contents[i][3]);

            boolean[] extras = new boolean[3];
            contentParts = contents[i][4].split(" ");
            for (int j = 0; j < contentParts.length; j++) {
                extras[j] = Integer.parseInt(contentParts[j]) == 1;
            }

            hotel.makeBooking(userId, roomsBookings, startDate, endDate, extras);
        }

        return hotel;

    }

    public static void saveHotel(Hotel hotel) throws IOException {
        String name = hotel.getHotelName();

        FileWriter fileWriter = new FileWriter(hotelFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(name);
        for (int roomType : hotel.getAllRooms()) {
            bufferedWriter.write("\t");
            bufferedWriter.write(Integer.toString(roomType));
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public static void saveBooking(Booking booking) {
        String line;
        int linesCount = -1;
        String[] lineParts;
        int iterator = 0;
        String rooms;
        String extras;

        rooms = booking.getRooms()[0] + " " + booking.getRooms()[1] + " " +
                booking.getRooms()[2] + " " + booking.getRooms()[3];
        if (booking.getExtras()[0]) {
            extras = "1 ";
        } else {
            extras = "0 ";
        }
        if (booking.getExtras()[1]) {
            extras += "1 ";
        } else {
            extras += "0 ";
        }
        if (booking.getExtras()[2]) {
            extras += "1";
        } else {
            extras += "0";
        }

        try {
            linesCount = (int) Files.lines(Paths.get(bookingsFileName)).count();
            FileReader fileReader = new FileReader(bookingsFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            contents = new String[linesCount + 1][5];

            while ((line = bufferedReader.readLine()) != null) {
                lineParts = line.split("\t");
                contents[iterator][0] = lineParts[0];
                contents[iterator][1] = lineParts[1];
                contents[iterator][2] = lineParts[2];
                contents[iterator][3] = lineParts[3];
                contents[iterator][4] = lineParts[4];
                iterator++;
            }

            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
            String startDate = formatter.format(booking.getStartDate());
            String endDate = formatter.format(booking.getEndDate());
            contents[linesCount][0] = Integer.toString(booking.getUserId());
            contents[linesCount][1] = rooms;
            contents[linesCount][2] = startDate;
            contents[linesCount][3] = endDate;
            contents[linesCount][4] = extras;

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("IO Exception occurred when reading users file");
        }


        if (linesCount != -1) {
            try {
                FileWriter fileWriter = new FileWriter(bookingsFileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < (linesCount + 1); i++) {
                    bufferedWriter.write(contents[i][0]);
                    bufferedWriter.write("\t");
                    bufferedWriter.write(contents[i][1]);
                    bufferedWriter.write("\t");
                    bufferedWriter.write(contents[i][2]);
                    bufferedWriter.write("\t");
                    bufferedWriter.write(contents[i][3]);
                    bufferedWriter.write("\t");
                    bufferedWriter.write(contents[i][4]);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("IO Exception occurred when writing to users file.");
            }
        }
    }

}

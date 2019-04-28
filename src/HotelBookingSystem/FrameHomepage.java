
package HotelBookingSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrameHomepage extends JFrame {

    private final int SCREEN_INITIAL_WIDTH = 1280;
    private final int SCREEN_INITIAL_HEIGHT = 720;

    private final JPanel controlPanel, bookingPanel, adminPanel, logoutPanel;
    private final JButton button1, button2, button3, button4, button5;
    private final JTextArea bookedRoomList, availRoomList;

    private Hotel hotel;
    private User user;

    private int[] bookedRoom;
    private int[] availRoom;

    public FrameHomepage(Hotel hotel, User user) {
        setTitle("FrameHomepage");
        setLayout(new BorderLayout());

        bookedRoom = hotel.getCurrentRoomsBooked();
        availRoom = hotel.getCurrentAvailRooms();

        // Button Panel
        controlPanel = new JPanel();
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "FrameHomepage"));
        controlPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        //JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
        //controlPanelScrollPane.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        add(controlPanel, BorderLayout.LINE_START);

        bookingPanel = new JPanel();
        bookingPanel.setBorder(new TitledBorder(new EtchedBorder(), "Bookings"));
        bookingPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 10, 350));
        controlPanel.add(bookingPanel, BorderLayout.LINE_START);

        // Buttons
        button1 = new JButton("Create Booking");
        button1.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        button1.addActionListener(new MakeBookingListener());
        bookingPanel.add(button1);

        button2 = new JButton("Check Bookings");
        button2.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        bookingPanel.add(button2);

        bookedRoomList = new JTextArea();
        bookedRoomList.setEditable(false);
        JScrollPane textAreaScrollPane = new JScrollPane(bookedRoomList);
        textAreaScrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Booked Rooms"));
        textAreaScrollPane.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 700, 200));
        bookingPanel.add(textAreaScrollPane);

        availRoomList = new JTextArea();
        availRoomList.setEditable(false);
        JScrollPane availableScroll = new JScrollPane(availRoomList);
        availableScroll.setBorder(new TitledBorder(new EtchedBorder(), "Available Rooms"));
        availableScroll.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 700, 200));
        bookingPanel.add(availableScroll);

        displayRoomData();

        adminPanel = new JPanel();
        adminPanel.setBorder(new TitledBorder(new EtchedBorder(), "Admin"));
        adminPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 10, 150));
        controlPanel.add(adminPanel, BorderLayout.LINE_START);


        //user must be object
        if ((user instanceof Staff)) {
            if (((Staff) user).getAdminPer()) {
                // Enter code for GUI generation that only the admin should be able t see
            }
        }

        button3 = new JButton("Admin");
        button3.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        adminPanel.add(button3);

        button4 = new JButton("Admin but more");
        button4.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        adminPanel.add(button4);

        logoutPanel = new JPanel();
        logoutPanel.setBorder(new TitledBorder(new EtchedBorder(), "Logout"));
        logoutPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 10, 150));
        controlPanel.add(logoutPanel, BorderLayout.LINE_START);

        button5 = new JButton("Logout");
        button5.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        button5.addActionListener(new ExitListener());
        logoutPanel.add(button5);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void displayRoomData() {
        for (int value : bookedRoom) {
            bookedRoomList.append(value + "\n");
        }
        for (int value : availRoom) {
            availRoomList.append(value + "\n");
        }
    }


    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            setVisible(false);
            dispose();
        }
    }

    class MakeBookingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            FrameCreateBooking booking = new FrameCreateBooking(hotel, user.getId());
        }
    }


}
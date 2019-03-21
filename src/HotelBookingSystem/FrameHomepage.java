
package HotelBookingSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrameHomepage extends JFrame {

    private final int SCREEN_INITIAL_WIDTH = 1280;
    private final int SCREEN_INITIAL_HEIGHT = 720;

    private final JPanel controlPanel, bookingPanel, adminPanel, logoutPanel;
    private final JButton button1, button2, button3, button4, button5, button6;

    public FrameHomepage(Hotel hotel, int user) {
        setTitle("FrameHomepage");
        setLayout(new BorderLayout());

        // Button Panel
        controlPanel = new JPanel();
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "FrameHomepage"));
        controlPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        //JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
        //controlPanelScrollPane.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        add(controlPanel, BorderLayout.LINE_START);

        bookingPanel = new JPanel();
        bookingPanel.setBorder(new TitledBorder(new EtchedBorder(), "Bookings"));
        bookingPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 10, 250));
        controlPanel.add(bookingPanel, BorderLayout.LINE_START);

        // Buttons
        button1 = new JButton("Create Booking");
        button1.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        bookingPanel.add(button1);

        button2 = new JButton("Check Bookings");
        button2.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        bookingPanel.add(button2);

        button3 = new JButton("Something to do with Bookings");
        button3.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        bookingPanel.add(button3);

        adminPanel = new JPanel();
        adminPanel.setBorder(new TitledBorder(new EtchedBorder(), "Admin"));
        adminPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 10, 250));
        controlPanel.add(adminPanel, BorderLayout.LINE_START);

        button4 = new JButton("Admin");
        button4.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        adminPanel.add(button4);

        button5 = new JButton("Admin but more");
        button5.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        adminPanel.add(button5);

        logoutPanel = new JPanel();
        logoutPanel.setBorder(new TitledBorder(new EtchedBorder(), "Logout"));
        logoutPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 10, 150));
        controlPanel.add(logoutPanel, BorderLayout.LINE_START);

        button6 = new JButton("Logout");
        button6.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        logoutPanel.add(button6);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
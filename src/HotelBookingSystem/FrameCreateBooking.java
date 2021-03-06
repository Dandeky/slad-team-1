
package HotelBookingSystem;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrameCreateBooking extends JFrame {

    private final int SCREEN_INITIAL_WIDTH = 1280;
    private final int SCREEN_INITIAL_HEIGHT = 720;

    private Hotel hotel;
    private User user;

    private final JPanel controlPanel, detailPanel, durationPanel, extrasPanel;
    private final JButton submitButton;
    private final JCheckBox gymCheck, breakfastCheck, wifiCheck;
    private JTextField nameInput;
    private final JSpinner room1Spinner, room2Spinner, room3Spinner, room4Spinner, guestSpinner, startDateSpinner, endDateSpinner;

    public FrameCreateBooking(Hotel hotel, User user) {

        this.hotel = hotel;
        this.user = user;

        setTitle("Create Booking");
        setLayout(new BorderLayout());

        controlPanel = new JPanel();
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
        controlPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        //JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
        //controlPanelScrollPane.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        add(controlPanel, BorderLayout.LINE_START);

        //Basic Details
        detailPanel = new JPanel();
        detailPanel.setBorder(new TitledBorder(new EtchedBorder(), "Basic Details"));
        detailPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 20, 310));
        controlPanel.add(detailPanel, BorderLayout.LINE_START);

        JLabel nameLabel = new JLabel("Name");
        detailPanel.add(nameLabel);
        nameInput = new JTextField();
        nameInput.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 50, 50));
        detailPanel.add(nameInput);

        SpinnerNumberModel room1Model = new SpinnerNumberModel(0, 0, 100, 1);
        JLabel room1Label = new JLabel("Single");
        detailPanel.add(room1Label);
        room1Spinner = new JSpinner(room1Model);
        detailPanel.add(room1Spinner);

        SpinnerNumberModel room2Model = new SpinnerNumberModel(0, 0, 100, 1);
        JLabel room2Label = new JLabel("Double");
        detailPanel.add(room2Label);
        room2Spinner = new JSpinner(room2Model);
        detailPanel.add(room2Spinner);

        SpinnerNumberModel room3Model = new SpinnerNumberModel(0, 0, 100, 1);
        JLabel room3Label = new JLabel("Family");
        detailPanel.add(room3Label);
        room3Spinner = new JSpinner(room3Model);
        detailPanel.add(room3Spinner);

        SpinnerNumberModel room4Model = new SpinnerNumberModel(0, 0, 100, 1);
        JLabel room4Label = new JLabel("Business");
        detailPanel.add(room4Label);
        room4Spinner = new JSpinner(room4Model);
        detailPanel.add(room4Spinner);

        SpinnerNumberModel guestModel = new SpinnerNumberModel(0, 0, 100, 1);
        JLabel guestLabel = new JLabel("No. of Total Guests");
        detailPanel.add(guestLabel);
        guestSpinner = new JSpinner(guestModel);
        detailPanel.add(guestSpinner);

        //Duration of Stay Panel
        durationPanel = new JPanel();
        durationPanel.setBorder(new TitledBorder(new EtchedBorder(), "Duration of Stay"));
        durationPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 20, 180));
        controlPanel.add(durationPanel, BorderLayout.LINE_START);

        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 200);
        Date latestDate = calendar.getTime();

        JLabel startDateLabel = new JLabel("Start Date");
        durationPanel.add(startDateLabel);
        SpinnerDateModel startDateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR);
        startDateSpinner = new JSpinner(startDateModel);
        durationPanel.add(startDateSpinner);

        JLabel endDateLabel = new JLabel("End Date");
        durationPanel.add(endDateLabel);
        SpinnerDateModel endDateModel = new SpinnerDateModel(initDate, earliestDate, latestDate, Calendar.YEAR);
        endDateSpinner = new JSpinner(endDateModel);
        durationPanel.add(endDateSpinner);

        //Extras Panel
        extrasPanel = new JPanel();
        extrasPanel.setBorder(new TitledBorder(new EtchedBorder(), "Optional Extras"));
        extrasPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 20, 100));
        controlPanel.add(extrasPanel, BorderLayout.LINE_START);

        gymCheck = new JCheckBox("Gym");
        breakfastCheck = new JCheckBox("Breakfast");
        wifiCheck = new JCheckBox("WiFi");
        extrasPanel.add(gymCheck);
        extrasPanel.add(breakfastCheck);
        extrasPanel.add(wifiCheck);

        submitButton = new JButton("Confirm Booking");
        submitButton.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 600, 80));
        controlPanel.add(submitButton);
        submitButton.addActionListener(new SubmitListener());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
            int[] rooms = new int[4];
            boolean[] extras = new boolean[3];

            rooms[0] = (int) room1Spinner.getValue();
            rooms[1] = (int) room2Spinner.getValue();
            rooms[2] = (int) room3Spinner.getValue();
            rooms[3] = (int) room4Spinner.getValue();
            extras[0] = gymCheck.isSelected();
            extras[1] = breakfastCheck.isSelected();
            extras[2] = wifiCheck.isSelected();

            Date startDate = (Date) startDateSpinner.getValue();
            Date endDate = (Date) endDateSpinner.getValue();

            Booking booking = new Booking(1, rooms, startDate, endDate, extras);
            hotel.makeBooking(1, rooms, startDate, endDate, extras);
            HotelHandler.saveBooking(booking);

            FrameHomepage frameHomepage = new FrameHomepage(hotel, user);
            dispose();
        }
    }

}

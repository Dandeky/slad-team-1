
package HotelBookingSystem;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrameCreateBooking extends JFrame {

    private final int SCREEN_INITIAL_WIDTH = 1280;
    private final int SCREEN_INITIAL_HEIGHT = 720;

    private final JPanel controlPanel, detailPanel, durationPanel, extrasPanel;
    private final JButton submitButton;
    private final JCheckBox gymCheck, breakfastCheck, wifiCheck;
    private JTextField nameInput;

    public FrameCreateBooking() {
        setTitle("FrameCreateBooking");
        setLayout(new BorderLayout());

        controlPanel = new JPanel();
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "FrameCreateBooking"));
        controlPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        //JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
        //controlPanelScrollPane.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        add(controlPanel, BorderLayout.LINE_START);

        //Basic Details
        detailPanel = new JPanel();
        detailPanel.setBorder(new TitledBorder(new EtchedBorder(), "Basic Details"));
        detailPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH-20, 310));
        controlPanel.add(detailPanel, BorderLayout.LINE_START);
        
        JLabel nameLabel = new JLabel("Name");
        detailPanel.add(nameLabel);
        nameInput = new JTextField();
        nameInput.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 50, 50));
        detailPanel.add(nameInput);
        
        //Duration of Stay Panel
        durationPanel = new JPanel();
        durationPanel.setBorder(new TitledBorder(new EtchedBorder(), "Duration of Stay"));
        durationPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH-20, 180));
        controlPanel.add(durationPanel, BorderLayout.LINE_START);
        
        int currentYear = Date(new Date);
        Date initDate = calendar.getTime();
        
        //String[] monthStrings = getMonthStrings(); //get month names
        SpinnerNumberModel monthModel = new SpinnerNumberModel(currentYear, currentYear, currentYear + 10, 1);
        JSpinner spinner = new JSpinner(monthModel);
        durationPanel.add(spinner);
        
        //Extras Panel
        extrasPanel = new JPanel();
        extrasPanel.setBorder(new TitledBorder(new EtchedBorder(), "Optional Extras"));
        extrasPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH-20, 100));
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
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        FrameCreateBooking frameCreateBooking = new FrameCreateBooking();
    }

    private String[] getMonthStrings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

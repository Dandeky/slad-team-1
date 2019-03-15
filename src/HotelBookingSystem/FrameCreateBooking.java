
package HotelBookingSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrameCreateBooking extends JFrame {

    private final int SCREEN_INITIAL_WIDTH = 1280;
    private final int SCREEN_INITIAL_HEIGHT = 720;

    private final JPanel controlPanel;

    public FrameCreateBooking() {
        setTitle("FrameCreateBooking");
        setLayout(new BorderLayout());

        controlPanel = new JPanel();
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "FrameHomepage"));
        controlPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        //JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
        //controlPanelScrollPane.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        add(controlPanel, BorderLayout.LINE_START);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        FrameCreateBooking frameCreateBooking = new FrameCreateBooking();
    }

}

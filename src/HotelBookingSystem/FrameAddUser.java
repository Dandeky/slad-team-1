
package HotelBookingSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrameAddUser extends JFrame {
    
    private final int SCREEN_INITIAL_WIDTH = 400;
    private final int SCREEN_INITIAL_HEIGHT = 600;

    private final JPanel controlPanel, basicDetailPanel, loginDetailPanel;
    private final JButton submitButton;
    private JTextField firstNameInput, lastNameInput, teleInput, usernameInput, passwordInput;
    
    public FrameAddUser(int userType){
        setTitle("FrameAddUser");
        setLayout(new BorderLayout());

        controlPanel = new JPanel();
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "FrameAddUser"));
        controlPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        //JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
        //controlPanelScrollPane.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        add(controlPanel, BorderLayout.LINE_START);
        
        basicDetailPanel = new JPanel();
        basicDetailPanel.setBorder(new TitledBorder(new EtchedBorder(), "Basic Details"));
        basicDetailPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH-20, 275));
        controlPanel.add(basicDetailPanel, BorderLayout.LINE_START);
        
        JLabel firstNameLabel = new JLabel("First Name");
        basicDetailPanel.add(firstNameLabel);
        firstNameInput = new JTextField();
        firstNameInput.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 50, 50));
        basicDetailPanel.add(firstNameInput);
        
        JLabel lastNameLabel = new JLabel("Last Name");
        basicDetailPanel.add(lastNameLabel);
        lastNameInput = new JTextField();
        lastNameInput.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 50, 50));
        basicDetailPanel.add(lastNameInput);
        
        JLabel teleLabel = new JLabel("Telephone");
        basicDetailPanel.add(teleLabel);
        teleInput = new JTextField();
        teleInput.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 50, 50));
        basicDetailPanel.add(teleInput);
        
        loginDetailPanel = new JPanel();
        loginDetailPanel.setBorder(new TitledBorder(new EtchedBorder(), "Login Details"));
        loginDetailPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH-20, 200));
        controlPanel.add(loginDetailPanel, BorderLayout.LINE_START);
        
        JLabel usernameLabel = new JLabel("Username");
        loginDetailPanel.add(usernameLabel);
        usernameInput = new JTextField();
        usernameInput.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 50, 50));
        loginDetailPanel.add(usernameInput);
        
        JLabel passwordLabel = new JLabel("Password");
        loginDetailPanel.add(passwordLabel);
        passwordInput = new JTextField();
        passwordInput.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 50, 50));
        loginDetailPanel.add(passwordInput);
        
        submitButton = new JButton("Create New User");
        submitButton.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 100, 80));
        controlPanel.add(submitButton);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        FrameAddUser frameAddUser = new FrameAddUser();
    }
}

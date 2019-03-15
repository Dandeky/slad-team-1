package assignment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

class LoginFrame extends JFrame {

    private final int SCREEN_INITIAL_WIDTH = 400;
    private final int SCREEN_INITIAL_HEIGHT = 600;

    private final JPanel controlPanel;
    private final JTextField usernameInput, passwordInput;
    private final JButton loginButton;

    LoginFrame() {

        controlPanel = new JPanel();
        controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "LoginFrame"));
        controlPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        controlPanel.setLayout(new FlowLayout());
        //JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
        //controlPanelScrollPane.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        add(controlPanel);

        JLabel usernameLabel = new JLabel("Username");
        controlPanel.add(usernameLabel);
        usernameInput = new JTextField();
        usernameInput.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 50, 50));
        controlPanel.add(usernameInput);

        JLabel passwordLabel = new JLabel("Password");
        controlPanel.add(passwordLabel);
        passwordInput = new JTextField();
        passwordInput.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 50, 50));
        controlPanel.add(passwordInput);

        loginButton = new JButton("LoginFrame");
        loginButton.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
        controlPanel.add(loginButton);

        //TODO: Actionlistener class that sends login data UsersHandler.verifyLogin(username, password)
        // Pass hotel and user ids to homepage jframe


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}


package assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Login extends JFrame{
    
    private final int SCREEN_INITIAL_WIDTH = 400;
    private final int SCREEN_INITIAL_HEIGHT = 600;
    
    private final JPanel controlPanel;
    private final JTextField usernameInput, passwordInput;
    private final JButton loginButton;
    
    public Login(){
    
        controlPanel = new JPanel();
          controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "Login"));
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
        
        loginButton = new JButton("Login");
          loginButton.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
          controlPanel.add(loginButton);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        Login login = new Login();
    }
}

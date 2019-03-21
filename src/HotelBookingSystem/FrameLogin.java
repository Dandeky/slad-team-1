package HotelBookingSystem;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

class FrameLogin extends JFrame {

    private final int SCREEN_INITIAL_WIDTH = 400;
    private final int SCREEN_INITIAL_HEIGHT = 600;

    private final JPanel controlPanel;
    private final JTextField usernameInput, passwordInput;
    private final JButton loginButton;

    
     class LoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            
            String username = "";
            String password = "";
            try{
                username = usernameInput.getText();
                password = passwordInput.getText();
            }
            catch(NullPointerException e){
                System.out.println("At least 1 field is empty");
            }
            
            
           if (UsersHandler.verifyLogin(username, password)){
               //Logged in
               
       //Test   
                                                        String[] types = new String[10];
                                                        
                                                        for (int i = 0; i < types.length; i++) {
                                                            if (i % 2 == 0) {
                                                                types[i] = "single";
                                                            } else {
                                                                types[i] = "double";
                                                            }
                                                        }

                                                        Hotel testHotel = new Hotel("Test Hotel", types);

               
              FrameHomepage framehomepage = new FrameHomepage(testHotel, 7);
             
              setVisible(false);
              dispose();
           }
           else{
               System.out.println("Login Failed");
                }
        }
    }//END ActionListener
      
    
    
    
    
    
    FrameLogin() {

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
        loginButton.addActionListener(new LoginListener() );

       
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    
}

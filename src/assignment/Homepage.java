
package assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Homepage extends JFrame{
    
    private final int SCREEN_INITIAL_WIDTH = 1280;
    private final int SCREEN_INITIAL_HEIGHT = 720;
    
    private final JPanel controlPanel;
    private final JButton button1, button2, button3, button4, button5, button6;
    
    public Homepage(){
        setTitle("Homepage");
        setLayout(new BorderLayout());
        
        // Button Panel
        controlPanel = new JPanel();
          controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "Homepage"));
          controlPanel.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
          //JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
          //controlPanelScrollPane.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH, SCREEN_INITIAL_HEIGHT));
        add(controlPanel, BorderLayout.LINE_START); 
        
        // Buttons
          button1 = new JButton("Button 1");
          button1.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
          controlPanel.add(button1);
        
          button2 = new JButton("Button 2");
          button2.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
          controlPanel.add(button2);
          
          button3 = new JButton("Button 3");
          button3.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
          controlPanel.add(button3);
          
          button4 = new JButton("Button 4");
          button4.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
          controlPanel.add(button4);
          
          button5 = new JButton("Button 5");
          button5.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
          controlPanel.add(button5);
          
          button6 = new JButton("Button 6");
          button6.setPreferredSize(new Dimension(SCREEN_INITIAL_WIDTH - 200, 50));
          controlPanel.add(button6);
          
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        Homepage homepage = new Homepage();
    }
    
}
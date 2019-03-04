
package assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Homepage extends JFrame{
    
    private final int CANVAS_INITIAL_WIDTH = 800;
    private final int CANVAS_INITIAL_HEIGHT = 640;
    private final int CONTROL_PANEL_WIDTH = 640;
    private final int MESSAGE_AREA_HEIGHT = 100;
    
    private JPanel controlPanel;
    
    public Homepage(){
        setTitle("Homepage");
        setLayout(new BorderLayout());
        setSize(640,640);
        
        controlPanel = new JPanel();
          controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "Homepage"));
          controlPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH, CANVAS_INITIAL_HEIGHT));
          JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
          controlPanelScrollPane.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH + 30, CANVAS_INITIAL_HEIGHT));
        add(controlPanelScrollPane, BorderLayout.LINE_START); 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        Homepage listAppInstance = new Homepage();
    }
    
}

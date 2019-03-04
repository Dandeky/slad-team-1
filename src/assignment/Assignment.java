
package assignment;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class Assignment extends JFrame
{

    // GUI Component dimentsions.
    private final int CANVAS_INITIAL_WIDTH = 800;
    private final int CANVAS_INITIAL_HEIGHT = 640;
    private final int CONTROL_PANEL_WIDTH = 200;
    private final int MESSAGE_AREA_HEIGHT = 100;
    static int hop = 0;
    
    // Arrays for temporary storage of file data
    private String[] birthdaydata;
    private String[] phonedata;
    
    // Linked List creation
    SLLC birthList = new SLLC();
    Birthdays BD = new Birthdays();
    SLLC phoneList = new SLLC();
    PhoneNo PN = new PhoneNo();
    
    // Canvas Class
    class Canvas extends JPanel
    {
        // Called every time there is a change in the canvas contents.
        public void paintComponent(Graphics g)
        {
           super.paintComponent(g);        
           draw(g);
        }
    }
    
    // Load the Birthday Reminder List
    class LoadBirthdayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            messageArea.append("Loading the Birthdays list...\n");
            birthdaydata = new String[2];
            hop = 0;
            String data1;
            String data2;
            SLLItem birthdayItem;
            
            try {
                
            BufferedReader reader = new BufferedReader(new FileReader("BirthdayReminder.txt"));
            if(birthList.head != null)birthList.head = null;
            
            String line = reader.readLine();
            while (line != null){
                String data = line;
                String[] birthdaydata = data.split(",");
                data1 = birthdaydata[0];
                data2 = birthdaydata[1];
                
                birthdayItem = new SLLItem(BD, data1, data2);
                birthList.addToTail(birthdayItem);
                
                line = reader.readLine();
            }
            
            messageArea.append("Loading sucessful!\n");
            hop(hop);
            canvas.repaint();
            
        } catch (FileNotFoundException ex) {
              messageArea.append("FileNotFoundException Caught: No Birthday Reminder data was found\n");
        } catch (IOException ex) {
              messageArea.append("IOException Caught\n");
        } catch (NullPointerException ex) {
            messageArea.append("NullPointerException Caught: The file is missing necessary data\n");
        }
        
        }
    }
    
    // Load the Phone Number Info List
    class LoadPhoneListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            messageArea.append("Loading the Phone Number list...\n");
            phonedata = new String[2];
            hop = 0;
            String data1;
            String data2;
            SLLItem phoneItem;
            
            try {
                
            BufferedReader reader = new BufferedReader(new FileReader("PhoneNoInfo.txt"));
            if(phoneList.head != null)phoneList.head = null;
            
            String line = reader.readLine();
            while (line != null){
                String data = line;
                String[] phonedata = data.split(",");
                data1 = phonedata[0];
                data2 = phonedata[1];
                
                phoneItem = new SLLItem(PN, data1, data2);
                phoneList.addToTail(phoneItem);
                
                line = reader.readLine();
            }
            
            messageArea.append("Loading sucessful!\n");
            hop(hop);
            canvas.repaint();
            
        } catch (FileNotFoundException ex) {
              messageArea.append("FileNotFoundException Caught: No Phone Number Info data was found\n");
        } catch (IOException ex) {
              messageArea.append("IO Exception Caught!\n");
        } catch (NullPointerException ex) {
            messageArea.append("NullPointerException Caught: The file is missing necessary data\n");
        }
            
        }
    }
    
    // Perform the EnQueue function
    class EnQueueListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
        hop = 0;
        if(birthdayRadio.isSelected()){
            if(nameInput.getText().equals("")){
                messageArea.append("No name data to enQueue has been found\n");
            }
            if(birthdayInput.getText().equals("")){
                messageArea.append("No birthday data to enQueue has been found\n");
            }
            else {
                String data1;
                String data2;
                SLLItem birthItem;
            
                data1 = nameInput.getText();
                data2 = birthdayInput.getText();
            
                birthItem = new SLLItem(BD, data1, data2);
                birthList.addToTail(birthItem);
                canvas.repaint();
            }
        }
        if(phoneRadio.isSelected()){
            if(nameInput.getText().equals("")){
                messageArea.append("No name data to enQueue has been found\n");
            }
            if(phoneInput.getText().equals("")){
                messageArea.append("No phone number data to enQueue has been found\n");
            }
            else {
                try {
                String data1;
                String data2;
                SLLItem phoneItem;
            
                data1 = nameInput.getText();
                data2 = phoneInput.getText();
            
                phoneItem = new SLLItem(PN, data1, data2);
                phoneList.addToTail(phoneItem);
                canvas.repaint();
                } catch (NumberFormatException ex){
                    messageArea.append("NumberFormatException Caught: Non-integer data found in phone input\n");
                }
            }
        }
        hop(hop);
        }
    }
    
    // Perform the Serve function
    class ServeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            hop = 0;
            if(birthdayRadio.isSelected()){
                try {
                SLLItem birthServe = birthList.head;
                messageArea.append("The served item in the birthday list is: '" + birthServe.getName() + ", " + birthServe.getBirth() + "'\n");
                birthList.removeFromHead();
                canvas.repaint();
                }
                catch (NullPointerException ex) {
                messageArea.append("NullPointerException Caught: There is no data in the birthday list\n");
            }
        }
            if(phoneRadio.isSelected()){
                try {
                SLLItem phoneServe = phoneList.head;
                messageArea.append("The served item in the phone list is: '" + phoneServe.getName() + ", " + phoneServe.getPhone() + "'\n");
                phoneList.removeFromHead();
                canvas.repaint();
                }
                catch (NullPointerException ex) {
                messageArea.append("NullPointerException Caught: There is no data in the phone list\n");
            }
        }
        hop(hop);
        }
    }
    
    // Perform the getHead function
    class GetHeadListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            hop = 0;
            if(birthdayRadio.isSelected()){
                try {
                SLLItem birthServe = birthList.head;
                messageArea.append("The first item in the birthday list is: '" + birthServe.getName() + ", " + birthServe.getBirth() + "'\n");
                }
                catch (NullPointerException ex) {
                messageArea.append("NullPointerException Caught: There is no data in the birthday list\n");
            }
        }
            if(phoneRadio.isSelected()){
                try {
                SLLItem phoneServe = phoneList.head;
                messageArea.append("The first item in the phone list is: '" + phoneServe.getName() + ", " + phoneServe.getPhone() + "'\n");
                }
                catch (NullPointerException ex) {
                messageArea.append("NullPointerException Caught: There is no data in the phone list\n");
            }
        }
        hop(hop);
        }
    }
    
    // Perform the Clear function
    class EmptyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
        hop = 0;
        int emptyCheck = JOptionPane.showConfirmDialog(null,"Are you sure you want to clear everything from this list?","Confirm to empty",JOptionPane.YES_NO_OPTION);
        if (emptyCheck==JOptionPane.YES_OPTION){
            if(birthdayRadio.isSelected()){
                if(birthList.head != null){
                    birthList.head = null;
                    messageArea.append("Birthday list Emptied\n");
                    canvas.repaint();
                } else {
                messageArea.append("The Birthday list is already empty\n"); 
            }
        }
            if(phoneRadio.isSelected()){
                if(phoneList.head != null){
                    phoneList.head = null;
                    messageArea.append("Phone list Emptied\n");
                    canvas.repaint();
                } else {
                messageArea.append("The Phone list is already empty\n"); 
            }
        }
          }
          if (emptyCheck==JOptionPane.NO_OPTION){
             messageArea.append("Empty Process Aborted\n");
          }
          hop(hop);
        }
    }
    
    // Exit the Program
    class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.exit(0);
        }
    }
    
    // Launch the About window
    class AboutListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "CSC-20037 Assignment\nList-based Queue Application with GUI\n\nButton functions:\nEnQueue: Add a new entry to the selected list\nServe: Serve the first item in the selected list (displayed in the message area) and remove it\nGetHead: Display the first item in the selected list in the message area\nEmpty: Delete all data in the selected list");
        }
    }
    
    // Hops Counter
    public void hop (int number) {
        hopsLabel.setText(number + " hops");
    }
    
    private Canvas canvas;
    
    private JPanel controlPanel;
    private JRadioButton birthdayRadio, phoneRadio;
    private ButtonGroup listSelector;
    private JButton addEntryButton, firstEntryButton, printListButton, emptyListButton;
    
    private JTextArea messageArea;
    private JTextField nameInput, birthdayInput, phoneInput;
    private JLabel nameLabel, birthdayLabel, phoneLabel, hopsLabel;
    
    private JMenuBar menuBar;
    
    public Assignment()
    {
        setTitle("List Application (Assignment)");
        setLayout(new BorderLayout());
        
        // Canvas
        canvas = new Canvas();
          canvas.setBorder(new TitledBorder(new EtchedBorder(), "List Display"));
          canvas.setPreferredSize(new Dimension(CANVAS_INITIAL_WIDTH, CANVAS_INITIAL_HEIGHT));
        add(canvas, BorderLayout.CENTER);
        
        // Menu bar
        menuBar = new JMenuBar();
          JMenu fileMenu = new JMenu("File");
            JMenu loadSubMenu = new JMenu("Load...");
            fileMenu.add(loadSubMenu);
            JMenuItem loadBirthdayMenuItem = new JMenuItem("Birthday Reminder");
            loadSubMenu.add(loadBirthdayMenuItem);
            loadBirthdayMenuItem.addActionListener(new LoadBirthdayListener());
            JMenuItem loadPhoneMenuItem = new JMenuItem("Phone Number Info");
            loadSubMenu.add(loadPhoneMenuItem);
            loadPhoneMenuItem.addActionListener(new LoadPhoneListener());
            fileMenu.addSeparator();
            JMenuItem fileExitMenuItem = new JMenuItem("Exit");
            fileMenu.add(fileExitMenuItem);
            fileExitMenuItem.addActionListener(new ExitListener());
          menuBar.add(fileMenu);
          JMenu helpMenu = new JMenu("Help");
            JMenuItem helpAboutMenuItem = new JMenuItem("About");
            helpMenu.add(helpAboutMenuItem);
            helpAboutMenuItem.addActionListener(new AboutListener());
          menuBar.add(helpMenu);
        add(menuBar, BorderLayout.PAGE_START);
        
        // Control Panel
        controlPanel = new JPanel();
          controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "Control Panel"));
          controlPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH, CANVAS_INITIAL_HEIGHT));
          JScrollPane controlPanelScrollPane = new JScrollPane(controlPanel);
          controlPanelScrollPane.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH + 30, CANVAS_INITIAL_HEIGHT));
        add(controlPanelScrollPane, BorderLayout.LINE_START); 
        
        // Hops Panel
        JPanel hopsPanel = new JPanel();
          hopsPanel.setBorder(new TitledBorder(new EtchedBorder(), "No. of Hops"));
          hopsPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 60));
          hopsLabel = new JLabel("No previous action performed");
          hopsPanel.add(hopsLabel);
        controlPanel.add(hopsPanel);
        
        // List Selector Panel
        JPanel listSelectorPanel = new JPanel();
          listSelectorPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 140));
          listSelectorPanel.setLayout(new GridLayout(0, 1));
          listSelectorPanel.setBorder(new TitledBorder(new EtchedBorder(), "List Selector"));
          birthdayRadio = new JRadioButton("Birthday Reminder");
          phoneRadio = new JRadioButton("Phone Number Info");
          listSelectorPanel.add(birthdayRadio);
          listSelectorPanel.add(phoneRadio);
          listSelector = new ButtonGroup();
          listSelector.add(birthdayRadio);
          listSelector.add(phoneRadio);
          birthdayRadio.setSelected(true);
        controlPanel.add(listSelectorPanel);
        
        // Manager Panel
        JPanel editorPanel = new JPanel();
          editorPanel.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 20, 360));
          editorPanel.setBorder(new TitledBorder(new EtchedBorder(), "Manager"));
          
          // Name Entry Box
          JLabel nameLabel = new JLabel("Name");
          editorPanel.add(nameLabel);
          nameInput = new JTextField();
          nameInput.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 40, 25));
          editorPanel.add(nameInput);
          
          // Birthday Entry Box
          JLabel birthdayLabel = new JLabel("Date of Birth");
          editorPanel.add(birthdayLabel);
          birthdayInput = new JTextField();
          birthdayInput.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 40, 25));
          editorPanel.add(birthdayInput);
          
          // Phone Entry Box
          JLabel phoneLabel = new JLabel("Phone Number");
          editorPanel.add(phoneLabel);
          phoneInput = new JTextField();
          phoneInput.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 40, 25));
          editorPanel.add(phoneInput);
          
          // enQueue Button - Add new data to the queue
          addEntryButton = new JButton("enQueue");
          addEntryButton.addActionListener(new EnQueueListener());
          addEntryButton.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 40, 40));
          editorPanel.add(addEntryButton);
        
        // serve Button - Show what is at the front of the queue then serve it (remove it)
          firstEntryButton = new JButton("serve");
          firstEntryButton.addActionListener(new ServeListener());
          firstEntryButton.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 40, 40));
          editorPanel.add(firstEntryButton);
        
        // getHead Button - Show what is at the front of the queue
          printListButton = new JButton("getHead");
          printListButton.addActionListener(new GetHeadListener());
          printListButton.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 40, 40));
          editorPanel.add(printListButton);
        
        // Empty Button - Remove all data in the queue
          emptyListButton = new JButton("Empty");
          emptyListButton.addActionListener(new EmptyListener());
          emptyListButton.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH - 40, 40));
          editorPanel.add(emptyListButton);
          
        controlPanel.add(editorPanel);
        
        // Message area
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setBackground(canvas.getBackground());
        JScrollPane textAreaScrollPane = new JScrollPane(messageArea);
        textAreaScrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Message Area"));
        textAreaScrollPane.setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH + CANVAS_INITIAL_WIDTH, MESSAGE_AREA_HEIGHT));
        add(textAreaScrollPane, BorderLayout.PAGE_END);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
    }
    
    void draw(Graphics g)
    {
        // Drawing the birthday list
        SLLItem birthDraw = birthList.head;
        int i = 1;
        while (birthDraw != null) {
            g.drawString(birthDraw.getName() + ", " + birthDraw.getBirth(), 100, 60+(i*30));
            birthDraw = birthDraw.getNextItem();
            i++;
        }
        
        // Drawing the phone list
        SLLItem phoneDraw = phoneList.head;
        int j = 1;
        while (phoneDraw != null) {
            g.drawString(phoneDraw.getName() + ", " + phoneDraw.getPhone(), 500, 60+(j*30));
            phoneDraw = phoneDraw.getNextItem();
            j++;
        }
        
        
    }
    
    public static void main(String[] args) 
    {
        Assignment listAppInstance = new Assignment();
    }
    
}

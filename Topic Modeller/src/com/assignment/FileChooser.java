package com.assignment;

/*******
 * This class is the File Chooser GUI which is the opening window
 * This class allows user to enter in 3 different file names to be searched
 * 
 * Author: Dylan O'Connor
 * Start Date: 30/03/2020
 * End Date: 20/04/2020
 *******/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class FileChooser extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	//attributes
	JLabel heading, fileLabel1, fileLabel2, fileLabel3;
	JButton searchButton; 
	JTextField file1Text, file2Text, file3Text;
	JFrame frame;
	String[] words;
	HashMap<String, Integer> wordMap= new HashMap<String, Integer>();
	HashMap<String, Integer> totalWords = new HashMap<String, Integer>();

	
    public FileChooser() {

    	
    	//Frame/Panel
    	frame = new JFrame();
        JPanel panel = new JPanel();
        
        //search button
        searchButton = new JButton("Search Files!");
    
        //heading
        heading = new JLabel("Welcome to Topic Modeller!");
        heading.setBorder(BorderFactory.createEmptyBorder(15,0,0,15));
        
        //Labels
        fileLabel1 = new JLabel("File 1 Name: ");
        fileLabel2 = new JLabel("File 2 Name: ");
        fileLabel3 = new JLabel("File 3 Name: ");
        
        //Text Field Elements
        file1Text = new JTextField(20);
        file1Text.setToolTipText("Eg. file1name.txt");
     
        file2Text = new JTextField(20);
        file2Text.setToolTipText("Eg. file2name.txt");
        
        file3Text = new JTextField(20);
        file3Text.setToolTipText("Eg. file3name.txt");
        
        //adding heading and button to north and south of the frame
        frame.getContentPane().add(BorderLayout.NORTH, heading);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(BorderLayout.SOUTH, searchButton);
        
        //Setting up gridlayout
        panel.setLayout(new GridBagLayout());
        frame.getContentPane().add(panel);
        
        //leftside elements
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        
        //right side elements
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;
        
        //center elements constraints
        GridBagConstraints center = new GridBagConstraints();
        center.fill=GridBagConstraints.BOTH;
        center.anchor=GridBagConstraints.CENTER;
        center.weightx = 1.0;
        center.gridwidth = GridBagConstraints.REMAINDER;
        
        //rule labels
        JLabel rulesLabel = new JLabel("Rules");
        rulesLabel.setForeground(Color.red);
        rulesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel info = new JLabel("- Enter 3 different files below to see how likely it is that they are related");
        JLabel info1 = new JLabel("- You must enter 3 valid files in the format \"FileName.txt\"");
        JLabel info2 = new JLabel("- Files must be in the same folder as the Topic Modeller tool!");
        JLabel info3 = new JLabel("- Click Search to see results!");
        info3.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        
        //action listeners
        searchButton.addActionListener(this);
        file1Text.addActionListener(this);
        file2Text.addActionListener(this);
        file3Text.addActionListener(this);
	
        
        //adding elements to gui
        panel.add(rulesLabel, center);
        panel.add(info, center);
        panel.add(info1, center);
        panel.add(info2, center);
        panel.add(info3, center);
        panel.add(fileLabel1, left);
        panel.add(file1Text, right);
        panel.add(fileLabel2, left);
        panel.add(file2Text, right);
        panel.add(fileLabel3, left);
        panel.add(file3Text, right);
        
        //setting border around center so items are spread out
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        //sizing window to the default size
        //so that elements fit on screen best
        frame.pack();
        frame.setVisible(true); 
        
    }
   
    //actionHandler
	public void actionPerformed (ActionEvent e1) {
		if (e1.getSource() == searchButton) {
			//getting text from textfield
			
			String file1 = file1Text.getText();
			String file2 = file2Text.getText();
			String file3 = file3Text.getText();

			try {
				//creating instance of FileManager class to display Hashmap
				FileManager fm = new FileManager(file1);
				fm.connectToFile();//connecting to file
				wordMap = fm.getWords();
				JTable table = setTable(wordMap);
				fm.closeFile();
    	
    		
				//creating a new instance fro file2
				FileManager fm1 = new FileManager(file2);
				fm1.connectToFile();//connecting to file
				wordMap = fm1.getWords();
				JTable table2 = setTable(wordMap);
				fm1.closeFile();
	
    		
				//creating a new instance for file3
				FileManager fm2 = new FileManager(file3);
				fm2.connectToFile();//connecting to file
				wordMap = fm2.getWords();
				JTable table3 = setTable(wordMap);
				//closing file 
				fm2.closeFile();
    		
				@SuppressWarnings("unused")
				FileResults f1 = new FileResults(table, table2, table3);
    		    		    		
			}//end try 
    	
    	
			catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Error: You Must enter 3 Valid Files to Compare with eachother!");
				System.out.println(e);
			}//end catch 
    	
		}//end if
    }//end actionPerformed
    
	//creaing table model to use
    public JTable setTable(HashMap<String, Integer> wordMap) {
    	
    	//setting the header title names
    	DefaultTableModel tableModel = new DefaultTableModel(
    		new Object[] { "Word", "Count" }, 0
    	);
    	
    	int row=0;
    	//Entering Data into rows based off first 8 rows of sorted hash map
    	for (Map.Entry<String, Integer> entry : wordMap.entrySet()) 
    	{
    		//ensuring the table ony has 8 rows
    		if (row!=8) 
    		{
    			//add key and value at that iteration to table
    	        tableModel.addRow(new Object[] { entry.getKey(), entry.getValue() });
    	        row++;
    	    }//end if
        }//end for
    	
    	
    	//creating a table based off the table Model
    	JTable table = new JTable(tableModel);
    
   		return table;
    }
	
}//end class

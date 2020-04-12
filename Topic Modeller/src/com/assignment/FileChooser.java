package com.assignment;

/*******
 * ..
 * Author: Dylan O'Connor
 * Start Date: 30/03/2020
 * End Date: ..
 *******/
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
//import java.util.Map;
import java.util.Map;


public class FileChooser extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JLabel heading, fileLabel1, fileLabel2, fileLabel3;
	JButton searchButton; 
	JTextField file1Text, file2Text, file3Text;
	JFrame frame;
	String[] words;
	
	JTable table;	HashMap<String, Integer> wordMap= new HashMap<String, Integer>();

	
    public FileChooser (String myTitle) {
    	super(myTitle);
    	
    	//Frame/Panel
    	frame = new JFrame();
        JPanel panel = new JPanel();
        searchButton = new JButton("Search Files!");

		
        
        //heading
        heading = new JLabel("Welcome to Topic Modeller!  Enter File names to check if they are related!");
        
        //Labels
        fileLabel1 = new JLabel("File Name: ");
        fileLabel2 = new JLabel("File Name: ");
        fileLabel3 = new JLabel("File Name: ");
        
        //Text Field Elements
        file1Text = new JTextField(20);
        file2Text = new JTextField(20);
        file3Text = new JTextField(20);

        frame.getContentPane().add(BorderLayout.NORTH, heading);
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
        
        searchButton.addActionListener(this);
        file1Text.addActionListener(this);
        
	
        
        //adding elements to gui
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
   
    public void actionPerformed (ActionEvent e1) {
    	FileManager fm = new FileManager(file1Text.getText());
    	
    	//creating instance of FileManager class to display Hashmap
    	fm.connectToFile();//connecting to file
    	wordMap = fm.getWords();
    	JTable table = new JTable(5,2);
    	
    	//displaying hash map in table
    	int row=0;
		for(Map.Entry<String,Integer> entry: wordMap.entrySet()){
			if(row != 5) {
				table.setValueAt(entry.getKey(),row,0);
			    table.setValueAt(entry.getValue(),row,1);
			    row++;
			}//end if
		}
		
		FileResults f1 = new FileResults(table, table);
		f1.setVisible(true);
		
		//closing file
		fm.closeFile();
		
    }
    

}

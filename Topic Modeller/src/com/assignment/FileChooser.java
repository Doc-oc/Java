package com.assignment;

/*******
 * ..
 * Author: Dylan O'Connor
 * Start Date: 30/03/2020
 * End Date: ..
 *******/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.File;
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
	HashMap<String, Integer> wordMap= new HashMap<String, Integer>();
	HashMap<String, Integer> totalWords = new HashMap<String, Integer>();

	
    public FileChooser (String myTitle) {
    	super(myTitle);
    	
    	//Frame/Panel
    	frame = new JFrame();
        JPanel panel = new JPanel();
        searchButton = new JButton("Search Files!");

        
        //heading
        heading = new JLabel("Welcome to Topic Modeller! Enter 3 different files To see if they are related!");
        heading.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        
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
        
        /*JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("/User/dylan"));
         
        int result = jFileChooser.showOpenDialog(new JFrame());
     
     
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }*/
        
        searchButton.addActionListener(this);
        file1Text.addActionListener(this);
        file2Text.addActionListener(this);
        file3Text.addActionListener(this);
	
        
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
   
    public FileChooser() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed (ActionEvent e1) {
    	//getting text from textfield
    	String file1 = file1Text.getText();
    	String file2 = file2Text.getText();
    	String file3 = file3Text.getText();
    	
    	
    	try {
    		//creating instance of FileManager class to display Hashmap
    		FileManager fm = new FileManager(file1);
    		
    		fm.connectToFile();//connecting to file
    		wordMap = fm.getWords();
    		wordMap.forEach((key, value) -> totalWords.merge(key, value, (v1, v2) -> v1+v2));
    		JTable table = setTable(wordMap);
    		fm.closeFile();
    	
    		
    		//creating a new instance fro file2
    		FileManager fm1 = new FileManager(file2);
    		
    		fm1.connectToFile();//connecting to file
    		wordMap = fm1.getWords();
    		wordMap.forEach((key, value) -> totalWords.merge(key, value, (v1, v2) -> v1+v2));
    		JTable table2 = setTable(wordMap);
    		fm1.closeFile();
	
    		
    		//creating a new instance for file3
    		FileManager fm2 = new FileManager(file3);
    		
    		fm2.connectToFile();//connecting to file
    		wordMap = fm2.getWords();
    		
    		//
    		wordMap.forEach((key, value) -> totalWords.merge(key, value, (v1, v2) -> v1+v2));
    		JTable table3 = setTable(wordMap);

    		//closing file 
    		fm2.closeFile();
    		
    		
    		FileManager tw = new FileManager(totalWords);
    		totalWords = tw.sortMap(totalWords);
    		JTable table4 = setTable(totalWords);
	        System.out.println(totalWords);
    		totalWords.clear();
    		
    		@SuppressWarnings("unused")
			FileResults f1 = new FileResults(table, table2, table3, table4);
    		
    		
    		
    	}//end try 
    	
    	
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(this, "Error: Please Enter 3 Files to Compare with eachother!");
    		System.out.println(e);
    	}//end catch 
    	
  
    }//end actionPerformed
    
    public JTable setTable(HashMap<String, Integer> wordMap) {
    	
    	//setting the header title names
    	DefaultTableModel tableModel = new DefaultTableModel(
    		new Object[] { "Word", "Count" }, 0
    	);
    	
    	int row=0;
    	//Entering Data into rows based off first 5 rows of sorted hash map
    	for (Map.Entry<String, Integer> entry : wordMap.entrySet()) 
    	{
    		//ensuring the table ony has four rows
    		if (row!=8) 
    		{
    	        tableModel.addRow(new Object[] { entry.getKey(), entry.getValue() });
    	        row++;
    	    }//end if
        }//end for
    	
    	
    	//creating a table based off the table Model
    	JTable table = new JTable(tableModel);
    
   		return table;
    }
	
}//end class

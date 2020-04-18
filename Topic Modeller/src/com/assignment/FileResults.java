/***********
 * This class is the GUI for displaying the results of the files
 * This class displays most common words of the files in 3 tables
 * Followed by a percentage that is produced based on the number of words that overlap
 * You can reset or confirm the results, if reset reults will be recalculated
 * If confirmed the resulst will be written to a file called results.txt
 * 
 * Author: Dylan O'Connor
 * Date Started: 30/04/2020
 * End Date: 20/04/2020
 **********/

package com.assignment;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;


public class FileResults extends JFrame implements ActionListener{
	
	//attributes
	JFrame frame;
	JPanel centrePanel, northPanel, southPanel;
	JLabel headingLabel;
	JTextField stopText;
	JButton enterStop, reset, confirm;
	JTable table, table2, table3, table4;
	HashMap<String, Integer>finalOverLap = new HashMap<String,Integer>();
	float grade;
	
	private static final long serialVersionUID = 1L;

	//constructor
	public FileResults(JTable table, JTable table2, JTable table3) {
		
		//Setting table values
		this.table = table;
		this.table2 = table2;
		this.table3 = table3;
		
		//creating new jframe and jpanel
		frame = new JFrame();
        JPanel panel = new JPanel();

        //creating first layout which is a border layout
        BorderLayout bl1 = new BorderLayout();
		getContentPane().setLayout(bl1);
		
		//heading label displayed at the top of the page
		headingLabel = new JLabel("Results are as follows based on the top 8 words from each file!");
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Labels on display
		JLabel file1Results = new JLabel("File 1 Results:       ");
		JLabel file2Results = new JLabel("File 2 Results:       ");
		JLabel file3Results = new JLabel("File 3 Results:       ");
		
		//creating a line break, not efficient but effective
		JLabel space = new JLabel("                      ");
		
		
		stopText = new JTextField(15);
		JLabel stopWords = new JLabel("If a word from table is not informative, Enter Here to Remove and Recalculate:  ");
		enterStop = new JButton("Enter");
		reset = new JButton("Reset");
		reset.setBackground(Color.red);
		reset.setForeground(Color.white);
		
		confirm = new JButton("Confirm");
		
		//Centering stopWords text field
		stopWords.setHorizontalAlignment(SwingConstants.CENTER);

		//setting heading label to the top of the window
		frame.getContentPane().add(BorderLayout.NORTH, headingLabel);
 
        //Setting up gridlayout
        panel.setLayout(new GridBagLayout());
        frame.getContentPane().add(panel);
        
        //leftside elements constraints
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        
        //right side elements constraints
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
        
        //south elemenets constraints
        GridBagConstraints south = new GridBagConstraints();
        south.weightx = 1.0;
        center.anchor=GridBagConstraints.SOUTH;
        south.fill = GridBagConstraints.HORIZONTAL;
        south.gridwidth = GridBagConstraints.REMAINDER;
        
        //creating scrollable view so tables display correctly
        JScrollPane sp = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(getDimension(table));
        
        JScrollPane sp1 = new JScrollPane(table2);
        table2.setPreferredScrollableViewportSize(getDimension(table2));
        
        JScrollPane sp2 = new JScrollPane(table3);
        table3.setPreferredScrollableViewportSize(getDimension(table3));

        //Adding action listeners to buttons and textfields
        stopText.addActionListener(this);
        enterStop.addActionListener(this);
        reset.addActionListener(this);
        confirm.addActionListener(this);
        
       //Creating an instace of analyse 
       //call overlapping method to get overlapping words and percentage
        Analyse a1 = new Analyse(table);
		a1.getOverlap(table);
	    a1.getOverlap(table2);
	    HashMap<String, Integer> finalOverLap = a1.getOverlap(table3);
	    
	    //System.out.println("FO: "+finalOverLap);
	    grade = a1.overLapPercentage(finalOverLap);

	    //Labels Explain Grading system
	    JLabel gradeLabel = new JLabel("Based on the Overlapping of the Top 8 words from each file, a grade has ");
	    JLabel gradeLabel2 = new JLabel("been estimated that these  ");
	    JLabel gradeLabel3 = new JLabel("Grade: "+grade+"% ");
	    JLabel gradeLabel4 = new JLabel("files are Likely to be about the same topic!");
	    //Centering grade Label with borders
	    gradeLabel3.setHorizontalAlignment(SwingConstants.CENTER);
	    gradeLabel3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	    gradeLabel3.setForeground(Color.blue);
	   
        
	    
        //displaying elemenst on panel
        panel.add(file1Results, left);
        panel.add(sp, right);
        panel.add(file2Results, left);
        panel.add(sp1, right);
        panel.add(file3Results, left);
        panel.add(sp2, right);
        
        panel.add(gradeLabel, center);
        panel.add(gradeLabel2, left);
        panel.add(gradeLabel4, right);
        panel.add(gradeLabel3, south);
        
        panel.add(space, center);
        panel.add(stopWords, center);
        panel.add(stopText, left);
        panel.add(enterStop, right);
        panel.add(space, south);
        panel.add(reset, south);
        panel.add(confirm, south);


        //setting border around center so items are spread out
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        //sizing window to the default size
        //so that elements fit on screen best
        frame.pack();
        frame.setVisible(true); 

        
       
       
	}
	 @Override
	public void actionPerformed (ActionEvent e1) {
		 
		if(e1.getSource() == enterStop) {
			//getting stop word entered
			String wordEntered = stopText.getText();
			StopWords sw = new StopWords();
			sw.connectToFile();//connection to file
			sw.printToFile(wordEntered);//method to print word to file
			//clearing textfield after entered
			stopText.setText(null);//clearin text afterwards
			JOptionPane.showMessageDialog(this, "Click Reset to see new results!");

		}//end if
		
		else if(e1.getSource() == reset) {
			//losing frame to see new result
			frame.dispose();
		}//enbd if
		
		else if(e1.getSource() == confirm) {
			//Creating instace of resultwriter class to call method
			ResultWriter rw = new ResultWriter();
			rw.writeToFile(table, table2, table3, table4, grade);//passing params to be written to file
			JOptionPane.showMessageDialog(this, "Results Written to File named \"results.txt\"");
			frame.dispose();
		}
	}//end actionPerformed
	
	
	//function that sets the dimension of the container 
	//containing the scrollable view
	public Dimension getDimension(JTable table) {
		//
		int numOfVisibleRows = 5;

        int cols = table.getColumnModel().getTotalColumnWidth();//num of cols
        int rows = table.getRowHeight() * numOfVisibleRows;//num of rows
        Dimension dim = new Dimension(cols, rows);//setting dimension
		return dim;
	}//end getDimension
}//end class
/***********
 * 
 * Author: Dylan O'Connor
 * TBD
 **********/

package com.assignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FileResults extends JFrame implements ActionListener{
	
	//attributes
	JFrame frame;
	JPanel centrePanel, northPanel, southPanel;
	JLabel headingLabel;
	private static final long serialVersionUID = 1L;

	//constructor
	public FileResults(JTable table, JTable table2, JTable table3) {
		
		frame = new JFrame();
        JPanel panel = new JPanel();

        BorderLayout bl1 = new BorderLayout();
		getContentPane().setLayout(bl1);
		
		headingLabel = new JLabel("Results are as Follows: ");
		headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel file1Results = new JLabel("File 1 Results:       ");
		JLabel file2Results = new JLabel("File 2 Results:       ");
		JLabel file3Results = new JLabel("File 3 Results:		");
		
		frame.getContentPane().add(BorderLayout.NORTH, headingLabel);
 
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
        

        panel.add(file1Results, left);
        panel.add(table, right);
        panel.add(file2Results, left);
        panel.add(table2, right);
        panel.add(file3Results, left);
        panel.add(table3, right);
        
        /*panel.add(file3Results, left);
        panel.add(file3Text, right);
        */
        //setting border around center so items are spread out
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        //sizing window to the default size
        //so that elements fit on screen best
        frame.pack();
        frame.setVisible(true); 
        
		
		
	}
	
	public void actionPerformed (ActionEvent e1) {
		//todo
	}
}//end class
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
	JFrame frame2;
	JPanel centrePanel, northPanel, southPanel;
	JTable table2;
	JTable table3;
	JLabel headingLabel;
	private static final long serialVersionUID = 1L;

	//constructor
	public FileResults(JTable table2, JTable table3) {
		
		frame2 = new JFrame();
        JPanel centrePanel = new JPanel();
        JPanel northPanel = new JPanel();
        
        BorderLayout bl1 = new BorderLayout();
		setLayout(bl1);
		
		headingLabel = new JLabel("Results are as Follows: ");
		
		setSize(500,500);
		
		centrePanel.add(table2);
		centrePanel.add(table3);
		northPanel.add(headingLabel);
		
		//adding elements to panel
		add(centrePanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		
	
	}
	
	public void actionPerformed (ActionEvent e1) {
		//todo
	}
}//end class
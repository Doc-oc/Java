package com.assignment;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class FileResults extends FileChooser {
	
	private static final long serialVersionUID = 1L;
	//
	JLabel resultsLabel;
	JPanel panel;
	//
	public FileResults(String myTitle) {
		super(myTitle);
		//JFrame frame = new JFrame();
		panel = new JPanel();
		
		BorderLayout b1 = new BorderLayout();
		setLayout(b1);
		setSize(500,500);
		
		resultsLabel = new JLabel("Results: ");
		
		panel.add(resultsLabel);
		add(panel, BorderLayout.NORTH);
		
		//searchButton.addActionListener(this);
		setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e1) {
		
		
	}
}
/*****
 * 
 * 
 * Author: Dylan O'Connor
 * Start Date: 30/03/2020
 * End Date: 
 */
package com.assignment;

//APIS
import javax.swing.*;
import java.awt.*;

public class FileChooser extends JFrame {
	
	//Attributes
	private static final long serialVersionUID = 1L;
	JPanel centerPanel, center2Panel, southPanel, northPanel;
	JButton searchButton;
	JLabel heading, file1, file2, file3;
	JTextField FirstField, SecField, ThirdField;
	public static final String NL = System.getProperty("line.separator");
	public FileChooser(String myTitle) {
		super(myTitle);
		
		//Setting Border Layout
		BorderLayout BL1 = new BorderLayout();
		setLayout(BL1);
		setSize(500,500);
		
		
		//creating screen elements
		heading = new JLabel("Enter The Name of the files below:");
		file1 = new JLabel("\n1.");
		FirstField = new JTextField("                        ");
		
		file2 = new JLabel("2. ");
		SecField = new JTextField("                        ");
		
		file3 = new JLabel("3. ");
		ThirdField = new JTextField("                        ");
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel = new JPanel();
		center2Panel = new JPanel();
		
		//Adding UI Elements to Panels
		northPanel.add(heading);
		centerPanel.add(file1);
		centerPanel.add(FirstField);
		centerPanel.add(file2);
		centerPanel.add(SecField);
		centerPanel.add(file3);
		centerPanel.add(ThirdField);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);

		
		setVisible(true);
	}
}

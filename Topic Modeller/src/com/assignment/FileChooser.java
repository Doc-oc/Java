package com.assignment;

import javax.swing.*;
import java.awt.*;

public class FileChooser extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JLabel heading, fileLabel1, fileLabel2, fileLabel3;
	JButton searchButton; 
	JTextField file1Text, file2Text, file3Text;
	

    public FileChooser (String myTitle) {
    	super(myTitle);
    	
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        searchButton = new JButton("Search Files!");

        heading = new JLabel("Welcome to Topic Modeller!  Enter File names to check if they are related!");
        
        fileLabel1 = new JLabel("File Name: ");
        fileLabel2 = new JLabel("File Name: ");
        fileLabel3 = new JLabel("File Name: ");
        
        file1Text = new JTextField(20);
        file2Text = new JTextField(20);
        file3Text = new JTextField(20);

        frame.getContentPane().add(BorderLayout.NORTH, heading);
        frame.getContentPane().add(BorderLayout.SOUTH, searchButton);
        

        panel.setLayout(new GridBagLayout());
        frame.getContentPane().add(panel);
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;
        
        
        panel.add(fileLabel1, left);
        panel.add(file1Text, right);
        panel.add(fileLabel2, left);
        panel.add(file2Text, right);
        panel.add(fileLabel3, left);
        panel.add(file3Text, right);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        frame.pack();
        frame.setVisible(true);
    }

}

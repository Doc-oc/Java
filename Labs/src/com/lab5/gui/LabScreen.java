/***********
 * Lab 5 - Working with GUI
 * 27/02/2020
 * Author : Dylan O'Connor
 **********/

package com.lab5.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LabScreen extends JFrame implements ActionListener, MouseListener{
	
	//Attributes 
	JTextField field1;
	JLabel label1, label2, label3;
	JButton button1, button2;
	JPanel centrePanel, southPanel, northPanel, centrePanelBelow;
	private static final long serialVersionUID = 1L;
	
	public LabScreen(String myTitle) {
		super(myTitle);
		
		BorderLayout bl1 = new BorderLayout();
		setLayout(bl1);
		
		field1 = new JTextField("Name");
		//label1 = new JLabel("Lab 5 - 27/02/20");
		label2 = new JLabel("Enter Name: ");
		label3 = new JLabel("Panel Here");
		button1 = new JButton("Submit");
		button2 = new JButton("Submit Again");
		

		//Setting size of Window
		setSize(500,500);
	
		
		//Action Listeners
		button1.addActionListener(this);
		button2.addActionListener(this);
		field1.addActionListener(this);
		
		//Set up Panels
		southPanel = new JPanel();
		centrePanel = new JPanel();        
		northPanel = new JPanel();
		
		centrePanel.setBackground(Color.RED);
		
		//Mouse Listener
		centrePanel.addMouseListener(this);
		
        // set tooltip text 
        field1.setToolTipText("Enter Name here"); 

		//Adding GUI Elements
		southPanel.add(button1);
		southPanel.add(button2);
		//northPanel.add(label1);
		centrePanel.add(label3);
		northPanel.add(label2);
		northPanel.add(field1);
		
		//Setting elements positions on screen
		add(southPanel, BorderLayout.SOUTH);
		add(centrePanel,BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		
		
		
		//Setting Visibility
		setVisible(true);
	}	
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//Setting input text value
		String textEntered = field1.getText();
		
		if(arg0.getSource() == button1) {
			JOptionPane.showMessageDialog(this, "You entered " + textEntered);
		}
		else if(arg0.getSource() == button2) {
			JOptionPane.showMessageDialog(this, "You clicked Submit again");
		}
		
		
	}
	
	
	public void mouseEntered(MouseEvent e) {
		JOptionPane.showMessageDialog(this, "Mouse entered");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == 1) {
			JOptionPane.showMessageDialog(this, "Left Click!");
		}
		else if(e.getButton() == 3) {
			JOptionPane.showMessageDialog(this, "Right Click!");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JOptionPane.showMessageDialog(this, "Mouse exited");
		
	}
}








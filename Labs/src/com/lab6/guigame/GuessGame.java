/************
 * Guessing Game that allows user to generate random number
 * User guesses number until they are correct
 * 
 * Author: Dylan O'Connor
 * Date: 05/03/2020
 ***********/

package com.lab6.guigame;

// APIS
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GuessGame extends JFrame implements ActionListener {
	
	
	//Attributes
	JPanel centerPanel, southPanel, northPanel;
	JButton generate, check;
	JTextField guess;
	JLabel guessLabel;
	int result=0;
	int count =0;
	private static final long serialVersionUID = 1L;
	
	//Constructor 
	public GuessGame(String myTitle) {
		super(myTitle);
		
		BorderLayout bl1 = new BorderLayout();
		setLayout(bl1);
		
		setSize(500,500);
		
		//creating screen elements
		generate = new JButton("Generate Random Number");
		check = new JButton("Check Your Guess!");
		guess = new JTextField("Enter Guess");
		guessLabel= new JLabel("Your Guess: ");
		check.setEnabled(false);
		
		//Setting up panels
		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel = new JPanel();
		
		//Adding UI Elements to Panels
		northPanel.add(generate);
		centerPanel.add(guessLabel);
		centerPanel.add(guess);
		southPanel.add(check);
		
		
		generate.addActionListener(this);
		guess.addActionListener(this);
		check.addActionListener(this);
		

		
		//Setting up Panels
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		//setting visibility of GUI to true
		setVisible(true);
		
	}//end constructor
	
	
	public void actionPerformed(ActionEvent e1) {
		
		int guessEntered = 0;
		Random number = new Random();
		
		//if user clicks generate button
		if(e1.getSource() == generate) {
			result = number.nextInt(100);
			JOptionPane.showMessageDialog(this, result);
			check.setEnabled(true);
		}
		
		
		//If user clicks check button
		if(e1.getSource() == check) {
			count++;
			
			try {
				guessEntered = Integer.parseInt(guess.getText().trim());
				
				if(guessEntered == result) {
					JOptionPane.showMessageDialog(this, "Correct!\nIt took you " + count + " guesses!");
				}//end if
				else if (guessEntered > result){
					JOptionPane.showMessageDialog(this, "Too High, Guess Again");
				}//end else if
				else if(guessEntered < result) {
					JOptionPane.showMessageDialog(this, "Too Low, Guess Again!");
				}//end else if
			}//end try
			
			catch(NumberFormatException ne1){
				JOptionPane.showMessageDialog(this, "You must enter number");
			}//end catch
			
	
		}//end if get source	
	}// end actionPerformed
}//end class










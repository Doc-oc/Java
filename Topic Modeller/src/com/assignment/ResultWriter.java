package com.assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.io.PrintWriter;

import javax.swing.JTable;

public class ResultWriter {
	
	JTable table5;
	File file;
	public ResultWriter(){
		
	}//end 

	public void writeToFile(JTable table, JTable table2, JTable table3, JTable table4, float grade) {
		try {

			file = new File("results.txt");
				if(!file.exists()) {
					file.createNewFile();
				}
			
	
			FileWriter f1 = new FileWriter(file, false);
			BufferedWriter b1 = new BufferedWriter(f1);
			
			//File 1 Resultrs
			b1.write("Results calculated by Topic Modeller! \n");
			b1.write("Displaying the 8 Most frequent words from each file plus final grade! \n");
			b1.write("\nFile1: ");
			for (int row = 0; row < table.getRowCount(); row++) {
				b1.write("\n");
			    for (int col = 0; col < table.getColumnCount(); col++) {
					if (table.getValueAt(row, col) != null) {
						b1.write(table.getValueAt(row, col) + "\t" );
					}
				}//end j for
			}//end i for
		
			//File 2 Results
			b1.write("\n");
			b1.write("\nFile2: ");
			for (int row = 0; row < table2.getRowCount(); row++) {
				b1.write("\n");
			    for (int col = 0; col < table2.getColumnCount(); col++) {
					if (table2.getValueAt(row, col) != null) {
						b1.write(table2.getValueAt(row , col) + "\t" );
					}
				}//end j for
			}//end i for
			
			//File 3 resuts
			b1.write("\n");
			b1.write("\nFile3: ");
			for (int row = 0; row < table3.getRowCount(); row++) {
				b1.write("\n");
			    for (int col = 0; col < table3.getColumnCount(); col++) {
					if (table3.getValueAt(row, col) != null) {
						b1.write(table3.getValueAt(row, col) + "\t" );
					}
				}
			}
			
			//total results
			b1.write("\n");
			b1.write("\nGrade of how likely these files are to be about the same topic:  " + grade + "%");
			
			
			//closing writers
			b1.close();
			f1.close();
			
	
			
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}//end catch
	}//
}//end class

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
	
	//connecting to a file
	public File connectToFile() {
	try {
			file = new File("results.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch(Exception e) {
			System.out.print("File"+e);
		}
	
		return file;
	}//end connectToFile
		

	public void writeToFile(JTable table) {
		try {

			file = new File("results.txt");
				if(!file.exists()) {
					file.createNewFile();
				}
			
	
			FileWriter f1 = new FileWriter(file, true);
			BufferedWriter b1 = new BufferedWriter(f1);
			PrintWriter newLine = new PrintWriter(b1);
			
			for (int row = 0; row < table.getRowCount(); row++) {
			    for (int col = 0; col < table.getColumnCount(); col++) {
					if (table.getValueAt(row, col) != null) {
						newLine.println(table.getValueAt(row, col)+"\t");
						
					}
				}
			}
			newLine.close();
			
	
			
		} catch(Exception e) {
			e.printStackTrace();;
		}//end catch
	}//
}//end class

/*******
 * Class that manages the connectivity and reading of files
 * Author: Dylan O'Connor  
 * 
 ****/

package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
	//attribites
	String fileName;
	File file;
	Scanner input;
	
	//constructor
	public FileManager(String fileName) {
		this.fileName = fileName;
	}
	
	//connecting to a file
	void connectToFile() {
		file = new File(fileName);
	}
	
	@SuppressWarnings("finally")
	String[] readFile() {
		String[] values = new String[6];
		try
		{
			
	    	int i = 0;
	    	input = new Scanner(file); 
	    	
	    	//reading lines from file
			 while(input.hasNextLine())
			    {
			      
				 values[i] = input.nextLine();
			     i++;
			    }//end while
		}//end try
		catch (FileNotFoundException e)
		{
			System.out.println("Error: " + e.getMessage());
		}//end catch
	    finally
	    {
			return values;
	    }
	}//end ReadFile
	
	 void closeReadFile(){
		input.close();
	 }
}

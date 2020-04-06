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
	File file1;
	Scanner input;
	
	public FileManager(String fileName) {
		this.fileName = fileName;
	}
	
	void connectToFile() {
		file1 = new File(fileName);
	}
	
	@SuppressWarnings("finally")
	String[] readFile() {
		String[] values = new String[6];
		try
		{
	    	int i = 0;
	    	input = new Scanner(file1); 
			 while (input.hasNextLine())
			    {
			      
				 values[i] = input.nextLine();
			      i++;
			    }
		}
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}
	    finally
	    {
	        return values;
	    }
	}
	
	 void closeReadFile(){
		input.close();
	 }
}

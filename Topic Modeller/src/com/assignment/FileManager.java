/*******
 * Class that manages the connectivity and reading of files
 * Author: Dylan O'Connor  
 * 
 ****/

package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileManager {
	//attribites
	String fileName;
	File file;
	Scanner input;
	HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();
	
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
	
	
	//gettigs words into hash map
	@SuppressWarnings("finally")
	public HashMap<String, Integer> getWords() {
		try {
			input = new Scanner(file);
			
			while(input.hasNext()) {
				String word = input.next();
				if(wordFreq.containsKey(word)) {
					//
					int counter = wordFreq.get(word)+ 1;
					wordFreq.put(word, counter);
				}//end if
				else {
					wordFreq.put(word,  1);
				}//end else
			}//end while
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error: " + e.getMessage());
		}//end catch
	    finally
	    {
	    	for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
	    		System.out.print(entry+"\n");
	    	}
	    	
	    	return wordFreq;
	    }
		
	}
	 void closeReadFile(){
		input.close();
	 }
}

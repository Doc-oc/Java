/*******
 * Class that manages the connectivity and reading of files
 * Author: Dylan O'Connor  
 * 
 ****/

package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;


public class FileManager {
	//attribites
	String fileName; 
	File file;
	Scanner input;
	HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();
	HashMap<String, Integer> sortedMap = new HashMap<String, Integer>();
	
	//constructor
	public FileManager(String fileName) {
		this.fileName = fileName;
	}
	
	//connecting to a file
	void connectToFile() {
		file = new File(fileName);
	}
	
	
	
	//gettigs words into hash map
	@SuppressWarnings("finally")
	public HashMap<String, Integer> getWords() {
		
		
		try {
			//Scan File
			input = new Scanner(file);
			
			
			//Get words from file
			while(input.hasNext()) {
				String word = input.next();
				//if Hash Map already has word increment counter
				if(wordFreq.containsKey(word)) {
					int counter = wordFreq.get(word)+ 1;
					wordFreq.put(word, counter);
				}//end if
				else {
					wordFreq.put(word,  1);
				}//end else
			}//end while
			
		}//end try
		
		
		catch (FileNotFoundException e)
		{
			System.out.println("Error: " + e.getMessage());
		}//end catch
		
		
	    finally
	    {
	    	return wordFreq;
	    }//end finally
		
	}
	
	 void closeFile(){
		input.close();
	 }


}

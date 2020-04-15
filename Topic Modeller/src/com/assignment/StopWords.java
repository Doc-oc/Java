package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class StopWords {
	
	//attributwes 
	HashMap<String, Integer> words;
	File stopWords;
	Scanner input;
	String stopEntered;


	//Constructor
	public StopWords(HashMap<String, Integer> words){
		this.words = words;

	}//End StopWords
	
	
	// get a connection to the file
		public File connectToFile()
		{
			stopWords = new File("stopwords.txt");
			return stopWords;
		}
	
	@SuppressWarnings("finally")
	public HashMap<String, Integer> getStopWords(int total) {
		String[] stopwords = new String[450];
		
	    try
		{
	    	int i = 0;
	    	input = new Scanner(connectToFile()); 
			while(input.hasNextLine())  
			 {  
				stopwords[i] = input.nextLine();
				if(words.containsKey(stopwords[i])) {
					words.remove(stopwords[i]);
					total = total - 1;
				}
				
			    i++;
			 }//end while
		}//end try
	    
		catch (FileNotFoundException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	    finally
	    {
	    	System.out.println(stopwords);
	        return words;
	    }//end finally
    }//end getStopWords()
	
	
}//end class
    

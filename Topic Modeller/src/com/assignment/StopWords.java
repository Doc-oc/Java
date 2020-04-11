package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StopWords {
	
	HashMap<String, Integer> words;
	File stopWords;
	Scanner input;

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
	public HashMap<String, Integer> getStopWords() {
		String[] stopwords = new String[430  ];
		
	    try
		{
	    	int i = 0;
	    	input = new Scanner(connectToFile()); 
			while(input.hasNextLine())  
			 {  
				stopwords[i] = input.nextLine();
				if(words.containsKey(stopwords[i])) {
					words.remove(stopwords[i]);
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
	        return words;
	    }//end finally
    }//end getStopWords()
	
}//end class
    

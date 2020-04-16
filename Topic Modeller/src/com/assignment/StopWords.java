package com.assignment;

import java.io.BufferedWriter;
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
	
	
	public StopWords() {
		//todo
	}


	// get a connection to the file
	public File connectToFile()
	{
		stopWords = new File("stopwords.txt");
		return stopWords;
	}
	
	@SuppressWarnings("finally")
	public HashMap<String, Integer> getStopWords(int total) {
		String[] stopwords = new String[550];
		
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
		}//end catch
	    finally
	    {
	    	
	        return words;
	    }//end finally
    }//end getStopWords()
	
	
	public void printToFile(String wordEntered) {
		try {
			
			//Using File, Print Writer to write new stop words to file
		    FileWriter f1 = new FileWriter(stopWords, true);
		    BufferedWriter b1 = new BufferedWriter(f1);
		    PrintWriter newLine = new PrintWriter(b1);
		    newLine.println(wordEntered);
		    newLine.close();
		    
		}//end try 
		catch (IOException e1) 
		{
			//exception handling left as an exercise for the reader
			System.out.println("Error: "+ e1);
		}//end catch
	}//end printtoFile()
}//end class
    

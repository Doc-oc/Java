/*******
 * Class that manages the connectivity and reading of files from fileChooser class
 * Class uses hashmaps to count words from files 
 * Key , value was the best way that I could do this
 * This class also sorts the hashmap into descending order
 * 
 * Author: Dylan O'Connor  
 * Start Date: 30/03/2020
 * End Date: 20/04/2020
 ****/

package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import static java.util.stream.Collectors.*;

public class FileManager implements Comparator<Object> {
	//attribites
	String fileName; 
	File file;
	Scanner input;
	HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();
	HashMap<String, Integer> sortCount= new HashMap<String, Integer>();
	HashMap<String, Integer> totalWords = new HashMap<String , Integer>();
	int total=0;
	
	//constructors
	public FileManager(String fileName) {
		this.fileName = fileName;

	}
	
	public FileManager(HashMap<String, Integer>totalWords) {
		this.totalWords = totalWords;
	}
	
	//method needed for compare<object>
	public int compare(Object o1, Object o2) {
	
		return 0;
	}//
	
	//connecting to a file
	void connectToFile() {
		file = new File(fileName);
	}
	
	
	
	//gettigs words into hash map
	@SuppressWarnings({ "finally" })
	public HashMap<String, Integer> getWords() {
		try {
			//Scan File
			input = new Scanner(file);
			
			//Get words from file
			while(input.hasNext()) {
				String word = input.next();
				word = word.toLowerCase();
				
				//removing punctuation
				if(word.startsWith("“")) {
					word = word.replace(("“"), "");
				}
				else if (word.endsWith("”")){
					word = word.replace("”", "");
				}
				else if(word.endsWith(".")) {
					word = word.replace(".", "");
				}
				else if(word.endsWith(",")) {
					word = word.replace(",", "");
				}
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
			//displayig error
			System.out.println("Error: " + e.getMessage());
		}//end catch
		
		
	    finally
	    {

	    	//System.out.println(sortMap(wordFreq));
			return sortMap(wordFreq); 
		      
	    }//end finally
		
	}//end getWords()
	
	//for this function I did some research into hashmaps and how they work 
	//I bought a java book and did online research on websites such as geeksforgeek etc.
	//
	//this is the code that I could come up with to sort an array based off the stuff I learned
	//There is probably a more efficient way of doing this but this was the best I could do
	public HashMap<String, Integer> sortMap(HashMap<String, Integer> wordCount){
		
		//sorting hash map in descending order
		sortCount = wordCount.entrySet().stream()
				//comparing values in reversed order
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				//collect entries plus displaying them in new order which is descending
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		//System.out.println("Before stop Words: "+total);
		
		//creating instace of stopwords
		StopWords s1 = new StopWords(sortCount);
		s1.getStopWords();//passing sorted map to remove stop words
		
		//
		return sortCount;
	}//end sortMap
	
	//close file 
	 void closeFile(){
		input.close();
	 }//end closeFile
	 
}//end FileManager

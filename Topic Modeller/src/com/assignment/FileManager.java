/*******
 * Class that manages the connectivity and reading of files
 * Author: Dylan O'Connor  
 * 
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
	
	//constructorS
	public FileManager(String fileName) {
		this.fileName = fileName;

	}
	
	public FileManager(HashMap<String, Integer>totalWords) {
		this.totalWords = totalWords;
	}
	

	public int compare(Object o1, Object o2) {
	
		return 0;
	}
	
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

	    	//System.out.println(sortMap(wordFreq));
			return sortMap(wordFreq); 
		      
	    }//end finally
		
	}//end getWords()
	
	//for this function I did some research into hashmaps and how they work 
	//this is what I could come up with to sort an array
	public HashMap<String, Integer> sortMap(HashMap<String, Integer> wordCount){
		//sorting hash map in descending order
		sortCount = wordCount.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		//System.out.println("Before stop Words: "+total);
		
		//creating instace of stopwords
		StopWords s1 = new StopWords(sortCount);
		s1.getStopWords(total);
		
		return sortCount;
	}
	
	
	 void closeFile(){
		input.close();
	 }//end closeFile
}

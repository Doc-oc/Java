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
	
	//constructorS
	public FileManager(String fileName) {
		this.fileName = fileName;
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
			int total = 0;
			
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
				total++;
			}//end while
			
			//sorting hash map in descending order
			sortCount = wordFreq.entrySet()
					.stream()
					.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
					.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
			
			System.out.println("Before stop Words: "+total);
			//creating instace of stopwords
			StopWords s1 = new StopWords(sortCount);
			
			s1.getStopWords(total);
			
			
		}//end try
		
		
		catch (FileNotFoundException e)
		{
			System.out.println("Error: " + e.getMessage());
		}//end catch
		
		
	    finally
	    {
	    	//System.out.println(sortCount);
			return sortCount; 
		      
	    }//end finally
		
	}//end getWords()
	
	
	 void closeFile(){
		input.close();
	 }//end closeFile
}

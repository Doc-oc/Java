/****
 * 
 * 
 * 
 ***/
package com.assignment;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Analyse extends FileChooser {

	private static final long serialVersionUID = 1L;
	//attributes 
	
	HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();
	//constructors
	public Analyse(String myTitle) {
		super(myTitle);
	}
	
	public void getWords() {

		for (String word : words) {
			Integer count = wordFreq.get(word);
			if (count == null) {
				count = 0;
			}
			wordFreq.put(word, count + 1);
		}
	}
	

 
}//end Analyse 

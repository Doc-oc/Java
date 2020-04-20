
package com.assignment;

/*******
 * This class Analyses the overlapping of words based on the tables of most common words
 * A percentage is produced based on the number of words that overlap eachother
 * This percentage is the grade of likelihood that the files are related
 *
 * Author: Dylan O'Connor
 * Start Date: 30/03/2020
 * End Date: 20/04/2020
 *******/

import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;


public class Analyse {
	
	//attributes
	JTable table;
	JTable table1;
	HashMap<String , Integer> overLap = new HashMap<String, Integer>();
	
	//constructors
	public Analyse(JTable table){
		this.table = table;
	}
	
	public HashMap<String , Integer> getOverlap(JTable table) {
		
		//iterating throw the table based on the rows
		for (int row = 0; row < table.getRowCount(); row++){
			//Adding words from the table to the overlapping map, and a counter of each word
			if(overLap.containsKey(table.getValueAt(row, 0))) {
				int counter = overLap.get(table.getValueAt(row, 0))+ 1;
				overLap.put(table.getValueAt(row, 0).toString(), counter);
			}//end if
			else {
				overLap.put( table.getValueAt(row, 0).toString(), 1);
			}//end else
		}
		
		//System.out.println("OverLap: "+overLap);
		
		return overLap;
	}//end getOverlap
	
	
	//method that calculates the overlap percentage
	public float overLapPercentage(HashMap<String, Integer>overlap) {
		
		float counter=0;
		float overlapPercent=0;
		
		//counting if words overlap eachother
		for (Map.Entry<String, Integer> entry : overlap.entrySet()) {
			if(entry.getValue() >= 2) {
				counter = counter + 1;
			}//end if
		}//end for
		
		//number of overlaps divided by the size of remainder of the map
		//multiplied by 100 to get perecentage
		overlapPercent = ((counter / overlap.size())*100);
		
		return overlapPercent;
	}
}//end Analyse 

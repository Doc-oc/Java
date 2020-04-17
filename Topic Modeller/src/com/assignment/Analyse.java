/****
 * 
 * 
 * 
 ***/
package com.assignment;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;

//import java.util.Iterator;
//import java.util.Map;

public class Analyse {
	
	JTable table;
	JTable table1;
	HashMap<String , Integer> overLap = new HashMap<String, Integer>();
	public Analyse(JTable table){
		this.table = table;
	}
	
	public HashMap<String , Integer> getOverlap(JTable table) {
		
		for (int row = 0; row < table.getRowCount(); row++){
			if(overLap.containsKey(table.getValueAt(row, 0))) {
				int counter = overLap.get(table.getValueAt(row, 0))+ 1;
				overLap.put(table.getValueAt(row, 0).toString(), counter);
			}//end if
			else {
				overLap.put( table.getValueAt(row, 0).toString(), 1);
			}//end else
		}
		
		System.out.println("OverLap: "+overLap);
		
		return overLap;
	}
	
	public float overLapPercentage(HashMap<String, Integer>overlap) {
		
		float counter=0;
		float overlapPercent=0;
		
		for (Map.Entry<String, Integer> entry : overlap.entrySet()) {
			if(entry.getValue() >= 2) {
				counter = counter + 1;
				System.out.println(counter);
			}
		}
		
		overlapPercent = ((counter / overlap.size())*100);
		System.out.println(overlapPercent);
		
		return overlapPercent;
	}
}//end Analyse 

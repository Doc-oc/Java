package com.lab3.com;
/***************
 * Control Class for Employee
 * @author dylanoconnor
 *
 **********/

public class Control {
	
	public static void main(String []args) {
		
		int i=0;
		
		//object
		Employee newEmployee = new Employee("Dylan", "O'Connor", 18444694, 40000.0);
		System.out.println(newEmployee);
		
		//Print Hourly Employee
		HourlyEmployee hourEmployee = new HourlyEmployee("Mike", "John", 18111111, 0, 100.00, 10.10);
		System.out.println(hourEmployee);
		
		//printing monthly pay
		System.out.println("Monthly Pay: "+ Math.round(newEmployee.calculatePay()*100.0)/100.0 + "/Month");
		
		//Print out Sales Employee
		SalesEmployee salesEmp = new SalesEmployee("Liam", "Ross", 1789098, 15000.0, 30000);
		System.out.println(salesEmp);
		
		//new employee array
		Employee[ ] myEmployees = new Employee[30];
		
		while (i < 30){
			myEmployees[i] = newEmployee;
			i = i + 1;
			
			myEmployees[i] = hourEmployee;
			i = i + 1;
			
			myEmployees[i] = salesEmp;
			i = i + 1;
		}
		
		//printing employees pay
		System.out.println("\nEmployees Pay:");
		for(i=0;i<9;i++){
			System.out.println(myEmployees[i].calculatePay());
		}//end for
		
	}//end main
}//end control

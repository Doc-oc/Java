/***********************
 * Employee class
 * Author: Dylan O'Connor
 * 25/02/2020
 **********************/
package com.lab3.com;

class HourlyEmployee extends Employee {
	private double hoursWorked;
	private double hourlyRate;
	
	
	public HourlyEmployee(String firstName, String surName, int staffNumber, double annualSalary, double hoursWorked, double hourlyRate){
		super(firstName, surName, staffNumber, annualSalary);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
		
	}//end constructore


	//getters and setters
	public double getHoursWorked() {
		return hoursWorked;
	}


	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}


	public double getHourlyRate() {
		return hourlyRate;
	}


	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	
	public double calculatePay(){
		double totalPay = hoursWorked * hourlyRate;
		return totalPay;
	}
	
	public String toString(){
		
		String hourlyDetails = ("\n" + super.toString() + "\nHours Worked:" + hoursWorked + "\nHourly Rate: "+ hourlyRate + "\nTotal Pay:" + calculatePay());
		
		return hourlyDetails;
		
	}//end toString()
	
}//end hourlyEmployee class

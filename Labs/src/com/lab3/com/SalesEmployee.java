/***********************
 * Employee class
 * Author: Dylan O'Connor
 * 25/02/2020
 **********************/
package com.lab3.com;

class SalesEmployee extends Employee {
	//attributes
	private double commission;
	
	//constructor
	public SalesEmployee(String firstName, String surName, int staffNumber, double annualSalary, double commission) {
		super(firstName, surName, staffNumber, annualSalary);
		this.commission = commission;
	}//end constructor

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	public double calculatePay(){
		double netPay = commission + annualSalary;
		return netPay;
	}//end calculatePay()
	
	
	public String toString(){
		String salesDetails = ("\n" + super.toString() + "\nCommission: "+ commission + "\nNet Pay: " + calculatePay());
		return salesDetails;
	}//end toString

}//end class

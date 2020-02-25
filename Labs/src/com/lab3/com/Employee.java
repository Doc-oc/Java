package com.lab3.com;

public class Employee {
	
	//attributes
	private String firstName;
	private String surName;
	private int staffNumber;
	public double annualSalary;
	
	//constructor
	public Employee(String firstName, String surName, int staffNumber, double annualSalary) {
		this.firstName = firstName;
		this.surName = surName;
		this.staffNumber = staffNumber;
		this.annualSalary = annualSalary;
		
	}//end constructor
	
	//setters and getters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	
	public int getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}
	
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	public String toString(){
		
		String employeeDetails = "Name: " + firstName + "\nSurname: " + surName + "\nStaff Number: "+ staffNumber + "\nSalary: "+ annualSalary;
		
		return employeeDetails;
		
	}//end toString()
	
	public double calculatePay(){
		
		double monthlyPay = annualSalary/12;
		return monthlyPay;
		
	}//end CalculatePay
	
}// end class employee


















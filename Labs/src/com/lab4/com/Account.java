package com.lab4.com;

public class Account implements ValidatedAccount{
	//attributes
	private String accountName;
	private int accountNumber;
	private String sortCode;
	private String branchName;
	public boolean inCredit;
	public double acctBalance;
	private static int currentNumber = 1;
	
	public Account(String accountName, int accountNumber, String sortCode, String branchName, boolean inCredit, double acctBalance){
		this.accountName = accountName;
		this.setAccountNumber(currentNumber);
		this.setSortCode(sortCode);
		this.setBranchName(branchName);
		this.setInCredit(inCredit);
		this.setAcctBalance(acctBalance);
		
		currentNumber++;
	}
	
	//setters and getters
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public boolean isInCredit() {
		return inCredit;
	}

	public void setInCredit(boolean inCredit) {
		this.inCredit = inCredit;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}
	
	//Printing strings 
	public String toString(){
		String accountDetails = "Account: " + accountName + "\nAccount Number: " + accountNumber + "\nSort Code: " + sortCode + "\nBranch: " + branchName + "\nCredit: " + inCredit + "\nBalance: " + acctBalance;
		return accountDetails;
	}
	
	//deposit method
	public double deposit(double depAmount){
		acctBalance = acctBalance + depAmount;
		return acctBalance;
	}//end deposit
	
	
	public double withdraw(double takeAmount){
		acctBalance = acctBalance - takeAmount;
		
		if(acctBalance < 0){
			inCredit = false;
		}
		
		return acctBalance;
	}
	
	/*public void getDetails() {
		System.out.println(accountName, acctBalance);
	}*/
	
	public void getDetails() {
		System.out.println("\nAccount Name: " + accountName + "\nAccount Balance: " + acctBalance);
		
	}
	public void valuableAccount() {
		System.out.println("\nAccount Balance: " + acctBalance);
	}

	public int getCurrentNumber() {
		return currentNumber;
	}

	
}//end account class

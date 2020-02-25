package com.lab4.com;

class DepositAccount extends Account{
	private double interestRate;
	
	public DepositAccount(String accountName, int accountNumber, String sortCode, String branchName, boolean inCredit, double acctBalance, double interestRate){
		super(accountName, accountNumber, sortCode, branchName, inCredit, acctBalance);
		this.setInterestRate(interestRate);	
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public String withdraw(){
		String message = "You cannot withdraw from deposit Account!";
		return message;
	}
	
	
}//end Deposit Account

package com.lab4.com;

class CurrentAccount extends Account{
	
	private double penaltyAmount;
	
	//constructor
	public CurrentAccount(String accountName, int accountNumber, String sortCode, String branchName, boolean inCredit, double acctBalance ,double penaltyAmount) {
		super(accountName, accountNumber, sortCode, branchName, inCredit, acctBalance);
		this.penaltyAmount = penaltyAmount;
	}

	public double getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(double penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}
	
	public double withdraw(double takeAmount){
		if(takeAmount > acctBalance) {
			inCredit = false;
			System.out.println("Insufficient Funds");
		}
		else {
			acctBalance = acctBalance - takeAmount;
		}
		
		return acctBalance;
	}//end withdraw
	
	public String checkCredit(){
		String Credit;
		if(inCredit){
			Credit = "Account Balance is in Credit";
		}
		else {
			Credit = "Account Balance is not in Credit";
		}
		
		return Credit;
	}//end checkCredit
	
	public void checkCredit(String warningMessage){
		if(acctBalance < 100){
			System.out.println(warningMessage);
		}
	}
}//end CurrentAccount

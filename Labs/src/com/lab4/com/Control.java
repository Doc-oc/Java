package com.lab4.com;

public class Control {
	
	public static void main(String[] args) {
		Account newAccount = new Account("Deposit", 12345, "ULSIE2D" ,"Ulster", true, 568.00);
		System.out.println(newAccount);
		
		//Account Depsoit and Withdraw
		System.out.println("Account Balance: " + newAccount.deposit(100));
		System.out.println("New Account Balance: " + newAccount.withdraw(100));
		
		DepositAccount newDeposit = new DepositAccount("Deposit", 123456, "ULSIE2D" ,"Ulster", true, 568.00, 10);
		System.out.println("\n" + newDeposit);
		System.out.println(newDeposit.withdraw());
		
		
		
		CurrentAccount newCurrent = new CurrentAccount("Current", 98769, "ULSIE2D", "Leinster", true, 900.0, 50);
		System.out.println("\n" + newCurrent);
		System.out.println(newCurrent.withdraw(100));
		System.out.println(newCurrent.checkCredit());
		
		
		
		
		
	}//end main
}//end Control

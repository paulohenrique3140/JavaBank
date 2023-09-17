package entities;

import entities.enums.AccountType;

public abstract class Account {
	protected Integer accountNumber;
	protected String holder;
	protected AccountType accountType;
	protected Double balance;
	
	public Account() {
		
	}
	
	public Account(Integer accountNumber, String holder, AccountType accountType, Double balance) {
		this.accountNumber = accountNumber;
		this.holder = holder;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public Integer getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getHolder() {
		return holder;
	}
	
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
		
	public abstract Double calculateBalance();
	
	public abstract void deposit(double amount);
	
	public abstract void withdraw(double amount);

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Account number: " + accountNumber);
		sb.append("\nHolder: " + holder);
		sb.append("\nType: "  + accountType);
		return sb.toString();
	}
	
	
	
}
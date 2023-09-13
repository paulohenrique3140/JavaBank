package entities;

import entities.enums.AccountType;

public class SavingsAccount extends Account {
	private Double interestRate;
	
	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(Integer accountNumber, String holder, AccountType accountType, Double balance,
			Double interestRate) {
		super(accountNumber, holder, accountType, balance);
		this.interestRate = interestRate;
	}
	
	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public Double calculateBalance() {
		return balance += balance * interestRate;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		
	}

	@Override
	public boolean withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return toString() + "Hello Friend";
	}
}
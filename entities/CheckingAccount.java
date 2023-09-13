package entities;

import entities.enums.AccountType;

public class CheckingAccount extends Account {
	private Double maintenanceFee;
	
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(Integer accountNumber, String holder, AccountType accountType, Double balance,
			Double maintenanceFee) {
		super(accountNumber, holder, accountType, balance);
		this.maintenanceFee = maintenanceFee;
	}
	
	public Double getMaintenanceFee() {
		return maintenanceFee;
	}

	public void setMaintenanceFee(Double maintenanceFee) {
		this.maintenanceFee = maintenanceFee;
	}

	@Override
	public Double calculateBalance() {
		return balance -= balance * maintenanceFee;
	}
	
	@Override
	public void deposit(double amount) {
		balance += amount;
	}
	
	@Override 
	public boolean withdraw(double amount) {
		if (amount <= balance + 1000) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return toString() + "Hello Friend";
	}
}
package entities;

import entities.enums.AccountType;

public class CheckingAccount extends Account {
	private Integer maintenanceFee;
	
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(Integer accountNumber, String holder, AccountType accountType, Double balance,
			Integer maintenanceFee) {
		super(accountNumber, holder, accountType, balance);
		this.maintenanceFee = maintenanceFee;
	}
	
	public Integer getMaintenanceFee() {
		return maintenanceFee;
	}

	public void setMaintenanceFee(Integer maintenanceFee) {
		this.maintenanceFee = maintenanceFee;
	}

	@Override
	public Double calculateBalance() {
		return balance - (balance * maintenanceFee / 100);
	}
	
	@Override
	public void deposit(double amount) {
		balance += amount;
	}
	
	@Override 
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nMaintenance fee: " + maintenanceFee + "%");
		sb.append("\nBalance: $ " + String.format("%.2f", calculateBalance()));
		sb.append("\nAvaiable limit: $ " + String.format("%.2f", 1000.00 + calculateBalance()));
		return sb.toString();
	}
}
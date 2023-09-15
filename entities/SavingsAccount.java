package entities;

import entities.enums.AccountType;

public class SavingsAccount extends Account {
	private Integer interestRate;
	
	public SavingsAccount() {
		super();
	}
	
	public SavingsAccount(Integer accountNumber, String holder, AccountType accountType, Double balance,
			Integer interestRate) {
		super(accountNumber, holder, accountType, balance);
		this.interestRate = interestRate;
	}
	
	public Integer getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Integer interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public Double calculateBalance() {
		return balance + (balance * interestRate / 100);
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
		sb.append("Interest rate: " + interestRate + "%");
		sb.append("Balance: $ " + String.format("%.2f", calculateBalance()));
		return sb.toString();
	}
}
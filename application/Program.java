package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.CheckingAccount;
import entities.SavingsAccount;
import entities.enums.AccountType;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		List<Account> list = new ArrayList<>();
		int transaction, accountNumberToCheck, option;
		
		do {
			System.out.println("\n### BEM VINDO AO JAVABANK ###");
			System.out.print("\nMenu:\n[1] Criar nova conta\n[2] Depositar em uma conta\n"
					+ "[3] Sacar de uma conta\n[4] Exibir informacoes da conta\n[0] Sair do sistema\n\nDigite a opcao desejada: ");
			option = input.nextInt();
			while (option > 4 || option < 0 ) {
				System.out.print("Opcao invalida! Tente novamente: ");
				option = input.nextInt();
			}
		
			switch (option) {
			
			case 1:
				System.out.println("\n### CADASTRO DE CONTAS ###");
				System.out.print("\nNumero da conta: ");
				int accountNumber = input.nextInt();
				while(hasAccount(list, accountNumber)) {
					System.out.print("Conta ja existente. Tente novamente: ");
					accountNumber = input.nextInt();
				}
				System.out.print("Titular da conta: ");
				input.nextLine();
				String holder = input.nextLine();
				System.out.print("Conta corrente ou conta poupanca? ");
				AccountType accountType = AccountType.valueOf(input.next());
				if (accountType.toString() == "CORRENTE") {
					System.out.print("Taxa de manutencao [%]: ");
					int maintenanceFee = input.nextInt();
					Account checkingAccount = new CheckingAccount(accountNumber, holder, accountType, 0.00, maintenanceFee);
					list.add(checkingAccount);
				} else {
					System.out.print("Taxa de juro [%]: ");
					int interestRate = input.nextInt();
					Account savingsAccount= new SavingsAccount(accountNumber, holder, accountType, 0.00, interestRate);
					list.add(savingsAccount);
				}
				break;
			
			case 2:
				transaction = 1;
				System.out.println("\n### DEPOSITO ###");
				System.out.print("\nNumero da conta: ");
				accountNumberToCheck = input.nextInt();
				while(!hasAccount(list, accountNumberToCheck)) {
					System.out.print("Conta invalida, tente novamente: ");
					accountNumberToCheck = input.nextInt();
				}
				System.out.print("Digite o valor do deposito: $ ");
				double amountDeposit = input.nextDouble();
				deposit(list, accountNumberToCheck, amountDeposit, transaction);
				System.out.println("Deposito efetuado com sucesso!");
				break;
				
			case 3:
				transaction = 2;
				System.out.println("\n### SAQUE ###");
				System.out.print("\nNumero da conta: ");
				accountNumberToCheck = input.nextInt();
				while(!hasAccount(list, accountNumberToCheck)) {
					System.out.print("Conta invalida, tente novamente: ");
					accountNumberToCheck = input.nextInt();
				}
				System.out.print("Digite o valor do saque: $ ");
				double amountWithdraw = input.nextDouble();
				if (withdraw(list, accountNumberToCheck, amountWithdraw)) {
					System.out.println("Saque efetuado com sucesso!");
				} else {
					System.out.println("Saldo insuficiente!");
				}
				break;
				
			case 4:
				System.out.println("\n### EXTRATO ###");
				System.out.print("\nDigite o numero da conta: ");
				accountNumberToCheck = input.nextInt();
				while(!hasAccount(list, accountNumberToCheck)) {
					System.out.print("Conta invalida, tente novamente: ");
					accountNumberToCheck = input.nextInt();
				}
				System.out.println();
				showAccount(list, accountNumberToCheck);
				break;
			
			default:
				System.out.println("Obrigado e volte sempre!");
				break;
			
			}
		} while (option != 0);
		input.close();
	}
	
	public static boolean hasAccount(List<Account> list, int accountNumberToCheck) {
		Account accountToCheck = list.stream().filter(x -> x.getAccountNumber() == accountNumberToCheck).findFirst().orElse(null);
		return accountToCheck != null;
	}
	
	public static void showAccount(List<Account> list, int accountNumberToCheck) {
		for (Account x : list) {
			if (x.getAccountNumber() == accountNumberToCheck) {
				System.out.println(x);		
			}
		}		
	}
	
	public static void deposit(List<Account> list, int accountNumberToCheck, double amount, int transaction) {
		for (Account x : list) {
			if (x.getAccountNumber() == accountNumberToCheck) {
				x.deposit(amount);
			}
		}
	}
	
	public static boolean withdraw(List<Account> list, int accountNumberToCheck, double amountWithdraw) {
		boolean result = true;
		for (Account x : list) {
			if (x.getAccountNumber() == accountNumberToCheck) {
				if (x.getAccountType().toString() == "CORRENTE") {
					if (amountWithdraw > x.calculateBalance() + 1000.00) {
						result = false;
					} else {
						x.withdraw(amountWithdraw);
						result = true;
					}
				} else {
					if (amountWithdraw > x.calculateBalance()) {
						result = false;
					} else {
						x.withdraw(amountWithdraw);
						result = true;
					}
				}
			}
		}
		return result;
	}
}
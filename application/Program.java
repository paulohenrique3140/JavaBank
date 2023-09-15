package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		double amount;
		
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
				Account account;
				System.out.println("\n### CADASTRO DE CONTAS ###");
				System.out.print("\nNumero da conta: ");
				int accountNumber = input.nextInt();
				System.out.print("Titular da conta: ");
				input.nextLine();
				String holder = input.nextLine();
				System.out.print("Conta corrente ou conta poupanca? ");
				AccountType accountType = AccountType.valueOf(input.next());
				if (accountType.toString() == "CORRENTE") {
					System.out.print("Taxa de manutencao [%]: ");
					int maintenanceFee = input.nextInt();
					account = new CheckingAccount(accountNumber, holder, accountType, 0.0, maintenanceFee);
				} else {
					System.out.print("Taxa de juro [%]: ");
					int interestRate = input.nextInt();
					account = new SavingsAccount(accountNumber, holder, accountType, 0.0, interestRate);
				}
				list.add(account);
				break;
			
			case 2:
				transaction = 1;
				System.out.println("\n### DEPOSITO ###");
				System.out.print("\nNumero da conta: ");
				accountNumberToCheck = input.nextInt();
				while(hasAccount(list, accountNumberToCheck)) {
					System.out.print("Conta invalida, tente novamente: ");
					accountNumberToCheck = input.nextInt();
				}
				System.out.print("Digite o valor do deposito: $ ");
				amount = input.nextDouble();
				findAccountToTransaction(list, accountNumberToCheck, amount, transaction);
				System.out.println("Deposito efetuado com sucesso!");
				break;
				
			case 3:
				transaction = 2;
				System.out.println("\n### SAQUE ###");
				System.out.print("\nNumero da conta: ");
				accountNumberToCheck = input.nextInt();
				while(hasAccount(list, accountNumberToCheck)) {
					System.out.print("Conta invalida, tente novamente: ");
					accountNumberToCheck = input.nextInt();
				}
				System.out.print("Digite o valor do saque: $ ");
				amount = input.nextDouble();
				if (checkBalance(list, accountNumberToCheck, amount)) {
					findAccountToTransaction(list, accountNumberToCheck, amount, transaction);
					System.out.println("Saque efetuado com sucesso!");
				} else {
					System.out.println("Saldo insuficiente!");
				}
				break;
				
			case 4:
				System.out.println("\n### EXTRATO ###");
				System.out.print("Digite o numero da conta: ");
				accountNumberToCheck = input.nextInt();
				while(hasAccount(list, accountNumberToCheck)) {
					System.out.print("Conta invalida, tente novamente: ");
					accountNumberToCheck = input.nextInt();
				}
				showAccount(list, accountNumberToCheck);
				break;
			
			default:
				System.out.println("Obrigado e volte sempre!");
				break;
			
			}
		} while (option != 0);
		input.close();
	}
	
	public static boolean hasAccount(List<Account> account, Integer accountNumber) {
		Account list = account.stream().filter(x -> x.getAccountNumber() == accountNumber).findFirst().orElse(null);
		return list != null;
	}
	
	public static void showAccount(List<Account> account, Integer accountNumber) {
		List<Account> result = account.stream().filter(x -> x.getAccountNumber() == accountNumber)
				.collect(Collectors.toList());
		System.out.println(result.toString());
	}
	
	public static void findAccountToTransaction(List<Account> account, Integer accountNumber, double amount, int transaction) {
		for (Account x : account) {
			if (x.getAccountNumber() == accountNumber) {
				if (transaction == 1) {
					x.deposit(amount);
				} else {
					x.withdraw(amount);
				}
			}
		}
	}
	
	public static boolean checkBalance(List<Account> account, Integer accountNumber, double amount) {
		boolean result = true;
		for (Account x : account) {
			if (x.getAccountNumber() == accountNumber) {
				if (x.getAccountType().toString() == "CORRENTE") {
					if (amount > x.calculateBalance() + 1000.00) {
						result = false;
					} else {
						x.withdraw(amount);
						result = true;
					}
				} else {
					if (amount > x.calculateBalance()) {
						result = false;
					} else {
						result = true;
					}
				}
			}
		}
		return result;
	}
}
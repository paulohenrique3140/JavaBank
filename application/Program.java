package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		List<Account> list = new ArrayList<>();
		
		System.out.println("### BEM VINDO AO JAVABANK ###");
		System.out.print("\nMenu:\n[1] Criar nova conta\n[2] Depositar em uma conta\n"
				+ "[3] Sacar de uma conta\n[4] Exibir informacoes da conta\n[0] Sair do sistema\n\nDigite a opcao desejada: ");
		int option = input.nextInt();
		while (option > 4 || option < 0 ) {
			System.out.print("Opcao invalida! Tente novamente: ");
			option = input.nextInt();
		}
		do {
			switch (option) {
			
			case 1:
				System.out.println("### CADASTRO DE CONTAS ###");
				System.out.print("\nOlá");
				break;
			
			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				break;
			
			default:
				break;
			
			}
		} while (option != 0);
		input.close();
	}
}
package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		Cliente cliente = new Cliente();
		System.out.print("Digite o seu nome: ");
		String nomeCliente = sc.next();
				
		cliente.setNome(nomeCliente);
		
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);
		
		System.out.print("Qual valor deseja depositar? ");
		double valorDeposito = sc.nextDouble();
		cc.depositar(valorDeposito);
		cc.imprimirExtrato();
		
		System.out.print("Qual valor deseja sacar? ");
		double valorSaque = sc.nextDouble();
		cc.sacar(valorSaque);
		
		cc.imprimirExtrato();
		System.out.print("Qual valor deseja transferir? ");
		double valorTransferencia = sc.nextDouble();
		cc.transferir(valorTransferencia, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		sc.close();
		

	}

}

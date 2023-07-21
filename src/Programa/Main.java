package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes(); 
	}

	public static void operacoes() {
		
		System.out.println("--------------------------------------------------------");
		System.out.println("----------------Ben vindos a nossa Agencia--------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("******Selecione uma das operacao que deseja realizar****");
		System.out.println("---|Opcao 1 Criar conta |-------------------------------");
		System.out.println("---|Opcao 2 Depositar   |-------------------------------");
		System.out.println("---|Opcao 3 Sacar       |-------------------------------");
		System.out.println("---|Opcao 4 Transferir  |-------------------------------");
		System.out.println("---|Opcao 5 Listar      |-------------------------------");
		System.out.println("---|Opcao 6 Sair        |-------------------------------");
		System.out.println("--------------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		
		int operacao = input.nextInt();
		switch(operacao) {
		case 1 : 
			  criarConta();
			  break;
	
		case 2 : 
			  depositar();
			  break;
			  
		case 3 : 
			  sacar();
			  break;
			  
		case 4 : 
			  transferir();
			  break;
			  
		case 5 : 
			  listarContas();
			  break;
			  
		case 6 : 
			  System.out.println("Flw e nois, obrigado por usar a nossa agencia");;
			  System.exit(0);
	    
	    default:
	    	System.out.println("Operacao invalida !");
	    	operacoes();
	    	break;
	}
			
		}
	
	public static void criarConta() {
	
	 System.out.println("\n Nome: ");
	 String nome = input.next();
	 System.out.println("\n CPF: ");
	 String cpf = input.next();
	 System.out.println("\n Email: ");
	 String email = input.next();
	 
	 Pessoa pessoa = new Pessoa(nome, cpf, email);
	 
	 Conta conta = new Conta(pessoa);
	 
	 contasBancarias.add(conta);
	 System.out.println("Sua conta foi Criada com sucesso");
	 operacoes();
	 
	 }
	
	private static Conta encontrarConta(int numeroConta){
		Conta conta = null;
		
		if(contasBancarias.size() > 0) {
			for(Conta c : contasBancarias) {
				if(c.getNumeroConta() == numeroConta){
					conta = c;
				}
				
			}
		}
		return conta;
	}
	
	private static void depositar(){
		System.out.println("Informa o numero de Conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			
			System.out.println("Qual valor deseja depositar");
			Double valorDepositado = input.nextDouble();
			
			conta.depositar(valorDepositado);

			System.out.println("Valor depositado com sucesso");
		}else {
			System.out.println(" Conta não encontrada");
		}
		
		operacoes();
	}
	
	public static void sacar() {
		System.out.println("Informa o numero de Conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			
			System.out.println("Qual valor deseja sacar");
			Double valorSaque = input.nextDouble();
			
			conta.sacar(valorSaque);

			//System.out.println("Valor sacado com sucesso");
		}else {
			System.out.println(" Conta não encontrada");
		}
		
		operacoes();
	}
		
	public static void transferir() {
		System.out.println("Informa o numero de Conta do remetente ");
		int numeroContaRemetente = input.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Informa o numero de Conta do destinatario ");
			int numeroContaDestinatario = input.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Informa o valor da transferencia ");
				Double valor = input.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}else {
				System.out.println(" Conta para transferencia não encontrada");
			}
		}
		operacoes();
	}

	public static void listarContas() {
		  if(contasBancarias.size()>0) {
			  for(Conta conta : contasBancarias) {
				  System.out.println(conta);
			  }
		  }else {
			  System.out.println("Nao tem contas cadastradas");
		  }
		  operacoes();
	}
	
}


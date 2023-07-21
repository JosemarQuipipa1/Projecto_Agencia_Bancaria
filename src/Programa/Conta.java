package Programa;

import utilitario.Utils;

public class Conta {

	private static int contadorDeConta = 1;
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	public Conta( Pessoa pessoa) {
		this.numeroConta = contadorDeConta;
		this.pessoa = pessoa;
		contadorDeConta+=1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return  "\n Numero de Conta: " +this.getNumeroConta()+
				"\n Nome: " +this.pessoa.getNome()+
				"\n CPF: " +this.pessoa.getCpf() +
				"\n Email: " +this.pessoa.getEmail()+
				"\n Saldo: " + this.getSaldo() +
				"\n" ;

}
	
	public void depositar(Double valor) {
		
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu deposito foi realizado com sucesso" + valor);
		}else {
			System.out.println("Seu deposito nao foi realizado com sucesso" + valor);
		}
		
			
		}
		
	public void sacar(Double valor){
		
		if(valor > 0 && this.getSaldo()>= valor) {
			setSaldo(getSaldo()- valor);
			System.out.println("Seu deposito foi realizado com sucesso" + valor);
		}else {
			System.out.println("Seu deposito nao foi realizado com sucesso" + valor);
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo()>= valor) {
			setSaldo(getSaldo()- valor);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor; 
			System.out.println("Sua transferencia foi realizado com sucesso" + valor);
		}else {
			System.out.println(" Sua transferencia nao foi realizado com sucesso" + valor);
		}
		
	}
	
}
	

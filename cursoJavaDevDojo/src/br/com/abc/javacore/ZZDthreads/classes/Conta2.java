package br.com.abc.javacore.ZZDthreads.classes;

public class Conta2 {

	private int saldo = 50;
	
	public int getSaldo() {
		return saldo;
	}
	
	public void saque(int valor) {
		saldo = saldo - valor;
	}

}

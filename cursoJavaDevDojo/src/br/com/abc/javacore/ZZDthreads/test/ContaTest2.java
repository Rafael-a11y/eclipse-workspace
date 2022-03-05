package br.com.abc.javacore.ZZDthreads.test;

import br.com.abc.javacore.ZZDthreads.classes.Conta2;
// 1:1 para locks e objetos, mas 1:n para threads e locks
public class ContaTest2 implements Runnable{

	private final Conta2 conta = new Conta2();
	
	public static void main(String[] args) {
		ContaTest2 contaTest = new ContaTest2();
		Thread william = new Thread(contaTest, "William");
		Thread anna = new Thread(contaTest, "Anna");
		william.start();
		anna.start();
	}
	
	public static void imprime() {
		synchronized(ContaTest2.class) {
			System.out.println("asasasasa");
		}
	}
	
	private  void saque(int valor) {
		synchronized(conta){
			if(conta.getSaldo() >= valor) {
				System.out.println(Thread.currentThread().getName() + " está indo sacar");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conta.saque(valor);
				System.out.println(Thread.currentThread().getName() + " completou o saque, saldo: " + conta.getSaldo());
			}
			else {
				System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque, saldo: " + conta.getSaldo());
			}
		}
	}
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			this.saque(10);
			if(conta.getSaldo() < 0) {
				System.out.println("Oh meu Deus.");
			}
		}
	}
}

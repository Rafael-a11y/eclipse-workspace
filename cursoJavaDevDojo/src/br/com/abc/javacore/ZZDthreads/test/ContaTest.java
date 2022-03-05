package br.com.abc.javacore.ZZDthreads.test;

import br.com.abc.javacore.ZZDthreads.classes.Conta;
/*Teste feito com dois usu�rios que tentam acessar uma mesma conta e efetuar um saque, embora seja um c�digo simples com
 * algumas linhas, a coisa fica bem feia quando se trata de um c�digo com v�rias linhas, fica bem hard de achar exce��es,
 * por isso, parea garantir que apenas uma thread por vez ir� acessar o m�todo de saque, usa-se a palavra reservada synchronized
 * para especificar que apenas uma thread por vez ir� acessar o m�todo e efetuar o saque. Caso n�o haja o sincronismo de threads,
 * pode acontecer de os dois usu�rios entrarem no m�todo saque() e lerem a linha que verifica se o saldo est� dispon�vel, da�
 * qundo a thread B ler a linha em que o saque � efetuado, pode ser que a thread A j� o tenha feito, sendo assim, neste momento,
 * o saldo vai estar negativo, da� a thread B faz o saque novamente, deixando o saldo negativo, que � algo em que numa regra de
 * neg�cio de banco jamais deve acontecer. Por isso a palavra reservada synchronized � importante para garantir que uma thread
 * de cada vez e somente de cada vez ir� acessar o m�todo, ou seja, acaba com a concorr�ncia.
 * � uma boa pr�tica usar m�todos est�ticos para atributos est�ticos e m�todos de inst�ncia para atributos de inst�ncia,
 * principalmente quando se est� trabalhando com threads, j� que o tipo de lock � diferente para os dois tipos, e em rela��o a
 * vari�veis locais, n�o precisar usar synchronized, j� que para cada thread � feita um c�pia do campo local */
public class ContaTest implements Runnable {

	private Conta conta = new Conta();
	//Talvez tenha apenas uma inst�ncia pq nada foi criado no main.
	public static void main(String[] args) {
		
//		Conta conta = new Conta();
		ContaTest contaTest = new ContaTest();
		Thread william = new Thread(contaTest, "William");
		Thread anna = new Thread(contaTest, "Anna");
		william.start();
		anna.start();
	}
	//Ao sincronizar um m�todo est�tico, voc� sincroniza um aclasse inteira, as duas linhas abaixo (26 e 27) resultam na mesma
	//coisa.
	public static synchronized void imprime() {
		synchronized(ContaTest.class) {
			System.out.println("asasasas");
		}
	}
	
	//Voc� n�o precisa usar a palavra synchronized diretemente no m�todo, voc� pode sincronizar o bloco usando a palavra
	//synchronized seguido de abre/feha par�ntesis com o objeto conta de par�metro, impondo que o objeto ser� acessado
	//somente por uma thread de cada vez. 
	private void saque(int valor) {
		synchronized(conta) {
			if(conta.getSaldo() >= valor) {
				System.out.println(Thread.currentThread().getName() + " est� indo sacar");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.out.print("Erro ao sacar -> ");
					e.printStackTrace();
				}
				conta.saque(valor);
				System.out.println(Thread.currentThread().getName() + " completou o saque, saldo: " + conta.getSaldo());
			}
			else {
				System.out.println("Sem dinheiro para " + Thread.currentThread()
				.getName() + " efetuar o saque, saldo: " + conta.getSaldo());
			}
		}
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			saque(10);
			if(conta.getSaldo() < 0) {
				System.out.println("Oh meu Deus!");
			}
		}
	}
}

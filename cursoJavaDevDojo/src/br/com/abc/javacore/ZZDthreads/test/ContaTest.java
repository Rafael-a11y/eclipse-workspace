package br.com.abc.javacore.ZZDthreads.test;

import br.com.abc.javacore.ZZDthreads.classes.Conta;
/*Teste feito com dois usuários que tentam acessar uma mesma conta e efetuar um saque, embora seja um código simples com
 * algumas linhas, a coisa fica bem feia quando se trata de um código com várias linhas, fica bem hard de achar exceções,
 * por isso, parea garantir que apenas uma thread por vez irá acessar o método de saque, usa-se a palavra reservada synchronized
 * para especificar que apenas uma thread por vez irá acessar o método e efetuar o saque. Caso não haja o sincronismo de threads,
 * pode acontecer de os dois usuários entrarem no método saque() e lerem a linha que verifica se o saldo está disponível, daí
 * qundo a thread B ler a linha em que o saque é efetuado, pode ser que a thread A já o tenha feito, sendo assim, neste momento,
 * o saldo vai estar negativo, daí a thread B faz o saque novamente, deixando o saldo negativo, que é algo em que numa regra de
 * negócio de banco jamais deve acontecer. Por isso a palavra reservada synchronized é importante para garantir que uma thread
 * de cada vez e somente de cada vez irá acessar o método, ou seja, acaba com a concorrência.
 * É uma boa prática usar métodos estáticos para atributos estáticos e métodos de instância para atributos de instância,
 * principalmente quando se está trabalhando com threads, já que o tipo de lock é diferente para os dois tipos, e em relação a
 * variáveis locais, não precisar usar synchronized, já que para cada thread é feita um cópia do campo local */
public class ContaTest implements Runnable {

	private Conta conta = new Conta();
	//Talvez tenha apenas uma instância pq nada foi criado no main.
	public static void main(String[] args) {
		
//		Conta conta = new Conta();
		ContaTest contaTest = new ContaTest();
		Thread william = new Thread(contaTest, "William");
		Thread anna = new Thread(contaTest, "Anna");
		william.start();
		anna.start();
	}
	//Ao sincronizar um método estático, você sincroniza um aclasse inteira, as duas linhas abaixo (26 e 27) resultam na mesma
	//coisa.
	public static synchronized void imprime() {
		synchronized(ContaTest.class) {
			System.out.println("asasasas");
		}
	}
	
	//Você não precisa usar a palavra synchronized diretemente no método, você pode sincronizar o bloco usando a palavra
	//synchronized seguido de abre/feha parêntesis com o objeto conta de parâmetro, impondo que o objeto será acessado
	//somente por uma thread de cada vez. 
	private void saque(int valor) {
		synchronized(conta) {
			if(conta.getSaldo() >= valor) {
				System.out.println(Thread.currentThread().getName() + " está indo sacar");
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

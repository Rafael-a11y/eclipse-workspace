package br.com.abc.javacore.ZZDthreads.test;

class ThreadExemplo extends Thread{
	
	private char c;
	public ThreadExemplo(char c) {
		this.c = c;
	}
	/*A mágica acontece aqui. Se vocÊ quer que um código seja executado em
	 * paralelo, você deve escrevê-lo aqui*/
	
	@Override
	public void run() {
		System.out.println("Thread executando: " + Thread.currentThread().getName());
		for (int i = 0; i < 100; i++) {
			System.out.print(c);
			if(i % 10 == 0) {
				System.out.println("	Quebrando linha " + i);
			}
		}
	}
}

class ThreadExemploRunnable implements Runnable{
	
	private char c;
	
	public ThreadExemploRunnable(char c) {
		this.c = c;
	}
	@Override
	public void run() {
		System.out.println("Thread executando: " + Thread.currentThread().getName());
		for (int i = 0; i < 100; i++) {
			System.out.print(c);
			if(i % 10 == 0) {
				System.out.println("	Quebrando linha " + i);
			}
			if(Thread.currentThread().getName().equals("T4"));
			Thread.yield();
			//Faz com que uma thread em running volte para runnable, para que
			//outras threads com nível igual de prioridade passem para o
			//estado de Running, mas isso não é garantido.
			try {
				//Faz com que uma thread durma pelo tempo em milisegundos
				//definido pelo usuário
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest {
/*Tipos de threads: Daemons e User. 
 * User -> A JVM só finaliza sua execução se todas as threads user estiverem
 * terminadas.
 * Você pode criar threads de duas maneiras, ou estendendo a classe Thread,
 * ou implementando a interface Runnable.*/
	public static void main(String[] args) {
		System.out.println("Nome da Thread: " + Thread.currentThread().getName());
//		ThreadExemplo t1 = new ThreadExemplo('A');
//		ThreadExemplo t2 = new ThreadExemplo('B');
//		ThreadExemplo t3 = new ThreadExemplo('C');
//		ThreadExemplo t4 = new ThreadExemplo('D');
		//Execute o método run() para as threads serem lançadas em pararelo,
		//porém, caso não starte a Thread, dará a sensação que todas as threads
		//estão sendo executadas, quando somente o main será executado 4 vezes
		//Outra forma de criar Threads é criar um objeto da super classe Thread,
		//tal objeto esse que recebe de parâmetro um outro objeto que implmenta
		//a interface Runnable, criar thread a partir de classes que implementam
		//Runnable é uma boa prática, já que do ponto de vista da POO, não é
		//criar subclasses se a intenção não for especializá-la.
		/*Estados da Thread -> new, runnable, running, waithing/blocking e dead, ou seja: nova, executável, executando,
		 * esperando, bloqueada e morta. Quando uma Thread chama o método starts significa que o estado é runnable, mas não
		 * está em running. Uma thread nunca pode deixar outra thread em sleping, quando a thread entra em dead, significa que
		 * o main já foi executado, e tal thread não pode ser executada de novo, é importante enfatizar que é a própria thread
		 * que decide quando ela vai ficar em bloqueado/esperando, e o Scheduler (escalonador) que a coloca em estado running.
		 * */
		Thread t1 = new Thread(new ThreadExemploRunnable('A'), "T1");
		Thread t2 = new Thread(new ThreadExemploRunnable('B'), "T2");
		Thread t3 = new Thread(new ThreadExemploRunnable('C'), "T3");
		Thread t4 = new Thread(new ThreadExemploRunnable('D'), "T4");
		t4.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		try {
			//As outras threads só serão executadas quando t1 terminar o
			//método run(ou seja, ele vai parar na linha 90 e só vai pular
			//para a próxima linha quando a thread t1 terminar seu processamento).
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		t3.start();
//		t4.start();
	}
	
}
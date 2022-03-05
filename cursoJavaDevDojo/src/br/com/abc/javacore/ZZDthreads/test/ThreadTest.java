package br.com.abc.javacore.ZZDthreads.test;

class ThreadExemplo extends Thread{
	
	private char c;
	public ThreadExemplo(char c) {
		this.c = c;
	}
	/*A m�gica acontece aqui. Se voc� quer que um c�digo seja executado em
	 * paralelo, voc� deve escrev�-lo aqui*/
	
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
			//outras threads com n�vel igual de prioridade passem para o
			//estado de Running, mas isso n�o � garantido.
			try {
				//Faz com que uma thread durma pelo tempo em milisegundos
				//definido pelo usu�rio
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest {
/*Tipos de threads: Daemons e User. 
 * User -> A JVM s� finaliza sua execu��o se todas as threads user estiverem
 * terminadas.
 * Voc� pode criar threads de duas maneiras, ou estendendo a classe Thread,
 * ou implementando a interface Runnable.*/
	public static void main(String[] args) {
		System.out.println("Nome da Thread: " + Thread.currentThread().getName());
//		ThreadExemplo t1 = new ThreadExemplo('A');
//		ThreadExemplo t2 = new ThreadExemplo('B');
//		ThreadExemplo t3 = new ThreadExemplo('C');
//		ThreadExemplo t4 = new ThreadExemplo('D');
		//Execute o m�todo run() para as threads serem lan�adas em pararelo,
		//por�m, caso n�o starte a Thread, dar� a sensa��o que todas as threads
		//est�o sendo executadas, quando somente o main ser� executado 4 vezes
		//Outra forma de criar Threads � criar um objeto da super classe Thread,
		//tal objeto esse que recebe de par�metro um outro objeto que implmenta
		//a interface Runnable, criar thread a partir de classes que implementam
		//Runnable � uma boa pr�tica, j� que do ponto de vista da POO, n�o �
		//criar subclasses se a inten��o n�o for especializ�-la.
		/*Estados da Thread -> new, runnable, running, waithing/blocking e dead, ou seja: nova, execut�vel, executando,
		 * esperando, bloqueada e morta. Quando uma Thread chama o m�todo starts significa que o estado � runnable, mas n�o
		 * est� em running. Uma thread nunca pode deixar outra thread em sleping, quando a thread entra em dead, significa que
		 * o main j� foi executado, e tal thread n�o pode ser executada de novo, � importante enfatizar que � a pr�pria thread
		 * que decide quando ela vai ficar em bloqueado/esperando, e o Scheduler (escalonador) que a coloca em estado running.
		 * */
		Thread t1 = new Thread(new ThreadExemploRunnable('A'), "T1");
		Thread t2 = new Thread(new ThreadExemploRunnable('B'), "T2");
		Thread t3 = new Thread(new ThreadExemploRunnable('C'), "T3");
		Thread t4 = new Thread(new ThreadExemploRunnable('D'), "T4");
		t4.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		try {
			//As outras threads s� ser�o executadas quando t1 terminar o
			//m�todo run(ou seja, ele vai parar na linha 90 e s� vai pular
			//para a pr�xima linha quando a thread t1 terminar seu processamento).
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		t3.start();
//		t4.start();
	}
	
}
package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public static void main(String[] args) {
		LockTest x = new LockTest();
		final ReentrantLock lock = new ReentrantLock();
		//De forma não estática
//		Thread t1 = new Thread(x.new Worker("A", lock));
//		t1.start();
		new Thread(new Worker("A", lock)).start();
		new Thread(new Worker("B", lock)).start();
		new Thread(new Worker("C", lock)).start();
		new Thread(new Worker("D", lock)).start();
		new Thread(new Worker("E", lock)).start();
		new Thread(new Worker("F", lock)).start();
		new Thread(new Worker("G", lock)).start();
	
	}
	
	 static class Worker implements Runnable{
		private String nome;
		private ReentrantLock reentrantLock;
		
		public Worker(String nome, ReentrantLock reentrantLock) {
			this.nome = nome;
			this.reentrantLock = reentrantLock;
		}
		//tryLock() e tryLock(long value, TimeUnit.unit), tentam obter o lock, a diferença é que o segundo possui um tempo de
		//saída, o que faz com que o dead lock nãoi aconteça. O lock() é diferente de tryLock(), no primeiro, a thread fica
		//esperando até o lock ser liberado, no try lock() a thread tenta obter o lock, caso não consiga, segue seu processamento.
		//getQueueLength retorna o número estimado de Threads que esperam para obter o lock, o número é uma estimativa pois o
		//número de threads muda dinâmicaamente enquanto o método atravassa estrutura de dados internas, este método é projetado
		//para monitoramento do estado do sistem e não para controle de sincronização,
		@Override
		public void run() {
			reentrantLock.lock();
			try {
				if(reentrantLock.isHeldByCurrentThread()) {
					System.out.printf("Thread %s entrou em uma sessão crítica%n", nome);
					System.out.printf("%d Threads esperando na fila%n", reentrantLock.getQueueLength());
					System.out.printf("Thread %s vai dormir por dois segundos%n", nome);
					Thread.sleep(2000);
					System.out.printf("Thread %s finalizou o trabalho%n", nome);
				}
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				reentrantLock.unlock();
			}
		}
	}

}

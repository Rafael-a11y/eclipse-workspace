package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		//Queues block tem limite de capacidade, tal limite � definido na cria��o da queue
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
		/*SynchronousQueue � uma BlockingQueue com capacidade 0, portanto, se voc� tentar adicionar ou remover, o main espera
		outra thread fazer a a��o inversa, se voc� tenta usar a SynchronousQueue para adicionar, ela fica esperando outra
		thread excluir o elemento logo em seguida, e caso tente exluir, ela espera outra thread adicionar
		DelayedQueue<? extends Delayed> serve para threads consumirem objetos da queue ap�s um determinado tempo*/
		Thread t1 = new Thread(new RemoveFromQueue(bq));
		bq.put("william");
		System.out.println("peek: " + bq.peek());
		System.out.println("Tentando colocar outro valor");
		t1.start();
		/*A partir da linha de baixo, a thread main vai ficar bloqueada esperando outra thread vir e remover a cabe�a da fila,
		 * pois como foi declarado em sua crial��o, o limite de elementos nessa fila � de um, sendo assim, estamos em um dead
		 * lock*/
		bq.put("DevDojo, o melhor dojo de TI do Brasil");
		System.out.println("Inserido o �ltimo valor");
		System.out.println("peek: " + bq.peek());
	}
	
	static class RemoveFromQueue implements Runnable{
		private BlockingQueue<String> bq;
		
		public RemoveFromQueue(BlockingQueue<String> bq) {
			this.bq = bq;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " entrando em espera por 2 segundos");
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Removendo o valor " + bq.take());
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

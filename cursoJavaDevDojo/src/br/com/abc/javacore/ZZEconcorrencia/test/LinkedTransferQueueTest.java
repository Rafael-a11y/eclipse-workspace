package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest{
	public static void main(String[] args) throws InterruptedException {
		/*ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue formam LinkedTransferQueue, caso a LinkedTrnasferQueue
		 * atinja sua capacidade m�xima (2147483647), vai ficar em modo espera como as outras BlockingQueues*/
		TransferQueue<String> tq = new LinkedTransferQueue<>();
		//Adiciona o elemento na fila e retorna true caso a a��o seja bem sucedida, e lan�a IllegalArgumentException caso n�o
		//haja espa�o na fila.
		System.out.println(tq.add("William"));
		//Adiciona o elemento na fila mas bloqueia o main se a capacidade estiver estourada, espera at� que uma thread venha e
		//e libere espa�o removendo um elemnto, lan�a: IntterruptedException caso seja interrompido enquanto.
		tq.put("DevDojo");
		/*Offer adiciona o elemento na fila, e caso a opera��o seja bem sucedida retorna true, false caso contr�rio. J� o offer
		 * sobrecarregado retorna true caso insira o elemento na fila dentro do tempo especificado*/
		System.out.println(tq.offer("William"));
		System.out.println(tq.offer("William", 10, TimeUnit.NANOSECONDS));
/*		tq.transfer("DevDojo"); bloqueia a Thread at� que o elemento especificado seja consumido por outra thread
 * 		J� o tryTransfer retorna true se tiver uma thread esperando para consumir o elemento, e false caso contr�rio.
 * 		J� o offer sobrecarregado com unidade de tempo, retorna false caso ele espere o tempo especificado e nenhuma
 * 		thread apare�a para consumir o elemento, e true caso uma outra thread consuma o elemento durante esse tempo.*/
		System.out.println(tq.tryTransfer("DevDojo", 10, TimeUnit.NANOSECONDS));
		System.out.println(tq.remainingCapacity());
		/*element pega mas n�o remove o cabe�a da fila, se diferencia do peek que apenas retorna null caso a fila esteja vazia
		 *e n�o lan�a Exception, lan�a um NoSuchElementException caso a fila esteja vazia. poll recupera e remove o cabe�a da
		 *fila e retorna null caso a fila esteja vazia, j� sua vers�o sobrecarregada remove o cabe�a da fila e espera o tempo
		 *acabar antes de retornar null caso a fila esteja vazia ap�s a remo��o. Remove recupera e remove o cabe�a da fila e
		 *lan�a NoSuchElementException caso a fila esteja vazia. Por �ltimo mas n�o menos importante, temos o take que recupera
		 *e remove o cabe�a da fila, mas fica esperando caso n�o haja um cabe�a para remover, espera at� que outra thread
		 *apare�a para incluir um elemento na fila, e lan�a InterruptedException caso seja interrompida enquanto espera*/
		System.out.println(tq.element());
		System.out.println(tq.peek());
		System.out.println(tq.poll());
		System.out.println(tq.poll(10, TimeUnit.MILLISECONDS));
		System.out.println(tq.remove());
		System.out.println(tq.take());
	}
}

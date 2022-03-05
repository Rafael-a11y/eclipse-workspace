package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest{
	public static void main(String[] args) throws InterruptedException {
		/*ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue formam LinkedTransferQueue, caso a LinkedTrnasferQueue
		 * atinja sua capacidade máxima (2147483647), vai ficar em modo espera como as outras BlockingQueues*/
		TransferQueue<String> tq = new LinkedTransferQueue<>();
		//Adiciona o elemento na fila e retorna true caso a ação seja bem sucedida, e lança IllegalArgumentException caso não
		//haja espaço na fila.
		System.out.println(tq.add("William"));
		//Adiciona o elemento na fila mas bloqueia o main se a capacidade estiver estourada, espera até que uma thread venha e
		//e libere espaço removendo um elemnto, lança: IntterruptedException caso seja interrompido enquanto.
		tq.put("DevDojo");
		/*Offer adiciona o elemento na fila, e caso a operação seja bem sucedida retorna true, false caso contrário. Já o offer
		 * sobrecarregado retorna true caso insira o elemento na fila dentro do tempo especificado*/
		System.out.println(tq.offer("William"));
		System.out.println(tq.offer("William", 10, TimeUnit.NANOSECONDS));
/*		tq.transfer("DevDojo"); bloqueia a Thread até que o elemento especificado seja consumido por outra thread
 * 		Já o tryTransfer retorna true se tiver uma thread esperando para consumir o elemento, e false caso contrário.
 * 		Já o offer sobrecarregado com unidade de tempo, retorna false caso ele espere o tempo especificado e nenhuma
 * 		thread apareça para consumir o elemento, e true caso uma outra thread consuma o elemento durante esse tempo.*/
		System.out.println(tq.tryTransfer("DevDojo", 10, TimeUnit.NANOSECONDS));
		System.out.println(tq.remainingCapacity());
		/*element pega mas não remove o cabeça da fila, se diferencia do peek que apenas retorna null caso a fila esteja vazia
		 *e não lança Exception, lança um NoSuchElementException caso a fila esteja vazia. poll recupera e remove o cabeça da
		 *fila e retorna null caso a fila esteja vazia, já sua versão sobrecarregada remove o cabeça da fila e espera o tempo
		 *acabar antes de retornar null caso a fila esteja vazia após a remoção. Remove recupera e remove o cabeça da fila e
		 *lança NoSuchElementException caso a fila esteja vazia. Por último mas não menos importante, temos o take que recupera
		 *e remove o cabeça da fila, mas fica esperando caso não haja um cabeça para remover, espera até que outra thread
		 *apareça para incluir um elemento na fila, e lança InterruptedException caso seja interrompida enquanto espera*/
		System.out.println(tq.element());
		System.out.println(tq.peek());
		System.out.println(tq.poll());
		System.out.println(tq.poll(10, TimeUnit.MILLISECONDS));
		System.out.println(tq.remove());
		System.out.println(tq.take());
	}
}

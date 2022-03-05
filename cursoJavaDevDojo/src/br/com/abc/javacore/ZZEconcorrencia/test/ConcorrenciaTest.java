package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Contador{
	private int count;
	private AtomicInteger atomicInteger = new AtomicInteger();
	private Lock lock = new ReentrantLock();
	//O valor do contador é copiado em uma variável local que antes de devolver o valor, verifica se o valor original da
	//variável count foi alterada, se sim, troca o valor para garantir que o valor de incrementador seja sempre de 1 em 1, ou
	//seja, isso acontece sem a interferência de uma thread.
	//A interface Lock junto da classe que a Implementa (ReentrantLock) servem para que determinadsa thread ´possa obter o
	//lock de um método sem precisar usar a plavra reservada synchronized, já em questão de processador tem um alto custo,
	//o método lock serve para o lock ser obtido perla thread, já o unlock serve para o lock ser liberado, unlock deve sempre
	//ser escrito dentro de um bloco finally, já que tal bloco é incondicionalmente executado. O método getAndIncrement precisa
	//estar no mesmo escopo que a variável count
	public void increment() {
		lock.lock();
		try {
			count++;
			atomicInteger.getAndIncrement();
		}
		finally {
			lock.unlock();
		}
	}
	
	public int getCount() {
		return count;
	}
	public int getAtomicInt() {
		return atomicInteger.intValue();
	}
}

class IncrementadorThread extends Thread{
	private Contador contador;
	
	public IncrementadorThread(Contador contador) {
		this.contador = contador;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			contador.increment();
		}
	}
}

public class ConcorrenciaTest {

	public static void main(String[] args) throws InterruptedException {
		
		Contador c = new Contador();
		IncrementadorThread it1 = new IncrementadorThread(c);
		IncrementadorThread it2 = new IncrementadorThread(c);
		it1.start();
		it2.start();
		it1.join();
		it2.join();
		System.out.println(c.getCount());
		System.out.println(c.getAtomicInt());
	}
}

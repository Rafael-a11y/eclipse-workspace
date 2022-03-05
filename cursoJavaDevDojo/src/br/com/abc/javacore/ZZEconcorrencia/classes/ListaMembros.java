package br.com.abc.javacore.ZZEconcorrencia.classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
//newCondition() retorna uma ConditionObject
public class ListaMembros {

	private final Queue<String> emails = new LinkedList<String>();
	private final ReentrantLock lock= new ReentrantLock();
	private final Condition conditionLock = lock.newCondition();
	private boolean aberta = true;
	
	public int getEmailsPendentes() {
		lock.lock();
		try {
			return this.emails.size();
		}
		finally {
			lock.unlock();
		}
	}
	
	public boolean isAberta() {return aberta;}
	//o método wait() serve para liberar o lock da variável email, da lista de Strings, já o await() serve para a mesma coisa
	//Mas como não estamos usando a palavra synchronized e sim um objeto ReentranceLock para obter o lock da VARIÁVEL emails,
	//usa-se o await().
		public String obterEmailMembro() {
			String email = null;
			try {
				lock.lock();
				while(this.emails.size() == 0) {
					if(!aberta) return null;
					System.out.println("Lista vazia, colocando a Thread " + Thread.currentThread().getName() + " em modo wait");
					conditionLock.await();
				}
				email = this.emails.poll();
			}
			catch(InterruptedException  e) {
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
			return email;
	}
	//Usa-se o signalAll() no lugar do notifyAll()
	public void adicionarEmailMembro(String email) {
		lock.lock();
		try {
			this.emails.add(email);
			System.out.println("Email adicionado na lista");
			System.out.println("Notificando as Threads que estão em espera: " + Thread.currentThread().getName()); 
			conditionLock.signalAll();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void fecharLista() {
		System.out.println("Notificando todas as Threads e fechando a lista");
		aberta = false;
		lock.lock();
		try {
			this.emails.notifyAll();
		}
		finally {
			lock.unlock();
		}
	}
}
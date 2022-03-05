package br.com.abc.javacore.ZZDthreads.classes;

import java.util.LinkedList;
import java.util.Queue;

public class ListaMembros {

	private final Queue<String> emails = new LinkedList<String>();
	private boolean aberta = true;
	
	public int getEmailsPendentes() {
		synchronized (emails) {
			return this.emails.size();
		}
	}
	
	public boolean isAberta(){
		return aberta;
	}
	//o método wait() serve para liberar o lock da variável email, da lista de Strings
		String email = null;
		public String obterEmailMembro() {
		try {
			synchronized (this.emails) {
				while(this.emails.size() == 0) {
					if(!aberta) return null;
					System.out.println("Lista vazia, colocando a Thread " + Thread.currentThread().getName() + " em modo wait");
					this.emails.wait();
				}
				email = this.emails.poll();
			}
		}
		catch(InterruptedException  e) {
			e.printStackTrace();
		}
		return email;
	}
	
	public void adicionarEmailMembro(String email) {
		synchronized (this.emails) {
			this.emails.add(email);
			System.out.println("Email adicionado na lista");
			System.out.println("Notificando as Threads que estão em espera: " + Thread.currentThread().getName()); 
			this.emails.notifyAll();
		}
	}
	
	public void fecharLista() {
		System.out.println("Notificando todas as Threads e fechando a lista");
		aberta = false;
		synchronized (this.emails) {
			this.emails.notifyAll();
		}
	}
	
}
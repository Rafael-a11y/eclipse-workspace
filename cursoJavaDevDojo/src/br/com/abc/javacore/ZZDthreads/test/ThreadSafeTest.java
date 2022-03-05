package br.com.abc.javacore.ZZDthreads.test;

import java.util.ArrayList;
import java.util.List;
/*Ter uma lista com métodos sincronizados em uma classe não sincronizada não impede que erros aconteçam, por isso é melhor
 * que os métodos que acessarão a lista sejam sincronizados, porém, ter métodos em uma classe que acessam uma lista sincronizada
 * é redundante, por isso é melhor ter uma lista não sincronizada, porém com métodos sincronizados*/
class ListaNomes{
	//Método da classe Collections que retorna uma lista com métodos syncronized, ou seja, uma lista ThreadSafe.
	List<String> nomes = (new ArrayList<>());
	
	public synchronized void add(String nome) {
		nomes.add(nome);
	}
	
	public synchronized void removerPrimeiro() {
		if(nomes.size() > 0) {
			System.out.println(nomes.remove(0));
		} 
	}
}

public class ThreadSafeTest {

	public static void main(String[] args) {
		
		ListaNomes nome = new ListaNomes();
		nome.add("William Suane");
		class RemovedorDeNomes extends Thread{
			@Override
			public void run () {
				nome.removerPrimeiro();
			}
		}
		//Instâncias de classes internas não precisam de variáveis de referência, ou isso acontece por que são threads?
		new RemovedorDeNomes().start();
		new RemovedorDeNomes().start();
	}
}

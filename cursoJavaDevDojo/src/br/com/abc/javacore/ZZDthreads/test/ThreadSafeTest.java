package br.com.abc.javacore.ZZDthreads.test;

import java.util.ArrayList;
import java.util.List;
/*Ter uma lista com m�todos sincronizados em uma classe n�o sincronizada n�o impede que erros aconte�am, por isso � melhor
 * que os m�todos que acessar�o a lista sejam sincronizados, por�m, ter m�todos em uma classe que acessam uma lista sincronizada
 * � redundante, por isso � melhor ter uma lista n�o sincronizada, por�m com m�todos sincronizados*/
class ListaNomes{
	//M�todo da classe Collections que retorna uma lista com m�todos syncronized, ou seja, uma lista ThreadSafe.
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
		//Inst�ncias de classes internas n�o precisam de vari�veis de refer�ncia, ou isso acontece por que s�o threads?
		new RemovedorDeNomes().start();
		new RemovedorDeNomes().start();
	}
}

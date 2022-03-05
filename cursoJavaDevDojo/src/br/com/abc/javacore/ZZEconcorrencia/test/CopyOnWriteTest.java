package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
//Objeto imutável é aquele cuja classe e campos são finais, ou seja, uma vez criado o objeto, este jamais será mudado, seja
//por método set() ou por herança. Um objeto imutável é por natureza Thread Safe, pois não pode ser mudado por Threads
final class Pessoa{
	private final String nome;
	public Pessoa(String nome) {
		this.nome = nome;
	}
}
//O objeto copyOnWriteArrayList é parcialmente imutável, pois ao adicionar ou excluir um elemento, o array é copiado e mudança
//é implementada posteriormente
//Parece que ao usar o CopyOnWriteArrayList, um novo objeto lista é criado com os valores, neste caso, caso você não use
//o CopyOnWriteArrayList, dará uma ConcurrencyException, pois quando a thread do tipo CopyOnWriteTest for usar o objeto
//Iterator para percorrer e imprimir os elementos do objeto ArrayList, ele vai esperar que todos os elementos que ele recebeu
//junto da Lista estejam presentes, por isso, use CopyOnWriteArrayList para que um objeto cópia seja criado e fornecido no
//lugar da lista, mas caso vocÊ querira usar ArrayList mesmo assim, então envolva a lista sob o Iterator somente após os
//elementos terem sidos removidos, OU ENTÃO NÃO USE ITERATOR, nem CopyOnWriteTest, apenas ArrayList e um for simples :)
public class CopyOnWriteTest implements Runnable{

	private List<Integer> list = new CopyOnWriteArrayList<Integer>();
	
	public CopyOnWriteTest() {
		for(int i = 0; i < 50; i++) {
			list.add(i);
		}
	}
	
	@Override
	public void run() {
		Iterator<Integer> iterator = list.iterator();
		try {
			TimeUnit.SECONDS.sleep(4);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		while(iterator.hasNext()){
			System.out.println(Thread.currentThread().getName() + " " + iterator.next());
		}
	}
	public List<Integer> getList(){
		return list;
	}
	public static void main(String[] args) {
		
		CopyOnWriteTest ct = new CopyOnWriteTest();
		Thread t1 = new Thread(ct);
//		Thread t2 = new Thread(ct);
		Thread removedor = new Thread(new RemoverMembros(ct.getList()));
		t1.start();
//		t2.start();
		removedor.start();
	}
	//Nunca façauma remoção ou adição usando Iterator, pois ocorrerá uma UnsuportedException
	private static class RemoverMembros implements Runnable{
		
		private List<Integer> list;
		
		public RemoverMembros(List<Integer> list) {
			this.list = list;
		}
		
		@Override 
		public void run() {
		
			for(int i = 0; i < 25; i++) {
				System.out.println(Thread.currentThread().getName() + " removeu: " + list.remove(i));
			}
		}
	}
}

package colecoes;

import java.util.LinkedList;
import java.util.Queue;

	public class Fila {
		
		public static void main(String[] args) {
			
			Queue<String> fila = new LinkedList<String>();
			
			fila.add("Ana");		//add() lan�a uma exce��o (erro), caso tente adicionar em uma fila cheia
			fila.offer("Bia");		//offer() retorna false ou true, caso consiga ou n�o consiga 
			fila.add("Carlos");		//adicionar a fila, cheia ou n�o
			fila.offer("Daniel");	
			fila.add("Rafaela");	 
			fila.offer("Gui");
			
			System.out.println(fila.peek());	//Retorna null quando a fila est� vazia
			System.out.println(fila.peek());	//Ambos retornam a cabe�a da lista 
			System.out.println(fila.element());	//element() lan�a uma exce��o (erro) quando a fila est� vazia
			System.out.println(fila.element());
			
			System.out.println(fila.size());
			System.out.println(fila.isEmpty());
//			fila.clear();						//clear() limpa a fila
			System.out.println(fila.poll());	//poll() recupera o cabe�a e o remove da fila,
			System.out.println(fila.remove());	//retorna null caso a fila esteja vazia.
												//remove() tamb�m recupera o cabe�a da fila e o 
												//remove, se difere de poll() no fato
												//de lan�ar uma exce��o caso esteja vazia
			
			
		}
	
	}

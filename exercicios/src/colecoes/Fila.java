package colecoes;

import java.util.LinkedList;
import java.util.Queue;

	public class Fila {
		
		public static void main(String[] args) {
			
			Queue<String> fila = new LinkedList<String>();
			
			fila.add("Ana");		//add() lança uma exceção (erro), caso tente adicionar em uma fila cheia
			fila.offer("Bia");		//offer() retorna false ou true, caso consiga ou não consiga 
			fila.add("Carlos");		//adicionar a fila, cheia ou não
			fila.offer("Daniel");	
			fila.add("Rafaela");	 
			fila.offer("Gui");
			
			System.out.println(fila.peek());	//Retorna null quando a fila está vazia
			System.out.println(fila.peek());	//Ambos retornam a cabeça da lista 
			System.out.println(fila.element());	//element() lança uma exceção (erro) quando a fila está vazia
			System.out.println(fila.element());
			
			System.out.println(fila.size());
			System.out.println(fila.isEmpty());
//			fila.clear();						//clear() limpa a fila
			System.out.println(fila.poll());	//poll() recupera o cabeça e o remove da fila,
			System.out.println(fila.remove());	//retorna null caso a fila esteja vazia.
												//remove() também recupera o cabeça da fila e o 
												//remove, se difere de poll() no fato
												//de lançar uma exceção caso esteja vazia
			
			
		}
	
	}

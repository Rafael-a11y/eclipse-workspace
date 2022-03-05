package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {
	public static void main(String[] args) {
		
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("O pequeno Pr�ncipe");	//Retorna true e adiciona o elemento na pilha
		livros.push("Don Quixote");								//Lan�a uma exce��o, caso n�o seja compat�vel
		livros.push("O Hobbit");	     						//com as restri��es da pilha. push()adiciona
																//a cabe�a da fila, mas n�o retorna nada
		for(String livro : livros) {
			System.out.println(livro);
		}
		
		System.out.println(livros.peek());						//Como se trata de uma pilha, mostra o �ltimo
		System.out.println(livros.element()); 					//a ser inserido na pilha, caso esteja vazia...null
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.pop());						//pop() retorna e exclui o 1� elemento da pilha
		System.out.println(livros.remove());
		
//		livros.size();
//		livros.clear();
//		livros.contains(...);
//		livros.isEmpty();
		
		
	}

}

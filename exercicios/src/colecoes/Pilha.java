package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {
	public static void main(String[] args) {
		
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("O pequeno Príncipe");	//Retorna true e adiciona o elemento na pilha
		livros.push("Don Quixote");								//Lança uma exceção, caso não seja compatível
		livros.push("O Hobbit");	     						//com as restrições da pilha. push()adiciona
																//a cabeça da fila, mas não retorna nada
		for(String livro : livros) {
			System.out.println(livro);
		}
		
		System.out.println(livros.peek());						//Como se trata de uma pilha, mostra o último
		System.out.println(livros.element()); 					//a ser inserido na pilha, caso esteja vazia...null
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.pop());						//pop() retorna e exclui o 1º elemento da pilha
		System.out.println(livros.remove());
		
//		livros.size();
//		livros.clear();
//		livros.contains(...);
//		livros.isEmpty();
		
		
	}

}

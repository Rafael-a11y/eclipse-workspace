package colecoes2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha2 {
	
	public static void main(String[] args) {
		
		Deque<String> livros = new ArrayDeque<>();
		
		livros.add("O Pequeno Príncipe");
		livros.push("Don Quixote");
		livros.push("O Hobbit");
		
		for(String livro: livros) {
			System.out.println(livro);
		}
		
		System.out.println(livros.peek());
		System.out.println(livros.element());
		
		System.out.println(livros.pop());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
//		System.out.println(livros.pop());
		
	}

}

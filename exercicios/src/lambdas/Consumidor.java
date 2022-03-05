package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidor {
	
	public static void main(String[] args) {
		
		//operação que aceita um único argumento de entrada e não retorna nada 
		Consumer<Produto> imprimirNome = p -> System.out.println(p.nome + "!!!");
		
		Produto p1 = new Produto("Caneta", 12.34, 0.09);
		imprimirNome.accept(p1);
		
		Produto p2 = new Produto("Notebook", 2987.99, 0.25);
		Produto p3 = new Produto("Caderno", 19.90, 0.03);
		Produto p4 = new Produto("Borracha", 7.80, 0.18);
		Produto p5 = new Produto("Lápis", 04.39, 0.19);
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);
		
		produtos.forEach(imprimirNome);
		produtos.forEach(p -> System.out.println(p.preco));
		/*method reference, usa-se :: na hora de refernciar
		 *o método, A classe System possui um atributo do tipo
		 *PrintStream chamado out, sendo este static, por este
		 *motivo, ele consegue aceessar o método println() da 
		 *classe printStream, lembrando que em um reference Method
		 *não se usa ()*/
		produtos.forEach(System.out::println);
		
	}
}

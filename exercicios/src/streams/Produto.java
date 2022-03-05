package streams;

import java.util.Scanner;
import java.util.function.Function;

public class Produto {
	String nome;
	double preco;
	double desconto;
	double frete;
	
	Produto(String nome, double preco, double desconto, double frete){
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.frete = frete;
		if(preco <= 0) {
			Scanner entrada = new Scanner(System.in);
			System.out.print("O valor digitado � inv�lido, entre com\n"
					+ "um novo valor v�lido de pre�o: ");
			this.preco = entrada.nextDouble();
		}
		
	}
	
}

package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor {
	
	public static void main(String[] args) {
		
		/*Supplier ou Fornecedor, é uma função que não recebe nenhum parâmetro e retorna
		 * um resultado. Em relação à função lambda, usa-se o () quando a função não recebe
		 * nenhum parâmetro, ou quando há mais de dois parâmetros*/
		Supplier<List<String>> umaLista = () -> Arrays.asList("Ana", "Bia", "Lia", "Gui");
		System.out.println(umaLista.get());
	}

}

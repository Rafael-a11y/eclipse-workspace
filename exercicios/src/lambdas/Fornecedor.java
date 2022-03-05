package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Fornecedor {
	
	public static void main(String[] args) {
		
		/*Supplier ou Fornecedor, � uma fun��o que n�o recebe nenhum par�metro e retorna
		 * um resultado. Em rela��o � fun��o lambda, usa-se o () quando a fun��o n�o recebe
		 * nenhum par�metro, ou quando h� mais de dois par�metros*/
		Supplier<List<String>> umaLista = () -> Arrays.asList("Ana", "Bia", "Lia", "Gui");
		System.out.println(umaLista.get());
	}

}

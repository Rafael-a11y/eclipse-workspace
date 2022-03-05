package lambdas;

import java.util.function.Predicate;
import lambda.teste.ParaTeste;
public class Predicado {
	
	public static void main(String[] args) {
		
		//recebe um argumento e retorna um valor
		//vari�vel isCaro recebe uma lambda que tem como par�metro
		//um produto e verifica se ele � caro ou barato
		//o retorno � do tipo booleano, ou seja, false, ou true
		/*Representa um predicado (fun��o com valor booleano) de um argumento.*/
		Predicate<Produto> isCaro = parametroProduto -> 
		(parametroProduto.preco * (1 - parametroProduto.desconto)) >=750;
		
		Produto produto = new Produto("Notebook", 3893.89, 0.15);
		
		System.out.println(isCaro.test(produto));
//		System.out.println(isCaro);
		//ParaTeste::trueOrFalse();
		
	}

}

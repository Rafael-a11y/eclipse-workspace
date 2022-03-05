package lambdas;

import java.util.function.Predicate;

public class PredicadoComposicao {
	
	public static void main(String[] args) {
		
		/*Predicate é uma função que recebe um parâmetro e retorna verdadeiro ou falso*/
		Predicate<Integer> isPar = num -> num % 2 == 0;
		Predicate<Integer> isTresDigitos = num -> num >=100 && num <=999;
		
		/*teste() é um método abstrato da interface funcional Predicate, que serve para
		 * ligar a função ao parâmetro. Já o and(), or() sãoo métodos padrão da Interface,
		 * e o método abstract test() deve ser o último a ser chamado na instância de código,
		 * pois ele será o responsável por aplicar o parâmetro ao método isPar() e dar início
		 * à cadeia de funções*/
		System.out.println(isPar.and(isTresDigitos).negate().test(123));
		
	}
}

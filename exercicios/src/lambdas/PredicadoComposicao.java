package lambdas;

import java.util.function.Predicate;

public class PredicadoComposicao {
	
	public static void main(String[] args) {
		
		/*Predicate � uma fun��o que recebe um par�metro e retorna verdadeiro ou falso*/
		Predicate<Integer> isPar = num -> num % 2 == 0;
		Predicate<Integer> isTresDigitos = num -> num >=100 && num <=999;
		
		/*teste() � um m�todo abstrato da interface funcional Predicate, que serve para
		 * ligar a fun��o ao par�metro. J� o and(), or() s�oo m�todos padr�o da Interface,
		 * e o m�todo abstract test() deve ser o �ltimo a ser chamado na inst�ncia de c�digo,
		 * pois ele ser� o respons�vel por aplicar o par�metro ao m�todo isPar() e dar in�cio
		 * � cadeia de fun��es*/
		System.out.println(isPar.and(isTresDigitos).negate().test(123));
		
	}
}

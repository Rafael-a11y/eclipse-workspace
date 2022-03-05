package lambdas;

import java.util.function.UnaryOperator;

public class OperadorUnario {

	public static void main(String[] args) {
		 
		/*Representa uma opera��o em um �nico operando que produz um resultado do mesmo
		 * tipo de seu operando.UnaryOperator recebe um operando e retorna um valor de
		 *  mesmo tipo*/
		UnaryOperator<Integer> maisDois = n -> n + 2;
		UnaryOperator<Integer> vezesDois = n -> n * 2;
		UnaryOperator<Integer> aoQuadrado = n -> n * n;
		
		int resultadoFinal = maisDois.andThen(vezesDois).andThen(aoQuadrado).apply(3);
		System.out.println(resultadoFinal);
		
		/*O m�todo compose tem um comportamento semelhante ao de andThen(), a diferen�a �
		 * compose() recebe de par�metro, o m�todo que edve ser executado antes,, e n�o
		 * depois*/
		int resultadoFinal2 = aoQuadrado.compose(vezesDois).compose(maisDois).apply(3);
		System.out.println(resultadoFinal2);
		
	}
}

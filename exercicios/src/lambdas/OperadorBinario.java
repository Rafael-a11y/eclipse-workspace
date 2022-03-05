package lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperadorBinario {
	
	public static void main(String[] args) {
		
		/*BinaryOperator recebe 2 operandos de mesmo tipo e retorna um valor do mesmo tipo
		 * dos 2 operandos*/
		BinaryOperator<Double> media = (n1,n2) -> (n1 + n2) / 2;
		System.out.println(media.apply(9.8, 5.7));
		
		BiFunction<Double, Double, String> resultado  = (n1,n2) -> {
			double notaFinal = (n1 + n2 / 2);
			return notaFinal >= 7 ? "Aprovado" : "Reprovado";
		};
		System.out.println(resultado.apply(20.0, 3000.0));
		
		Function<Double, String> conceito = (m) -> m >= 7 ? "Aprovado" : "Reprovado";
		System.out.println(media.andThen(conceito).apply(9.7, 4.1));
	}

}

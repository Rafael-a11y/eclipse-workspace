package lambdas;

import java.util.function.BinaryOperator;

public class CalculoTeste3Revisao {
	
	public static void main(String[] args) {
		
		BinaryOperator<Double> calc = (x, y) ->  x * y;//Interface que recebe 2 operandos e retorna um
		System.out.println(calc.apply(3.0, 5.0));		//resultado de mesm,o tipo dos operandos
		/*Pode ser de tipo wrappers diferentes, mas o n�mero de dados de par�metros tem que ser 2,
		 * e o resultado deve ser de mesmo tipo.*/
		
		BinaryOperator<String> concat = (s1, s2) -> s1 + s2;
		
		System.out.println(concat.apply("Ol�, eu sou o ", "Boneco Josias"));
		
		
	}

}

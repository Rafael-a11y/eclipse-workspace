package lambdas;

import java.util.function.BinaryOperator;

public class CalculoTeste3 {
	
	public static void main(String[] args) {
		
		//double -> int não é permitido
		//double -> Double é válido
	/*BinaryOperatorRepresenta uma operação sobre dois operandos do
	 *  mesmo tipo, produzindo um resultado do mesmo tipo que os
	 *  operandos*/
		BinaryOperator<Double> calc = (x, y) -> {return x + y;};
		System.out.println(calc.apply(2.0, 3.0));
		
		calc = (x, y) -> x * y;
		System.out.println(calc.apply(2.0, 3.0));
		
		BinaryOperator<Integer> calc2 = (x, y) -> {return x + y;};
		System.out.println(calc2.apply(2, 3));
		
		calc2 = (x, y) -> x * y;
		System.out.println(calc2.apply(2, 3));
		
//		System.out.println(calc.legal());
//		System.out.println(Calculo.muitoLegal());	//Por ser static, precisa ser acessado a partir da classe
	}

}

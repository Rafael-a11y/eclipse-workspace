package lambdas;

public class CalculoTeste2 {
	
	public static void main(String[] args) {
		
		Calculo calc = (x, y) -> {return x + y;}; //Usa-se ; no final, não por ser uma lambda, mas por 
		System.out.println(calc.executar(2, 3));	//ser final de sentença de código
		
		calc = (x, y) -> x * y;
		System.out.println(calc.executar(2, 3)); ///tiro o return e as chaves;
		
		System.out.println(calc.legal());
		System.out.println(Calculo.muitoLegal());	//Por ser static, precisa ser acessado a partir da classe
	}

}

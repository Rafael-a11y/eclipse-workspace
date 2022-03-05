package lambdas;

public class TesteLambda {
	
	public static void main(String[] args) {
		
		Calculo calc = (x, y) -> {return x + y;};
		/*não é possível instanciar o tipo Calculo, pois se trata de uma interface
		e não de uma classe, taão pouco a mesma pode ter uma variável com valor literal. Mas, pode ter
		uma variável preenchida com expressão lambda que é uma expressão que chama outra */
		
		System.out.println(calc.executar(3, 3));
		calc = (x, y) -> {return x / y;}; //Implementa a função executar da interface Calculo
		System.out.println(calc.executar(100, 2));
//		LambdaObjeto lamb = (x, y, z) -> {return x * y * z;};//classe abstrata não podem ser funcionai
//		LambdaObjeto filhoDeLambda = new LambdaObjetoFilho();
		//Classe abstrata não consegue instanciar um objeto de seu tipo 
//		System.out.println(filhoDeLambda.calcularLambda(10, 10, 10));
		//Caso eu crie um filho de classe abstrata e tente chamar e executar um método abstrato herdado
		//por herança sem ter implementado-o na classe concreta filha, lança uma exceção
			
		/*Não é possível criar uma lambda a partir de tipo de uma classe abstrata*/
		
		Calculo calculo = (x, y) -> x - y;
		System.out.println(calculo.executar(10, 7));
		
		int numero = 20;
		int teste = numero >= 10 ? 20 : 10;
		System.out.println(teste);
		
		
	}
	
	

}

package lambdas;

public class TesteLambda {
	
	public static void main(String[] args) {
		
		Calculo calc = (x, y) -> {return x + y;};
		/*n�o � poss�vel instanciar o tipo Calculo, pois se trata de uma interface
		e n�o de uma classe, ta�o pouco a mesma pode ter uma vari�vel com valor literal. Mas, pode ter
		uma vari�vel preenchida com express�o lambda que � uma express�o que chama outra */
		
		System.out.println(calc.executar(3, 3));
		calc = (x, y) -> {return x / y;}; //Implementa a fun��o executar da interface Calculo
		System.out.println(calc.executar(100, 2));
//		LambdaObjeto lamb = (x, y, z) -> {return x * y * z;};//classe abstrata n�o podem ser funcionai
//		LambdaObjeto filhoDeLambda = new LambdaObjetoFilho();
		//Classe abstrata n�o consegue instanciar um objeto de seu tipo 
//		System.out.println(filhoDeLambda.calcularLambda(10, 10, 10));
		//Caso eu crie um filho de classe abstrata e tente chamar e executar um m�todo abstrato herdado
		//por heran�a sem ter implementado-o na classe concreta filha, lan�a uma exce��o
			
		/*N�o � poss�vel criar uma lambda a partir de tipo de uma classe abstrata*/
		
		Calculo calculo = (x, y) -> x - y;
		System.out.println(calculo.executar(10, 7));
		
		int numero = 20;
		int teste = numero >= 10 ? 20 : 10;
		System.out.println(teste);
		
		
	}
	
	

}

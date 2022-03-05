package br.com.abc.javacore.ZZHlambdas.test;

import java.util.function.Predicate;

import br.com.abc.javacore.ZZGcomportamentoporparametro.classes.Carro;
import br.com.abc.javacore.ZZHlambdas.interfaces.CarroPredicate;

public class LambdaTest {
	//an�nima
	//function
	//passada por a�
	//concisa
	//Voc� usa uma laambda quando existe uma interface funcional, onde existir uma interface funcional, voc� pode substituir por uma lambda
	public static void main(String[] args) {
		CarroPredicate carroPredicate = new CarroPredicate() {
			
			@Override
			public boolean test(Carro carro) {
				// TODO Auto-generated method stub
				return carro.getCor().equalsIgnoreCase("verde");
			}
		};
		//Usando lambda, o tipo que guarda a fun��o deve ser do tipo da classe, no  caso, CarroPredicate, mesmo usando uma
		//vari�vel para guardar a fun��o, precisa chamar o m�todo a ser implementado. Agora repare que mesmo trocando de
		//interface, usando a interface Predicate, o resultado continua sendo exatamente o mesmo, isso acontece por conta do
		//target type que � o que a lambda espera receber, no caso os T arguments, e o functional descriptor � o que de fato
		//vai ser usado
		CarroPredicate carroPredicate2 = (Carro carro) -> carro.getCor().equalsIgnoreCase("verde");
		System.out.println(carroPredicate2.test(new Carro("verde", 2012)));
		Runnable runnable = () -> System.out.println("Dentro do run");
		new Thread(runnable).start();
		
	}
}

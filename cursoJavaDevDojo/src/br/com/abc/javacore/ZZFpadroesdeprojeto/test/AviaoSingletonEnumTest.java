package br.com.abc.javacore.ZZFpadroesdeprojeto.test;
/*Enums s�o �timos para o padr�o Singleton, pois n�o se aplicam a Reflection, e s�o threadSafe, CASO TENTE REFLETIR OBJETOS
 * enum, lan�a uma IllegalArgumentException. Sempre que voc� precisar apenas de um �nico objeto, use o padr�o Singleton, muito
 * usado em FrameWorks que criam logs.*/
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.AviaoSingletonEnum;

public class AviaoSingletonEnumTest {

	public static void main(String[] args) {
		
		AviaoSingletonEnum.agendarAssento("1A");
		AviaoSingletonEnum.agendarAssento("1A");
		AviaoSingletonEnum.agendarAssento("1C");
		
	}

}

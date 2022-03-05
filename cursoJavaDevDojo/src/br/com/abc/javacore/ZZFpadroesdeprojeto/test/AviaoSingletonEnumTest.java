package br.com.abc.javacore.ZZFpadroesdeprojeto.test;
/*Enums são ótimos para o padrão Singleton, pois não se aplicam a Reflection, e são threadSafe, CASO TENTE REFLETIR OBJETOS
 * enum, lança uma IllegalArgumentException. Sempre que você precisar apenas de um único objeto, use o padrão Singleton, muito
 * usado em FrameWorks que criam logs.*/
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.AviaoSingletonEnum;

public class AviaoSingletonEnumTest {

	public static void main(String[] args) {
		
		AviaoSingletonEnum.agendarAssento("1A");
		AviaoSingletonEnum.agendarAssento("1A");
		AviaoSingletonEnum.agendarAssento("1C");
		
	}

}

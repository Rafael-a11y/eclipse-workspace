package br.com.abc.javacore.ZZFpadroesdeprojeto.test;
/*Na linha 17 foi preciso fazer um cast, na linha 15 usa-se o método setAccesible para podermos usar o método newInstance, pois
 * o construtor da classe AviaoSingleton é privando, mas usando o setAccesible, podemos suprimir o verificador de acesso do
 * construtor quando formos criaar um novo objeto com o newInstance, newInstance pode lançar várias Exceptions verificadas,
 * na linha 20, o padrãao Singlenton é quebrado, pois estamos acessando o contrutor privado e instanciando novos objetos*/
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Aviao;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.AviaoSingleton;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.AviaoSingletonEnum;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class AviaoSingletonTest {
	public static void main(String[] args) {
		agendarAssento("1A");
		agendarAssento("1A");
		AviaoSingleton aviaoSingleton = AviaoSingleton.getINSTANCE();
		AviaoSingleton aviaoSingleton2 = null;
		Constructor constructors[] = AviaoSingletonEnum.class.getDeclaredConstructors();
		for(Constructor constructor : constructors) {
			constructor.setAccessible(true);
			try {
				aviaoSingleton2 =  (AviaoSingleton) constructor.newInstance();
				break;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(aviaoSingleton.hashCode());
		System.out.println(aviaoSingleton2.hashCode());
	}
	
	public static void agendarAssento(String assento) {
		AviaoSingleton a = AviaoSingleton.getINSTANCE();
		System.out.println(a.bookAssento(assento));
	}
}

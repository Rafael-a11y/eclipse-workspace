package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;
/*Todos os construtores de Enum são private*/
import java.util.HashSet;
import java.util.Set;

public enum AviaoSingletonEnum {
	
	INSTANCE, TESTE;
	Set<String> assentosDisponiveis;
	
	
	private AviaoSingletonEnum(){
		this.assentosDisponiveis = new HashSet<String>();
		assentosDisponiveis.add("1A");
		assentosDisponiveis.add("1B");
		assentosDisponiveis.add("1C");
	}
	
	public boolean bookAssento(String assento) {
		return assentosDisponiveis.remove(assento);
	}
	//Criando uma instância de Enum, não se usa a palvra new, nem (), apenas o nome da classe Enum seguido do atributo Enum
	//Automaticamente, o Java entende que se trata de uma intância
	public static void agendarAssento(String assento) {
		AviaoSingletonEnum a = AviaoSingletonEnum.TESTE;
		System.out.println(a.bookAssento(assento));
	}
}

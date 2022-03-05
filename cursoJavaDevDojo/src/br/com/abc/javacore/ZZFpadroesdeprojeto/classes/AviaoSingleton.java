package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

public class AviaoSingleton {
	//E se ele não for estático nem final
	//Eager inicialization = quando instanciamos um objeto como membro estatico de uma classe, também há o LAZY INICIALIZATION,
	//que é quando nós instanciamos o objeto apenas se formos usá-lo, assim não precisamos ficar carregando-o na memória o tempo
	//inteiro, somente quando formos usá-lo.
//	private static final AviaoSingleton INSTANCE = new AviaoSingleton();
	private static AviaoSingleton INSTANCE;
	private Set<String> assentosDisponiveis;
	//LAZY INICIALIZATION -> Por precaução, use o lock da classe e não da instância
	public static AviaoSingleton getINSTANCE() {
		if(INSTANCE == null) {
			synchronized(AviaoSingleton.class) {
				if(INSTANCE == null) INSTANCE = new AviaoSingleton();
			}
		}
		return INSTANCE; 
	}
	
	private AviaoSingleton() {
		this.assentosDisponiveis = new HashSet<>();
		assentosDisponiveis.add("1A");
		assentosDisponiveis.add("1B");
	}
	
	public boolean bookAssento(String assento) {
		return assentosDisponiveis.remove(assento);
	}
}

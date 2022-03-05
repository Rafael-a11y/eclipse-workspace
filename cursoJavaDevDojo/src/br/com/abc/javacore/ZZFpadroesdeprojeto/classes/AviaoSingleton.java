package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

public class AviaoSingleton {
	//E se ele n�o for est�tico nem final
	//Eager inicialization = quando instanciamos um objeto como membro estatico de uma classe, tamb�m h� o LAZY INICIALIZATION,
	//que � quando n�s instanciamos o objeto apenas se formos us�-lo, assim n�o precisamos ficar carregando-o na mem�ria o tempo
	//inteiro, somente quando formos us�-lo.
//	private static final AviaoSingleton INSTANCE = new AviaoSingleton();
	private static AviaoSingleton INSTANCE;
	private Set<String> assentosDisponiveis;
	//LAZY INICIALIZATION -> Por precau��o, use o lock da classe e n�o da inst�ncia
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

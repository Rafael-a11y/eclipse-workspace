package br.com.abc.javacore.ZZFpadroesdeprojeto.classes;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Moeda.Real;

public class MoedaFactory {
	public static Moeda criarMoeda(Pais pais) {
		if(pais.equals(Pais.BRASIL)) {
			return new Real();
		}
		else if(pais.equals(Pais.EUA)) {
			return new U$Dolar();
		}
		throw new IllegalArgumentException("Não existe este país");
	}
	
}

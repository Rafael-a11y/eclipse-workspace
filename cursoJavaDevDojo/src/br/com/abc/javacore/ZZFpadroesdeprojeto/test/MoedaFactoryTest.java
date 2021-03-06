package br.com.abc.javacore.ZZFpadroesdeprojeto.test;

import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Moeda;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.MoedaFactory;
import br.com.abc.javacore.ZZFpadroesdeprojeto.classes.Pais;

public class MoedaFactoryTest {

	public static void main(String[] args) {
		Moeda moeda = MoedaFactory.criarMoeda(Pais.BRASIL);
		Moeda moeda2 = MoedaFactory.criarMoeda(Pais.EUA);
		System.out.println(moeda2.getSimbolo());
		System.out.println(moeda.getSimbolo());
	}

}

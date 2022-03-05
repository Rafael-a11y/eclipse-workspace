package br.com.abc.javacore.ZZAGenerics.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.abc.javacore.ZZAGenerics.classes.Carro;
import br.com.abc.javacore.ZZAGenerics.classes.Computador;

public class ClasseGenericaTest {

	public static void main(String[] args) {
		List<Carro> carrosDisponiveis = new ArrayList<>();
		carrosDisponiveis.add(new Carro("Gol"));
		carrosDisponiveis.add(new Carro("BMW"));
		ObjetosAlugaveis<Carro> carroAlugavel = new ObjetosAlugaveis<>(carrosDisponiveis);
		Carro carro = carroAlugavel.getObjetoDisponivel();
		System.out.println("Usando o carro por um mês");
		carroAlugavel.devolverObjeto(carro);
		System.out.println("------------------------------------------------------------------------------------------------"
				+ "---------------");
		List<Computador> computadoresDisponiveis = new ArrayList<>();
		computadoresDisponiveis.add(new Computador("AlienWare"));
		computadoresDisponiveis.add(new Computador("HP"));
		ObjetosAlugaveis<Computador> computadorAlugavel = new ObjetosAlugaveis<>(computadoresDisponiveis);
		Computador computador = computadorAlugavel.getObjetoDisponivel();
		System.out.println("Usando ");
		computadorAlugavel.devolverObjeto(computador);
	}

}
//Type
class ObjetosAlugaveis<T>{
	
	//Declarando que o tipo vai existir, sempre deve ser declarado no generics
	private List<T> objetosDisponiveis;
	//Usando o comparator, que é uma interface funcional, pois possui apenas um método abstrato, tem o equals(), mas este
	//é herdado dew Object, não é próprio da interface, e sim , uma interfacxe herda de Object também, as lambdas podem ser
	//usadas com qualquer interface funcional
//	private Comparator<String> comparator = (s1, s2) -> {return Integer.compare(s1.length(), s2.length());}; 
	Object obj;
	
	public ObjetosAlugaveis(List<T> objetosDisponiveis) {
		this.objetosDisponiveis = objetosDisponiveis;
	}
	
	public T getObjetoDisponivel() {
		T t = objetosDisponiveis.remove(0);
		System.out.println("Alugando objeto: " + t);
		System.out.println("Objetos disponíveis: " + objetosDisponiveis); 
		return t;
	}
	
	public void devolverObjeto(T t) {
		System.out.println("Devolvendo objeto: " + t);
		objetosDisponiveis.add(t);
		System.out.println("Objetos disponíveis: " + objetosDisponiveis); 
	}
}

class DoiAtributos<T, X>{
	T um;
	X dois;
	public DoiAtributos(T um, X dois) {
		this.um = um;
		this.dois = dois;
	}
	public T getUm() {
		return um;
	}
	public void setUm(T um) {
		this.um = um;
	}
	public X getDois() {
		return dois;
	}
	public void setDois(X dois) {
		this.dois = dois;
	}
}

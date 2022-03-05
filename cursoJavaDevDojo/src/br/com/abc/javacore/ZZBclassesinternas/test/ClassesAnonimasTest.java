package br.com.abc.javacore.ZZBclassesinternas.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.abc.javacore.ZZAGenerics.classes.Carro;

class Animal{
//	String nome = "fafa";
	
	public void andar() {
		System.out.println("Andando");
	}
	
//	public String getNome() {
//		return nome;
//	}
}

public class ClassesAnonimasTest {
	/*Classes anônimas são boas para sobrescrever um método sem ter que criar uma nova classe persistente para servir de
	 * herdeira. O que acontece é que chamamos pela variável de referência "a", o método comer, mas o que vai ser executado
	 * é o método sobrescrito do objeto anônimo, sendo assim, se você tentar criar um método e/ou atributo que não exista
	 * na classe original, tal método nunca será chamado, pois o que acontece de verdade é o polimorfismo*/
	public static void main(String[] args) {
		/*Classe anônima -> new Object(){};*/
		Animal a = new Animal() {
//			String nome = "Israel"; 
			public void andar() {
				System.out.println("Andando anonimamente");
			}
		};
		a.andar();
		
		List<Carro> carroList = new ArrayList<Carro>();
		carroList.add(new Carro("BMW"));
		carroList.add(new Carro("Audi"));
		/*Objeto anônimo que implementa Comparator -> (new Object<Carro>(){});*/
//		Collections.sort(carroList, new Comparator<Carro>() {
//			@Override
//			public int compare(Carro o1, Carro o2) {
//				// TODO Auto-generated method stub
//				return o1.getNome().compareTo(o2.getNome());
//			}
//		});
		/*Usando uma Function para substituir o trabalho pesado hihi*/
		Collections.sort(carroList, (o1, o2) -> o1.getNome().compareTo(o2.getNome()));
		System.out.println(carroList);
	}
}

class CarroComparator implements Comparator<Carro>{

	@Override
	public int compare(Carro o1, Carro o2) {
		// TODO Auto-generated method stub
		return o1.getNome().compareTo(o2.getNome());
	}
	
}
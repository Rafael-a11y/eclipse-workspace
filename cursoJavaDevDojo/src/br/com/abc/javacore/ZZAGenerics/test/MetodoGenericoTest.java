package br.com.abc.javacore.ZZAGenerics.test;

import java.util.ArrayList;
import java.util.List;

import br.com.abc.javacore.ZZAGenerics.classes.Carro;

public class MetodoGenericoTest {

	public static void main(String[] args) {
		List<Cachorro> cachorros;
		Animal cachorro2 = new Cachorro();
		
//		criarArray(new Cachorro());
//		cachorros = criarArray2(new Cachorro());
//		System.out.println(cachorros);
		criarArray3(cachorro2);
	}
	
	public static <T> void criarArray(T t) {
		List<T> lista = new ArrayList<T>();
		lista.add(t);
		System.out.println(lista);
	}
	public static <T> List<T> criarArray2(T t) {
		List<T> lista = new ArrayList<T>();
		lista.add(t);
		return lista;
	}
	/*Aceita qualquer classe filha de animal*/
	public static <T extends Animal> void criarArray3(T t) {
		List<T> lista = new ArrayList<T>();
		lista.add(t);
		System.out.println(lista);
	}

}

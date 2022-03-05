package br.com.abc.javacore.ZZAGenerics.test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		lista.add("String");
		lista.add("String");
		lista.add("William Suane");
		
		for(String obj: lista) {
			System.out.println(obj);
		}
		
		add(lista, 1L);
		
		for(String obj: lista) {
			System.out.println(obj);
		}
	}
	
	public static void add(List lista, Long l) {
		lista.add(l.toString());
	}

}

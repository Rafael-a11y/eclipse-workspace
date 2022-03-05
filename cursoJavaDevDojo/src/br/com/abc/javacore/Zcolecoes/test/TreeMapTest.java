package br.com.abc.javacore.Zcolecoes.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import br.com.abc.javacore.Zcolecoes.classes.Consumidor;

public class TreeMapTest {

	public static void main(String[] args) {
		
		NavigableMap<String, String> map = new TreeMap<>();
//		Consumidor consumidor = new Consumidor("William Suane", "122");
//		Consumidor consumidor2 = new Consumidor("DevDojo", "321");
		map.put("A", "letra A");
		map.put("B", "letra B");
		map.put("C", "letra C");
		map.put("D", "letra D");
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());	
		}
		System.out.println(map.headMap("D", true));
		System.out.println(map.ceilingKey("C"));
		System.out.println(map.higherKey("C"));
		System.out.println(map.descendingKeySet());
	}

}

package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcorrenciaDeColecoesTest {

	public static void main(String[] args) {
		/*Essas classes permitem concorrência para uma coleção, sem precisar criar várias cópias para manipulação
		 * ConcurrentHashMap -> putIfAbsent, remove, replace, tais métodos a partir do Java 8, estão presentes na Interface
		 * Map, como método defaults
		 * ConcurrentLinkedDequeue -> Mesma coisa de LinkedDequeue, porém ThreadSafe e tem métodos para badicionar primeiro, e último
		 * ConcurrentLinkedQueue -> Mesma coisa LinkedQueue, porémm ThreadSafe e com métodos parea adicionar o primeiro, e último
		 * ConcurrentSkipListMap -> é sortido, ordenado, ou seja, é obrigado a implementar Comparable ou passar um objeto Comparator
		 * ConcurrentSkipListSet -> é sortido, ordenado, ou seja, é obrigado a implementar Comparable ou passar um objeto Comparator*/
		ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
		System.out.println(map.put("1", "feijao"));
		//Só insere se a chave não existir
		System.out.println(map.putIfAbsent("1", "arroz"));
		System.out.println(map.get("1"));
		Map<String, String> map1= new HashMap<>();
		map1.putIfAbsent("1", "Rafael");
//		wekly consistance = fracamente consistente
	}

}

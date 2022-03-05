package br.com.abc.javacore.ZZEconcorrencia.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcorrenciaDeColecoesTest {

	public static void main(String[] args) {
		/*Essas classes permitem concorr�ncia para uma cole��o, sem precisar criar v�rias c�pias para manipula��o
		 * ConcurrentHashMap -> putIfAbsent, remove, replace, tais m�todos a partir do Java 8, est�o presentes na Interface
		 * Map, como m�todo defaults
		 * ConcurrentLinkedDequeue -> Mesma coisa de LinkedDequeue, por�m ThreadSafe e tem m�todos para badicionar primeiro, e �ltimo
		 * ConcurrentLinkedQueue -> Mesma coisa LinkedQueue, por�mm ThreadSafe e com m�todos parea adicionar o primeiro, e �ltimo
		 * ConcurrentSkipListMap -> � sortido, ordenado, ou seja, � obrigado a implementar Comparable ou passar um objeto Comparator
		 * ConcurrentSkipListSet -> � sortido, ordenado, ou seja, � obrigado a implementar Comparable ou passar um objeto Comparator*/
		ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
		System.out.println(map.put("1", "feijao"));
		//S� insere se a chave n�o existir
		System.out.println(map.putIfAbsent("1", "arroz"));
		System.out.println(map.get("1"));
		Map<String, String> map1= new HashMap<>();
		map1.putIfAbsent("1", "Rafael");
//		wekly consistance = fracamente consistente
	}

}

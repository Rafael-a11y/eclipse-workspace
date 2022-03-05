package br.com.abc.javacore.Zcolecoes.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		/*No Map ao tentar escrever uma chave duplicada, a outra � sobrescrita. HashMap n�o mant�m a ordem de inser��o, j� o
		 * LinkedHashMap() mant�m a ordem de inser��o */
		Map<String, String> map = new LinkedHashMap<>();
		map.put("teklado", "teclado");
		map.put("mouze", "mouse");
		map.put("vc", "voc�");
		map.put("Mesa", "mesa");
		//values() para valores e keySet() para as chaves
//		for(String key : map.values()) {
//			System.out.println(key);
//		}
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
			
		}
	}
	
}

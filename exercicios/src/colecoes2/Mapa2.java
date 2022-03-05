package colecoes2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa2 {
	
	public static void main(String[] args) {
		
		Map<Integer, String> usuarios = new HashMap<>();
		
		usuarios.put(1, "Roberto");
		usuarios.put(20, "Ricardo");
		usuarios.put(03, "Rafaela");
		usuarios.put(04, "Rebeca");
		
		System.out.println("E o tamanho?" + usuarios.size());
		System.out.println("Está vazio?" + usuarios.isEmpty());
		
		System.out.println("Mostre as chaves: " + usuarios.keySet());
		System.out.println("Mostre os valores: " + usuarios.values());
		System.out.println("Mostre as chaves e valores " + usuarios.entrySet());
		
		System.out.println("Tem a chave? " + usuarios.containsKey(20));
		System.out.println("Tem o valor?" + usuarios.containsValue("Rebeca"));
		
		System.out.println("Mostra o valor referenciado pela chave: " + usuarios.get(04));
		
		for(int chave: usuarios.keySet()) {
			System.out.println(chave);
		}
		
		for(String valor: usuarios.values()) {
			System.out.println(valor);
		}
		
		for(Entry<Integer, String> registro: usuarios.entrySet()) {
			System.out.print(registro.getKey() + " -> ");
			System.out.println(registro.getValue());
		}
		
	}

}

package colecoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {
	
	public static void main(String[] args) {
		
		Map<Integer, String> usuarios = new HashMap<Integer, String>();
		
		usuarios.put(1, "Roberto"); 
		usuarios.put(20, "Ricardo");
		usuarios.put(3, "Rafaela");
		usuarios.put(4, "Rebeca");
		
		/*put() significa colocar, também substitui valores, exemplo: put(1, "Rafael);
		 * -> put(1, "Alberto");*/
		
		System.out.println(usuarios.size()); //Mostra o tamanho da colection
		System.out.println(usuarios.isEmpty());//Retorna false ou true, caso tenha algum valor, retorna false
		
		System.out.println(usuarios.keySet());//retorna o conjunto das chaves, de forma desordenada
		System.out.println(usuarios.values());//Retorna os valores, de forma desordenada
		System.out.println(usuarios.entrySet());//Retorna as chaves e seus valores de forma homogênea
		
		System.out.println(usuarios.containsKey(20));//Retorna false ou true, verifica se a chave  está presente
		System.out.println(usuarios.containsValue("Rebeca"));//Retorna false ou true, verifica se o valor está presente
		
		System.out.println(usuarios.get(20));//Retorna o valor da chave especificada, ou null, caso não exista
		
		for(Integer chave: usuarios.keySet()) {
			System.out.println(chave);//Percorre o conjunto de chaves
		}
		
		for(String valor: usuarios.values()) {
			System.out.println(valor);//Percorre os valores 
		}
		
		for(Entry<Integer, String> registro : usuarios.entrySet()) {
			//Percorre o conjunto das chaves junto de seus valores
			//Precisa importar java.util.Map.Entry
			System.out.print(registro.getKey() + " -> ");
			System.out.println(registro.getValue());
			//getKey() e getValue() estão dentro de Entry
		}
		
		System.out.println(usuarios.remove(1));//Retorna o valor e remove o valor e chave pelo valor inteiro 
		//especificado, caso não exista, retorna null e não os remove
		System.out.println(usuarios.remove(4, "Rebeca"));//Retorna true ou false, exclui chave e valor, caso a
		//chave ou valor associado esteja errada, retorna false e não os exclui
		
		for(Entry<Integer, String> registro : usuarios.entrySet()) {
			System.out.print(registro.getKey() + " -> ");
			System.out.println(registro.getValue());
		}
		
		
	}

}

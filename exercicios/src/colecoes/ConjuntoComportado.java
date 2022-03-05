package colecoes;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjuntoComportado {
	
	public static void main(String[] args) {
		
//		Set<String> listaAprovados = new HashSet<>();		//A collection lista obrigatoriamente é udo tipo String 
		SortedSet<String> listaAprovados = new TreeSet<>();		//A collection lista obrigatoriamente é udo tipo String 
		listaAprovados.add("Ana");
		listaAprovados.add("Carlos");
		listaAprovados.add("Luca");
		listaAprovados.add("Pedro");
		
		for (String candidato: listaAprovados ) {
			System.out.println(candidato);
		}
		
		System.out.println();
		
		Set<Integer> nums = new HashSet<>();
		nums.add(1);
		nums.add(2);
		nums.add(120);
		nums.add(6);
		
		for (int n: nums) {
			System.out.println(n);
		}
		/*TreeSet imprime na ordem de inserção, e tem um import diferente, está
		 * dentro de SortedSet. */
		
	}

}

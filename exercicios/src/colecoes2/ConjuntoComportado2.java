package colecoes2;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjuntoComportado2 {

	public static void main(String[] args) {
		
//		Set<String> listaCandidatos = new HashSet<String>();
		SortedSet<String> listaCandidatos = new TreeSet<String>();
		
		listaCandidatos.add("Ana");
		listaCandidatos.add("Carlos");
		listaCandidatos.add("Luca");
		listaCandidatos.add("Pedro");
		
		for (String candidatos: listaCandidatos) {
			System.out.println(candidatos);
		}
		
		Set<Integer> nums = new HashSet<>();
		nums.add(001);
		nums.add(002);
		nums.add(120);
		nums.add(006);
		
		for(int n: nums) {
			System.out.println(n);
		}
	}
}

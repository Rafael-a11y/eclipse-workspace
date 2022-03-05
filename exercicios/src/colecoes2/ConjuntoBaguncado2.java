package colecoes2;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBaguncado2 {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		HashSet conjunto = new HashSet();
		
		conjunto.add(1.2);
		conjunto.add(true);
		conjunto.add("Teste");
		conjunto.add(1);
		conjunto.add('x');
		
		System.out.println("O tamanho é de " + conjunto.size() + " elementos");
		System.out.println(conjunto.add("Teste"));
		System.out.println(conjunto.add('x'));
		System.out.println("O tamanho é de " + conjunto.size() + " elementos");
		System.out.println(conjunto.remove("teste"));
		System.out.println(conjunto.remove("Teste"));
		System.out.println(conjunto.remove('x'));
		System.out.println("O tamanho é de " + conjunto.size() + " elementos");
		System.out.println(conjunto.contains('x'));
		System.out.println(conjunto.contains(1));
		System.out.println(conjunto.contains(true));
		
		
		Set<Integer> nums = new HashSet();
		
		nums.add(3);
		nums.add(1);
		nums.add(2);
		System.out.println(nums);
		System.out.println(conjunto);
//		System.out.println(conjunto.addAll(nums));
		System.out.println(conjunto);
		System.out.println(nums);
		System.out.println(conjunto.retainAll(nums));
		System.out.println(conjunto);
		System.out.println(nums);
		conjunto.clear();
		System.out.println(conjunto);
		for(int numeros : nums) {
			System.out.println(numeros);
		}

		
		
	}

}

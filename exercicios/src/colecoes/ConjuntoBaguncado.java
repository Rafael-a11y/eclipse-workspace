package colecoes;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBaguncado {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		HashSet conjunto = new HashSet();
		
		conjunto.add(1.2);		//double -> Double
		conjunto.add(true);		//boolean -> Boolean
		conjunto.add("Teste");	//String
		conjunto.add(1);		//int -> Integer
		conjunto.add('x');		//char -> Character
		
		System.out.println("O tamanho é " + conjunto.size());
		conjunto.add("Teste");
		conjunto.add('x');
		
		System.out.println("O tamanho é " + conjunto.size());
		
		System.out.println(conjunto.remove("teste")); 	//Dentro do System.out.println, imprime um valor boolean,
		System.out.println(conjunto.remove("Teste"));	//remove um valor.
		System.out.println(conjunto.remove('x'));
		System.out.println("O tamanho é " + conjunto.size());
		System.out.println(conjunto.contains('x'));		//Dentro do System.out.println, imprime um valor boolean
		System.out.println(conjunto.contains(1));		//verificando se o valor existe dentro do hash
		System.out.println(conjunto.contains(true));
		
		Set nums = new HashSet();						//Precisa ser importado, java.util
		
		nums.add(1);
		nums.add(2);
		nums.add(3); 
		System.out.println(nums);
		System.out.println(conjunto);
		
//		conjunto.addAll(nums);							//Pega tudo que está dentro de nums e põe em conjunto
		
		conjunto.retainAll(nums);						//Faz com que apenas o valor em comum entre nums e conjunto
														//seja mantido dentro de conjunto, no caso, mas sem alterar
														//nums que continua igual
		System.out.println(nums);
		System.out.println(conjunto);	
		
		conjunto.clear();								//Limpa o conjunto.
		System.out.println(conjunto);
		
		
		
		
		
		
		
		/*Diferentemente do array, collection usa size() ao invés de length, não aceitam repetições.
		 *  */
	}

}

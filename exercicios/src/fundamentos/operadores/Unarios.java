package fundamentos.operadores;

public class Unarios {
	
	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		
		a++;	//a = a + 1;
		a--;	//a = a - 1;
		
		++b;	//b = b - 1;
		--b;	//b = b - 1;
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("Mini Desafio");
		System.out.println(++a == b--);
		System.out.println(a == b);
		System.out.println(a);
		System.out.println(b);
		
		/*
		 * Operador unário préfixado e pósfixado.
		 * Operador de incremento préfixado tem precedência ao 
		 * operador de comparação, que tem precedência 
		 * sobre o operador de encremento pósfixado
		 */
		
		
	}

}

package fundamentos.operadores;

public class Logicos {
	
	public static void main(String[] args) {
		
		boolean condicao1 = true;
		boolean condicao2 = (3 + 7 == 10);
		
		System.out.println(condicao1 && condicao2);
		
		System.out.println("\nTabela verdade E (And)\n");
		System.out.print("Verdadeiro E Verdadeiro: ");
		System.out.println(true && true);
		System.out.print("Verdadeiro E Falso: ");
		System.out.println(true && false);
		System.out.print("Falso E Verdadeiro: ");
		System.out.println(false && true);
		System.out.print("Falso E Falso: ");
		System.out.println(false && false);
		
		
		System.out.println("\nTabela verdade OU (OR)\n");
		System.out.print("Verdadeiro OU Verdadeiro: ");
		System.out.println(true || true);
		System.out.print("Verdadeiro OU Falso: ");
		System.out.println(true || false);
		System.out.print("Falso OU Verdadeiro: ");
		System.out.println(false || true);
		System.out.print("Falso OU Falso: ");
		System.out.println(false || false);
		
		
		System.out.println("\nTabela verdade OU EXCLUSIVO (XOR)\n");
		System.out.print("Verdadeiro OU EXCLUSIVO Verdadeiro: ");
		System.out.println(true ^ true);
		System.out.print("Verdadeiro OU EXCLUSIVO Falso: ");
		System.out.println(true ^ false);
		System.out.print("Falso OU EXCLUSIVO Verdadeiro: ");
		System.out.println(false ^ true);
		System.out.print("Falso OU EXCLUSIVO Falso: ");
		System.out.println(false ^ false);
		
		
		System.out.println("\nTabela verdade NÃO (NOT)\n");
		System.out.print("NÃO Verdadeiro: ");
		System.out.println(!true);
		System.out.print("NÃO Falso: ");
		System.out.println(!false);
	
		
		/*
		 * && and
		 * || or
		 * ^  xor
		 * !  not
		 * !! double negation
		 */
	}

}

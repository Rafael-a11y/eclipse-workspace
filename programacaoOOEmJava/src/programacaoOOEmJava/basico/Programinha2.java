package programacaoOOEmJava.basico;

public class Programinha2 {

	public static void main(String[] args) {
		
		int umNumero = 3;
		if(umNumero >= 0) {
			if(umNumero == 0)
				System.out.println("Primeira String");
			else
				System.out.println("Segunda String");
			System.out.println("Terceira String");
		}
		//Se a vari�vel for 3, ele imprime 2� frase, e imprime a 3� frase tamb�m, pois embora caia no caso contr�rio, o 3�
		//System.out.println() est� dentro do escopo do if externo.
			
		
	}

}

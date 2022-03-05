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
		//Se a variável for 3, ele imprime 2ª frase, e imprime a 3ª frase também, pois embora caia no caso contrário, o 3º
		//System.out.println() está dentro do escopo do if externo.
			
		
	}

}

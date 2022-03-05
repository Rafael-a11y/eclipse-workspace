package fundamentos.operadores;

public class Desafiologico {

	public static void main(String[] args) {
		
		boolean trabalho1 = true;
		boolean trabalho2 = true;
		boolean comprouTv50 = trabalho1 && trabalho2;
		boolean comprouTv32 = trabalho1 ^ trabalho2;
		boolean comprouSorvete = trabalho1 || trabalho2;
		boolean ficouSaudavel = !comprouSorvete;
		
		System.out.println("Comprou tv de 50 polegadas? " + comprouTv50);
		System.out.println("Comprou tv de 32 polegadas? " + comprouTv32);
		System.out.println("Comprou sorvete? " + comprouSorvete);
		System.out.println("Ficou mais saudável? " + ficouSaudavel);
		
		
	}
}

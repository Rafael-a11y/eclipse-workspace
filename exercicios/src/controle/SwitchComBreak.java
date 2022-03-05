package controle;

import java.util.Scanner;

public class SwitchComBreak {
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in);
		String conceito = "";
		System.out.print("Informe a nota: ");
		int nota = entrada.nextInt();
		switch (nota) {
		case 10 : case 9 :
			conceito = "A";
		break;
		case 8 : case 7 :
			conceito = "B";
		break;
		case 6 : case 5 :
			conceito = "C";
		break;
		case 4 : case 3 :
			conceito = "D";
		break;
		case 2 : case 1 : case 0 :
			conceito = "E";
			break;
			default :  conceito = "Conceito n�o informado";
		
			
		}
		System.out.print("\nConceito � " + conceito);
		entrada.close();
	}
	/*
	 * O defalt n�o precisa estar na �ltima linha, mas por conven��o � posicionado na �ltima linha do switch, os 'case' tamb�m podem ficar um 
	 * embaixo do outro
	 */

}

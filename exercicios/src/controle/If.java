package controle;

import java.util.Scanner;

public class If {
public static void main(String[] args) {
	
	Scanner entrada = new Scanner (System.in);
	System.out.print("Entre com a média :");
	double media = entrada.nextDouble();
	if (media <= 10 && media >= 7) {
		System.out.print ("Aprovado");
	}
	else if (media <= 7 && media>= 4.5 ) {
		System.out.print("\nRecuperação");
	}
	boolean criterioDeReprovacaoAtingido = 
			media < 4.5 && media>= 0;
			if (criterioDeReprovacaoAtingido) {
				System.out.println("reprovado");
			}
	entrada.close();
}
}/*
Usar Else if é melhor, pois, assim que o critério é atingido, os outros ifs, não são lidos
*/

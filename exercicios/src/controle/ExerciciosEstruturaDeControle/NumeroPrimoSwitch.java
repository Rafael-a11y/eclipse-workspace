package controle.ExerciciosEstruturaDeControle;

import java.util.Scanner;

public class NumeroPrimoSwitch {public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	System.out.print("Entre com um n�mero inteiro: ");
	int numero = entrada.nextInt();
	switch (numero){
		case 2: case 3: case 5: case 7:   System.out.println("1N�mero primo");break;
		default : boolean requisito = (numero % 2 != 0 && numero % 3 != 0 && numero % 5 != 0 && numero % 7 != 0);
		 if (requisito == true) {
			 System.out.println("2N�mero primo");
		}
		 else {
			 System.out.println("N�mero n�o primo");
		 }
	}
	entrada.close();
}

}

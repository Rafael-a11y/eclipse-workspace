package controle;

import java.util.Scanner;

public class DesafioDiaSemana {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner (System.in);
		System.out.print("Entre com o dia de semana: ");
		String diaSemana = entrada.next();
		
		
		
		if ( "domingo".equalsIgnoreCase(diaSemana)) {
			
			System.out.println("1");
			
		}
		
		else if ("segunda".equalsIgnoreCase(diaSemana)) {
			
			System.out.println("2");
		}
		
		else if ("terça".equalsIgnoreCase(diaSemana) ||
				"terca".equalsIgnoreCase(diaSemana)) {
			
			System.out.println("3");
		}
		
		else if ("quarta".equalsIgnoreCase(diaSemana)) {
			
			System.out.println("4");
		}
		
		else if ("quinta".equalsIgnoreCase(diaSemana)) {
			
			System.out.println("5");
		}
		
		else if ("sexta".equalsIgnoreCase(diaSemana)) {
			
			System.out.println("6");
				
			}
			
		else if ("sábado".equalsIgnoreCase(diaSemana) ||
				"sabado".equalsIgnoreCase(diaSemana)) {
				
				System.out.println("7");
			}
			
		else {
			
			System.out.println("burro");
			
		}
		
		entrada.close();
		
	}
	
}

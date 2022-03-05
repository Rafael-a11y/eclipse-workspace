package fundamentos;

import javax.swing.JOptionPane;

public class ConversaoStringNumero {
	
	public static void main(String[] args) {
		String valor1 = JOptionPane.showInputDialog("Digite o primeiro número: ");
		
		String valor2 = JOptionPane.showInputDialog("Digite o segundo número: ");
		String valor3 = JOptionPane.showInputDialog("Digite o terceiro número: ");
		String valor4 = JOptionPane.showInputDialog("Digite o quarto número: ");
		double numero4 = Double.parseDouble(valor4);
		double numero3 = Double.parseDouble(valor3);
		double numero1 = Double.parseDouble(valor1);
		double numero2 = Double.parseDouble(valor2);
		double soma = numero1 + numero2;
		System.out.println("A soma é " + soma);
		System.out.println("A média é " + soma / 2);
		
		/*
		 * Na linha 8 e 10, as variáveis valor1 e valor2 recebem 
		 * o JOptionPane.showInputDialog, lembrando que é necessário
		 * dar um import.
		 * Nas linhas 15 e 16, as variáveis do tipo double de nome
		 * numero1 e numero2 recebem os valores de valor1 e valor2
		 * respectivamente, com a conversão para o wrapper Double.
		 *  
		 */
		
	}
}

package fundamentos;

import javax.swing.JOptionPane;

public class ConversaoStringNumero {
	
	public static void main(String[] args) {
		String valor1 = JOptionPane.showInputDialog("Digite o primeiro n�mero: ");
		
		String valor2 = JOptionPane.showInputDialog("Digite o segundo n�mero: ");
		String valor3 = JOptionPane.showInputDialog("Digite o terceiro n�mero: ");
		String valor4 = JOptionPane.showInputDialog("Digite o quarto n�mero: ");
		double numero4 = Double.parseDouble(valor4);
		double numero3 = Double.parseDouble(valor3);
		double numero1 = Double.parseDouble(valor1);
		double numero2 = Double.parseDouble(valor2);
		double soma = numero1 + numero2;
		System.out.println("A soma � " + soma);
		System.out.println("A m�dia � " + soma / 2);
		
		/*
		 * Na linha 8 e 10, as vari�veis valor1 e valor2 recebem 
		 * o JOptionPane.showInputDialog, lembrando que � necess�rio
		 * dar um import.
		 * Nas linhas 15 e 16, as vari�veis do tipo double de nome
		 * numero1 e numero2 recebem os valores de valor1 e valor2
		 * respectivamente, com a convers�o para o wrapper Double.
		 *  
		 */
		
	}
}

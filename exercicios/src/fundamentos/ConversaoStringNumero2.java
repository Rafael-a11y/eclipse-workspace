package fundamentos;

import javax.swing.JOptionPane;

public class ConversaoStringNumero2 {

	public static void main(String[] args) {
		
		String valor1 = JOptionPane.showInputDialog("Entre com um n�mero: ");
		String valor2 = JOptionPane.showInputDialog("Entre com um segundo n�mero: ");
		
		double numero1 = Double.parseDouble(valor1);
		double numero2 = Double.parseDouble(valor2);
		double soma = numero1 + numero2;
		System.out.println("A soma � " + soma);
		
	}
}

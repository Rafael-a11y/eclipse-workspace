package BlocoNotas;

import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		
		List<String> notas = new ArrayList<String>();
		notas.add("Minha primeira anotação :)");
		boolean continua = true;
		
		while(continua == true) {
			String entrada = JOptionPane.showInputDialog("Escolha uma das opções listadas abaixo"
					+ "\n 1- lista as notas\n2 - adiciona uma nova nota\n3 - seta uma nota"
					+ "\n4 - exclui uma nota\n5 - Continua a escrever uma nota\n6 - sair");
			switch (entrada) {
			case "1" :  System.out.println(notas);
			System.out.println("----------------------------------------"
					+ "-------------------------------------------------");		
			break;
			
			case "2" : String anotacao = JOptionPane.showInputDialog("Digite a anotação");
					   notas.add(anotacao);
				break;
			
			case "3" : notas.set(0, JOptionPane.showInputDialog("Entre com a nova anotação"));
			 	break;
			 	
			case "4" : notas.remove(0);
			
				break;
			
			case "5" : String concat = notas.get(0).concat("oioioi"); notas.set(0, concat);	
			
				break;
				
			case "6" : continua = false;
			
				break;
			
			default : JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
		JOptionPane.showMessageDialog(null, "Fim do programa");
	}
}

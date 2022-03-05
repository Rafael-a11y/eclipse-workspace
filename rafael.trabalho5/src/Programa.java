

import java.awt.EventQueue;

import visao.Tabela;

public class Programa {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> new Tabela().setVisible(true));
	}
}

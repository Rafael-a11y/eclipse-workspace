package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Principal extends JFrame{

	public Principal() {
		construirUI();
	}
	public void construirUI() {
		this.setTitle("Exemplo simples");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		//Pode-se usar lambda aqui, pois o tipo que ele espera � um objeto que implementa,
		//ou seja, um Runnable, Runnable � uma interface funcional, por isso ao inv�s de
		//criarmos uma classe que implementa Runnable eimplementar o run(), ou criar
		//uma classe an�nima que implementa run(), usamos lambda.
		EventQueue.invokeLater(() -> {var principal = new Principal();
		principal.setVisible(true);});
	}
}

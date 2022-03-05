package swing.test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import swing.gerenciadores.FlowLayoutPanel;
//Janela que ter� o JPanel adicionado ao seu container
public class FlowLayoutTest extends JFrame{

	public FlowLayoutTest() {
		this.setTitle("FlowLayoutTest");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Onde definimos como conatiner o JPanel que usa FlowLayout como gerenciador
		this.getContentPane().add(new FlowLayoutPanel());
		this.pack();
	}
	
	public static void main(String[] args) {
		//N�o pode ter par�metro nem retornara nada pois o m�todo run() � void e sem
		//par�metro.
		EventQueue.invokeLater(() -> new FlowLayoutTest().setVisible(true));
	}
}

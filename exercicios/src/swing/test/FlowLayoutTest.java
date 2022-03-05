package swing.test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import swing.gerenciadores.FlowLayoutPanel;
//Janela que terá o JPanel adicionado ao seu container
public class FlowLayoutTest extends JFrame{

	public FlowLayoutTest() {
		this.setTitle("FlowLayoutTest");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Onde definimos como conatiner o JPanel que usa FlowLayout como gerenciador
		this.getContentPane().add(new FlowLayoutPanel());
		this.pack();
	}
	
	public static void main(String[] args) {
		//Não pode ter parâmetro nem retornara nada pois o método run() é void e sem
		//parâmetro.
		EventQueue.invokeLater(() -> new FlowLayoutTest().setVisible(true));
	}
}

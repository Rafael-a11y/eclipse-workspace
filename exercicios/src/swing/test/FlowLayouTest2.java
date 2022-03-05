package swing.test;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import swing.gerenciadores.FlowLayoutPanel2;

public class FlowLayouTest2 extends JFrame{

	private FlowLayouTest2() {
		initialize();
	}
	private void initialize() {
		this.setTitle("FlowLayoutTest2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new FlowLayoutPanel2());
		this.pack();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {new FlowLayouTest2().setVisible(true);});
	}
}

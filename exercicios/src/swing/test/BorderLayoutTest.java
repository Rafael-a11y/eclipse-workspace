package swing.test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import swing.gerenciadores.BorderLayoutPanel;

public class BorderLayoutTest extends JFrame{
	
	public BorderLayoutTest() {
		super("BorderLayoutTest");
		initiUI();
	}
	public void initiUI() {
		this.setDefaultCloseOperation(BorderLayoutTest.EXIT_ON_CLOSE);
		this.getContentPane().add(new BorderLayoutPanel());
		this.pack();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new BorderLayoutTest().setVisible(true));
	}
}

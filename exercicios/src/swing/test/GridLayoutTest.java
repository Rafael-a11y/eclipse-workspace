package swing.test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import swing.gerenciadores.GridLayoutPanel;

public class GridLayoutTest extends JFrame{

	public GridLayoutTest() {
		super("GridLayoutTest");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new GridLayoutPanel());
		this.pack();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new GridLayoutTest().setVisible(true);
			}
		});
	}
}

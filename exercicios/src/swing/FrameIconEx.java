package swing;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrameIconEx extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameIconEx() {
		initUI();
	}
	
	public void initUI() {
		ImageIcon webIcon = new ImageIcon("src/resources/meuAvatar.jpg");
		this.setIconImage(webIcon.getImage());
		this.setTitle("Ícone");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {var ex = new FrameIconEx(); ex.setVisible(true);});
	}
}

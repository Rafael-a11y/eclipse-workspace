package swing.gerenciadores;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
/*O gerenciador de layout BorderLayout é padrão para JFrames*/
public class BorderLayoutPanel extends JPanel{

	private BorderLayout layout;
	
	public BorderLayoutPanel() {
		initialize();
	}
	
	private void initialize() {
		this.setPreferredSize(new Dimension(400, 300));
		layout = new BorderLayout(0, 0);
		this.setLayout(layout);
		//Também há o add do JPanel onde o componente é adiiconado junto da sua posição na tela.
		this.add(new JButton("Center"), BorderLayout.CENTER);
		this.add(new JButton("West"), BorderLayout.WEST);
		this.add(new JButton("East"), BorderLayout.EAST);
		this.add(new JButton("North"), BorderLayout.NORTH);
		this.add(new JButton("South"), BorderLayout.SOUTH);
		
	}
}

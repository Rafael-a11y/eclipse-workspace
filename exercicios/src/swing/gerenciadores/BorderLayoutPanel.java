package swing.gerenciadores;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
/*O gerenciador de layout BorderLayout � padr�o para JFrames*/
public class BorderLayoutPanel extends JPanel{

	private BorderLayout layout;
	
	public BorderLayoutPanel() {
		initialize();
	}
	
	private void initialize() {
		this.setPreferredSize(new Dimension(400, 300));
		layout = new BorderLayout(0, 0);
		this.setLayout(layout);
		//Tamb�m h� o add do JPanel onde o componente � adiiconado junto da sua posi��o na tela.
		this.add(new JButton("Center"), BorderLayout.CENTER);
		this.add(new JButton("West"), BorderLayout.WEST);
		this.add(new JButton("East"), BorderLayout.EAST);
		this.add(new JButton("North"), BorderLayout.NORTH);
		this.add(new JButton("South"), BorderLayout.SOUTH);
		
	}
}

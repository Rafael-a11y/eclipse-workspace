package swing.gerenciadores;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridBagLayoutPanel extends JPanel{

	GridBagLayout layout;
	
	public GridBagLayoutPanel() {
		initialize();
	}
	
	public void initialize() {
		layout = new GridBagLayout();
		this.setLayout(layout);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		//Coluna 0, linha 0.
		this.add(new JButton("Primeiro"), gbc);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		this.add(new JButton("Segundo"), gbc2); //Coluna 1, linha 0.
	}
}

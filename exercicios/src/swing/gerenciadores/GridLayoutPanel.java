package swing.gerenciadores;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridLayoutPanel extends JPanel{

	GridLayout layout;
	
	public GridLayoutPanel() {
		initialize();
	}
	//Quando criamos um GridLayout sem parâmetros, este fica somente com uma linha e um
	//número indeterminado de colunas.
	private void initialize() {
		this.setPreferredSize(new Dimension(400, 500));
		//3 linhas e 2 colunas. 0 e 2 significa número de linhas ilimitado e duas colunas.
		layout = new GridLayout(3, 2);
		//Adicionando espaçamento esntre os componentes.
		layout.setHgap(10);
		layout.setVgap(10);
		this.setLayout(layout);
		this.add(new JButton("1"));
		this.add(new JButton("2"));
		this.add(new JButton("3"));
		this.add(new JButton("4"));
		this.add(new JButton("5"));
		this.add(new JButton("6"));
		this.add(new JButton("7"));
		this.add(new JButton("8"));
		this.add(new JButton("9"));
	}
	
}

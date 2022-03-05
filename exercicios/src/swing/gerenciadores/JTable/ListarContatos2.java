package swing.gerenciadores.JTable;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import swing.gerenciadores.GridLayoutPanel;

public class ListarContatos2 extends JFrame{

	JTable tabela;
	JPanel painelFundo;
	JScrollPane barraRolagem;
	
	Object[] colunas = {"nome", "telefone", "e-mails"};
	
	Object[][] dados = {{"Rafael Souto", "61 994143284", "rsowtto@gmail.com"},
			{"Israel Souto", "61 999993497", "israelmaster123@hotmail.com"},
			{"Bruno Sidney", "61 992066094", "brunostalone@outlook.com"}};
	
	public ListarContatos2() {
		super("contatos");
	}
	public void criarJanela() {
		tabela = new JTable(dados, colunas);
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(1, 1));
		painelFundo.add(barraRolagem);
		//VocÊ pode por um painél dentro de outro, os conatiners também usam gerenciadores
		//de layouts
//		this.getContentPane().setLayout(new GridLayout(1,1));
		this.getContentPane().add(painelFundo);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 120);
		this.setVisible(true);
		this.pack();
	}
	
	public static void main(String[] args) {
		ListarContatos2 lc = new ListarContatos2();
		lc.criarJanela();
	}
}
